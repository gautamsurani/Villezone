package com.villezone.gautam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.databinding.ActivityForgotPasswordBinding;
import com.villezone.gautam.view.ForgotPasswordView;
import com.villezone.gautam.viewModel.ForgotPasswordViewModel;

public class ForgotPasswordActivity extends AppCompatActivity implements ForgotPasswordView {

    ActivityForgotPasswordBinding activityForgotPasswordBinding;
    ForgotPasswordViewModel signupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityForgotPasswordBinding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password);
        signupViewModel = new ForgotPasswordViewModel(this);
        activityForgotPasswordBinding.setViewModel(signupViewModel);
        activityForgotPasswordBinding.executePendingBindings();
    }

    @Override
    public void onInvalidMobile() {
        activityForgotPasswordBinding.tvMobileNumber.setError("Please enter valid Mobile Number");
    }

    @Override
    public void onInvalidOTP() {
        activityForgotPasswordBinding.tvOTP.setError("Please enter OTP");
    }

    @Override
    public void onInvalidPassword() {
        activityForgotPasswordBinding.tvPassword.setError("Password length must be 8 character or more");
    }

    @Override
    public void onInvalidConfirmPassword() {
        activityForgotPasswordBinding.tvConfirmPassword.setError("Password and confirm password does not match");
    }

    @Override
    public void showSendOtpProgress() {
        activityForgotPasswordBinding.progressVerify.setVisibility(View.VISIBLE);
        activityForgotPasswordBinding.btnVerify.setVisibility(View.GONE);
    }

    @Override
    public void hideSendOtpProgress() {
        activityForgotPasswordBinding.progressVerify.setVisibility(View.GONE);
        activityForgotPasswordBinding.btnVerify.setVisibility(View.VISIBLE);

    }

    @Override
    public void otpSendSuccess() {
        activityForgotPasswordBinding.llMobilVerifyBox.setVisibility(View.GONE);
        activityForgotPasswordBinding.llOTPBox.setVisibility(View.VISIBLE);
        activityForgotPasswordBinding.TILOTP.requestFocus();
    }

    @Override
    public void otpSendFail() {
        activityForgotPasswordBinding.llMobilVerifyBox.setVisibility(View.VISIBLE);
        activityForgotPasswordBinding.llOTPBox.setVisibility(View.GONE);
    }

    @Override
    public void showSubmitOtpProgress() {
        activityForgotPasswordBinding.progressOTP.setVisibility(View.VISIBLE);
        activityForgotPasswordBinding.btnOTPSubmit.setVisibility(View.GONE);
    }

    @Override
    public void hideSubmitOtpProgress() {
        activityForgotPasswordBinding.progressOTP.setVisibility(View.GONE);
        activityForgotPasswordBinding.btnOTPSubmit.setVisibility(View.VISIBLE);
    }

    @Override
    public void otpSubmitSuccess() {
        activityForgotPasswordBinding.llOTPBox.setVisibility(View.GONE);
        activityForgotPasswordBinding.llInfoBox.setVisibility(View.VISIBLE);
    }

    @Override
    public void otpSubmitFail() {
        activityForgotPasswordBinding.llOTPBox.setVisibility(View.VISIBLE);
        activityForgotPasswordBinding.llInfoBox.setVisibility(View.GONE);
    }

    @Override
    public void showSubmitInfoProgress() {
        activityForgotPasswordBinding.progressInfo.setVisibility(View.VISIBLE);
        activityForgotPasswordBinding.btnInfoSubmit.setVisibility(View.GONE);
    }

    @Override
    public void hideSubmitInfoProgress() {
        activityForgotPasswordBinding.progressInfo.setVisibility(View.GONE);
        activityForgotPasswordBinding.btnInfoSubmit.setVisibility(View.VISIBLE);
    }

    @Override
    public void infoSubmitSuccess() {
        finish();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(App.get(), message, Toast.LENGTH_LONG).show();
    }

    public static Intent intent() {
        return new Intent(App.get(), ForgotPasswordActivity.class);
    }
}
