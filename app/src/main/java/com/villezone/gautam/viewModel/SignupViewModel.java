package com.villezone.gautam.viewModel;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.villezone.gautam.App;
import com.villezone.gautam.BR;
import com.villezone.gautam.model.AreaResponse;
import com.villezone.gautam.model.BaseModel;
import com.villezone.gautam.model.ErrorResponse;
import com.villezone.gautam.model.LoginResponse;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.HttpUtil;
import com.villezone.gautam.view.SignupView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignupViewModel extends BaseObservable {

    private SignupView signupView;
    String name, mobile_number, address, email, password, area_id, pin_code, otp, landmark;

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
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
        notifyPropertyChanged(BR.otp);
    }

    @Bindable
    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
        notifyPropertyChanged(BR.landmark);
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public SignupViewModel(SignupView signupView) {
        this.signupView = signupView;
        getArea();
    }

    private void getArea() {
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<AreaResponse> call = apiInterface.getArea();
        call.enqueue(new Callback<AreaResponse>() {
            @Override
            public void onResponse(@NonNull Call<AreaResponse> call, @NonNull Response<AreaResponse> response) {
                if (response.body() != null) {
                    signupView.onAreaReceived(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<AreaResponse> call, @NonNull Throwable t) {

            }
        });
    }

    public void onSignupClicked() {
        boolean canNext = true;
        if (!isMobileValid()) {
            canNext = false;
            signupView.onInvalidMobile();
        }
        if (!isNameValid()) {
            canNext = false;
            signupView.onInvalidName();
        }
        if (!isEmailValid()) {
            canNext = false;
            signupView.onInvalidEmail();
        }
        if (!isAddressValid()) {
            canNext = false;
            signupView.onInvalidAddress();
        }
        if (!isLandmarkValid()) {
            canNext = false;
            signupView.onInvalidLandmark();
        }
        if (!isAreaValid()) {
            canNext = false;
            signupView.onInvalidArea();
        }
        if (!isPincodeValid()) {
            canNext = false;
            signupView.onInvalidPincode();
        }
        if (!isPasswordValid()) {
            canNext = false;
            signupView.onInvalidPassword();
        }
        if (canNext) {
            createAccount();
        }
    }

    public void onSignInClicked() {
        signupView.onSignInClick();
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
        Call<BaseModel> call = apiInterface.sendOTP(mobile_number);
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
        Call<BaseModel> call = apiInterface.submitOTP(mobile_number, otp);
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
        address = getAddress() + ", " + getLandmark();
        signupView.showSubmitInfoProgress();
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<LoginResponse> call = apiInterface.signup(name
                , mobile_number
                , address
                , email
                , password
                , area_id
                , pin_code);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                signupView.hideSubmitInfoProgress();
                if (response.body() != null) {
                    setToastMessage(response.body().getData().getMessage());
                    String authToken = response.body().getData().getAccess_token();
                    App.getPreference().setUserDetails(response.body().getData().getUser_detail());
                    App.getPreference().setAuthToken(authToken);
                    setToastMessage(response.body().getData().getMessage());
                    signupView.infoSubmitSuccess();
                } else {
                    setToastMessage("Failed to create account");
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                signupView.hideSubmitInfoProgress();
                setToastMessage("Failed to create account");
            }
        });
    }

    private void setToastMessage(String message) {
        signupView.showToast(message);
    }

    private boolean isPasswordValid() {
        return !TextUtils.isEmpty(getUserPassword()) && getUserPassword().length() > 7;
    }

    public boolean isMobileValid() {
        return !TextUtils.isEmpty(getMobileNumber()) && getMobileNumber().length() == 10;
    }

    public boolean isNameValid() {
        return !TextUtils.isEmpty(getName());
    }

    public boolean isEmailValid() {
        return !TextUtils.isEmpty(getEmail());
    }

    public boolean isAddressValid() {
        return !TextUtils.isEmpty(getAddress());
    }

    private boolean isLandmarkValid() {
        return !TextUtils.isEmpty(getLandmark());
    }

    public boolean isAreaValid() {
        return !TextUtils.isEmpty(getArea_id());
    }

    public boolean isPincodeValid() {
        return !TextUtils.isEmpty(getPin_code());
    }

    public boolean isOTPValid() {
        return !TextUtils.isEmpty(getOtp());
    }
}