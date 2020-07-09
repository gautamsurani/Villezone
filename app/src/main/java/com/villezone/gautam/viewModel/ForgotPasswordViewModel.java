package com.villezone.gautam.viewModel;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.villezone.gautam.BR;
import com.villezone.gautam.model.BaseModel;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.HttpUtil;
import com.villezone.gautam.view.ForgotPasswordView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ForgotPasswordViewModel extends BaseObservable {

    private ForgotPasswordView signupView;
    String mobile_number, confirm_password, password, otp;

    public void setMobileNumber(String mobileNumber) {
        mobile_number = mobileNumber;
        notifyPropertyChanged(BR.mobileNumber);
    }

    @Bindable
    public String getMobileNumber() {
        return mobile_number;
    }

    @Bindable
    public String getUserPassword() {
        return password;
    }

    public void setUserPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.userPassword);
    }

    @Bindable
    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
        notifyPropertyChanged(BR.confirm_password);
    }

    @Bindable
    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
        notifyPropertyChanged(BR.otp);
    }

    public ForgotPasswordViewModel(ForgotPasswordView signupView) {
        this.signupView = signupView;
    }

    public void onSignupClicked() {
        boolean canNext = true;
        if (!isMobileValid()) {
            canNext = false;
            signupView.onInvalidMobile();
        }
        if (!isPasswordValid()) {
            canNext = false;
            signupView.onInvalidPassword();
        }
        if (!isConfirmPasswordValid()) {
            canNext = false;
            signupView.onInvalidConfirmPassword();
        }
        if (canNext) {
            createAccount();
        }
    }

    public void onVerifyClicked() {
        boolean canNext = true;
        if (!isMobileValid()) {
            canNext = false;
            signupView.onInvalidMobile();
        }
        if (canNext) {
            sendOtp();
        }
    }

    private void sendOtp() {
        signupView.showSendOtpProgress();
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.sendForgotOTP(mobile_number);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                signupView.hideSendOtpProgress();
                if (response.isSuccessful()) {
                    setToastMessage(response.body().getData().getMessage());
                    signupView.otpSendSuccess();
                } else {
                    HttpUtil.handleError(response);
                    signupView.otpSendFail();

                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                signupView.hideSendOtpProgress();
                signupView.otpSendFail();
            }
        });
    }

    public void onOTPSubmitClicked() {
        boolean canNext = true;
        if (!isOTPValid()) {
            canNext = false;
            signupView.onInvalidOTP();
        }
        if (canNext) {
            submitOTP();
        }
    }

    private void submitOTP() {
        signupView.showSubmitOtpProgress();
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.submitForgotOTP(mobile_number, otp);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                signupView.hideSubmitOtpProgress();
                if (response.isSuccessful()) {
                    setToastMessage(response.body().getData().getMessage());
                    signupView.otpSubmitSuccess();
                } else {
                    HttpUtil.handleError(response);
                    signupView.otpSubmitFail();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                signupView.hideSubmitOtpProgress();
                signupView.otpSubmitFail();
            }
        });
    }

    private void createAccount() {
        signupView.showSubmitInfoProgress();
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.forgotSubmit(mobile_number
                , password
                , confirm_password);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                signupView.hideSubmitInfoProgress();
                if (response.isSuccessful()) {
                    signupView.infoSubmitSuccess();
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                signupView.hideSubmitInfoProgress();
                setToastMessage(t.getLocalizedMessage());
            }
        });
    }

    private void setToastMessage(String message) {
        signupView.showToast(message);
    }

    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(getUserPassword()) && getUserPassword().length() > 7;
    }

    private boolean isConfirmPasswordValid() {
        return !TextUtils.isEmpty(getUserPassword()) && !TextUtils.isEmpty(getConfirm_password()) && getUserPassword().equals(getConfirm_password());
    }

    public boolean isMobileValid() {
        return !TextUtils.isEmpty(getMobileNumber()) && getMobileNumber().length() == 10;
    }

    public boolean isOTPValid() {
        return !TextUtils.isEmpty(getOtp());
    }
}