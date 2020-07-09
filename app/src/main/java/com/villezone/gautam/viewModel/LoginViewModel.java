package com.villezone.gautam.viewModel;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.villezone.gautam.App;
import com.villezone.gautam.BR;
import com.villezone.gautam.model.LoginResponse;
import com.villezone.gautam.model.User;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.HttpUtil;
import com.villezone.gautam.view.LoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginViewModel extends BaseObservable {

    private User user;
    private LoginView loginView;

    public void setMobileNumber(String mobileNumber) {
        user.setMobileNo(mobileNumber);
        notifyPropertyChanged(BR.mobileNumber);
    }

    @Bindable
    public String getMobileNumber() {
        return user.getMobileNo();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel(LoginView loginView) {
        user = new User("", "");
        this.loginView = loginView;
    }

    public void onLoginClicked() {
        boolean canNext = true;
        if (!isMobileValid()) {
            canNext = false;
            loginView.onInvalidMobile();
        }
        if (!isPasswordValid()) {
            canNext = false;
            loginView.onInvalidPassword();
        }
        if (canNext) {
            createAccount();
        }
    }

    public void onSignUpClicked() {
        loginView.onSignUpClicked();
    }

    private void createAccount() {
        loginView.viewProgress();
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<LoginResponse> call = apiInterface.login(user.getMobileNo(), user.getPassword());
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if (response.body() != null) {
                    String authToken = response.body().getData().getAccess_token();
                    App.getPreference().setUserDetails(response.body().getData().getUser_detail());
                    App.getPreference().setAuthToken(authToken);
                    setToastMessage(response.body().getData().getMessage());
                    loginView.onLoginSuccess();
                } else {
                    HttpUtil.handleError(response);
                }
                loginView.hideProgress();
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                setToastMessage(t.getLocalizedMessage());
                loginView.hideProgress();
            }
        });
    }

    private void setToastMessage(String message) {
        loginView.showToast(message);
    }

    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(getUserPassword());
    }

    private boolean isMobileValid() {
        return !TextUtils.isEmpty(getMobileNumber()) && getMobileNumber().length() == 10;
    }
}