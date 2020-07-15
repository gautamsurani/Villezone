package com.villezone.gautam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.databinding.ActivityLoginBinding;
import com.villezone.gautam.view.LoginView;
import com.villezone.gautam.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements LoginView {
    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setViewModel(new LoginViewModel(this));
        activityLoginBinding.executePendingBindings();
        activityLoginBinding.tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ForgotPasswordActivity.intent());
            }
        });

        activityLoginBinding.btnLoginViaOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(LoginViaOTPActivity.intent());
            }
        });
    }

    @Override
    public void onInvalidMobile() {
        activityLoginBinding.tvMobileNumber.setError("Please enter valid Mobile Number");
    }

    @Override
    public void onInvalidPassword() {
        activityLoginBinding.tvPassword.setError("Please enter valid Password");
    }

    @Override
    public void viewProgress() {
        activityLoginBinding.btnNext.setVisibility(View.GONE);
        activityLoginBinding.progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        activityLoginBinding.btnNext.setVisibility(View.VISIBLE);
        activityLoginBinding.progress.setVisibility(View.GONE);
    }

    @Override
    public void onSignUpClicked() {
        startActivity(SignupActivity.intent());
    }

    @Override
    public void onLoginSuccess() {
        startActivity(HomeActivity.intent());
        finish();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(App.get(), message, Toast.LENGTH_LONG).show();
    }

    public static Intent intent() {
        return new Intent(App.get(), LoginActivity.class);
    }
}
