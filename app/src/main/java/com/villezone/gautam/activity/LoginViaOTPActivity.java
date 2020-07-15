package com.villezone.gautam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.databinding.ActivityLoginViaOTPBinding;
import com.villezone.gautam.view.LoginOTPView;
import com.villezone.gautam.viewModel.LoginOTPViewModel;

public class LoginViaOTPActivity extends AppCompatActivity implements LoginOTPView {

    ActivityLoginViaOTPBinding activityLoginViaOTPBinding;
    LoginOTPViewModel signupViewModel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginViaOTPBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_via_o_t_p);
        signupViewModel = new LoginOTPViewModel(this);
        activityLoginViaOTPBinding.setViewModel(signupViewModel);
        activityLoginViaOTPBinding.executePendingBindings();
    }

    @Override
    public void onInvalidMobile() {
        activityLoginViaOTPBinding.tvMobileNumber.setError("Please enter valid Mobile Number");
    }

    @Override
    public void onInvalidOTP() {
        activityLoginViaOTPBinding.tvOTP.setError("Please enter OTP");
    }

    @Override
    public void showSendOtpProgress() {
        activityLoginViaOTPBinding.progressVerify.setVisibility(View.VISIBLE);
        activityLoginViaOTPBinding.btnVerify.setVisibility(View.GONE);
    }

    @Override
    public void hideSendOtpProgress() {
        activityLoginViaOTPBinding.progressVerify.setVisibility(View.GONE);
        activityLoginViaOTPBinding.btnVerify.setVisibility(View.VISIBLE);

    }

    @Override
    public void otpSendSuccess() {
        activityLoginViaOTPBinding.llMobilVerifyBox.setVisibility(View.GONE);
        activityLoginViaOTPBinding.llOTPBox.setVisibility(View.VISIBLE);
        activityLoginViaOTPBinding.TILOTP.requestFocus();
    }

    @Override
    public void otpSendFail() {
        activityLoginViaOTPBinding.llMobilVerifyBox.setVisibility(View.VISIBLE);
        activityLoginViaOTPBinding.llOTPBox.setVisibility(View.GONE);
    }

    @Override
    public void showSubmitOtpProgress() {
        activityLoginViaOTPBinding.progressOTP.setVisibility(View.VISIBLE);
        activityLoginViaOTPBinding.btnOTPSubmit.setVisibility(View.GONE);
    }

    @Override
    public void hideSubmitOtpProgress() {
        activityLoginViaOTPBinding.progressOTP.setVisibility(View.GONE);
        activityLoginViaOTPBinding.btnOTPSubmit.setVisibility(View.VISIBLE);
    }

    @Override
    public void otpSubmitSuccess() {
        startActivity(HomeActivity.intent());
        finish();
    }

    @Override
    public void otpSubmitFail() {
        activityLoginViaOTPBinding.llOTPBox.setVisibility(View.VISIBLE);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(App.get(), message, Toast.LENGTH_LONG).show();
    }

    public static Intent intent() {
        return new Intent(App.get(), LoginViaOTPActivity.class);
    }
}
