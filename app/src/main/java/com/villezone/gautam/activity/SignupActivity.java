package com.villezone.gautam.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.databinding.ActivitySignupBinding;
import com.villezone.gautam.model.AreaData;
import com.villezone.gautam.model.AreaResponse;
import com.villezone.gautam.view.SignupView;
import com.villezone.gautam.viewModel.SignupViewModel;

import java.util.List;

public class SignupActivity extends AppCompatActivity implements SignupView {

    ActivitySignupBinding activitySignupBinding;
    SignupViewModel signupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignupBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        signupViewModel = new SignupViewModel(this);
        activitySignupBinding.setViewModel(signupViewModel);
        activitySignupBinding.executePendingBindings();

        activitySignupBinding.tvTAndC.setMovementMethod(LinkMovementMethod.getInstance());

        activitySignupBinding.areaDropdown.setFocusable(false);
        activitySignupBinding.areaDropdown.setFocusableInTouchMode(false);
        activitySignupBinding.areaDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = areas[i];
                activitySignupBinding.pincodeDropdown.setText("");
                signupViewModel.setPin_code("");
                setPincode(value);
            }
        });

        activitySignupBinding.pincodeDropdown.setFocusable(false);
        activitySignupBinding.pincodeDropdown.setFocusableInTouchMode(false);
        activitySignupBinding.pincodeDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                signupViewModel.setPin_code(pincodes[i]);
            }
        });

    }

    private void setPincode(String area) {
        for (int i = 0; i < areaData.size(); i++) {
            if (areaData.get(i).getName().equals(area)) {
                pincodes = areaData.get(i).getPincode();
                signupViewModel.setArea_id(areaData.get(i).getId());
                setPincodeAdapter();
                break;
            }
        }
    }

    private void setPincodeAdapter() {
        ArrayAdapter<String> adapterPincode = new ArrayAdapter<>(App.get(),
                R.layout.dropdown_menu_popup_item,
                pincodes);
        activitySignupBinding.pincodeDropdown.setAdapter(adapterPincode);
    }

    @Override
    public void onInvalidMobile() {
        activitySignupBinding.tvMobileNumber.setError("Please enter valid Mobile Number");
    }

    @Override
    public void onInvalidOTP() {
        activitySignupBinding.tvOTP.setError("Please enter OTP");
    }

    @Override
    public void onInvalidPassword() {
        activitySignupBinding.tvPassword.setError("Password length must be 8 character or more");
    }

    @Override
    public void onInvalidName() {
        activitySignupBinding.tvName.setError("Please enter Name");
    }

    @Override
    public void onInvalidEmail() {
        activitySignupBinding.tvEmail.setError("Please enter Email");
    }

    @Override
    public void onInvalidAddress() {
        activitySignupBinding.tvAddress.setError("Please enter Address");
    }

    @Override
    public void onInvalidArea() {
        activitySignupBinding.areaDropdown.setError("Please select Area");
    }

    @Override
    public void onInvalidPincode() {
        activitySignupBinding.pincodeDropdown.setError("Please select Pincode");
    }

    @Override
    public void showSendOtpProgress() {
        activitySignupBinding.progressVerify.setVisibility(View.VISIBLE);
        activitySignupBinding.btnVerify.setVisibility(View.GONE);
    }

    @Override
    public void hideSendOtpProgress() {
        activitySignupBinding.progressVerify.setVisibility(View.GONE);
        activitySignupBinding.btnVerify.setVisibility(View.VISIBLE);

    }

    @Override
    public void otpSendSuccess() {
        activitySignupBinding.llMobilVerifyBox.setVisibility(View.GONE);
        activitySignupBinding.llOTPBox.setVisibility(View.VISIBLE);
        activitySignupBinding.TILOTP.requestFocus();
    }

    @Override
    public void otpSendFail() {
        activitySignupBinding.llMobilVerifyBox.setVisibility(View.VISIBLE);
        activitySignupBinding.llOTPBox.setVisibility(View.GONE);
    }

    @Override
    public void showSubmitOtpProgress() {
        activitySignupBinding.progressOTP.setVisibility(View.VISIBLE);
        activitySignupBinding.btnOTPSubmit.setVisibility(View.GONE);
    }

    @Override
    public void hideSubmitOtpProgress() {
        activitySignupBinding.progressOTP.setVisibility(View.GONE);
        activitySignupBinding.btnOTPSubmit.setVisibility(View.VISIBLE);
    }

    @Override
    public void otpSubmitSuccess() {
        activitySignupBinding.llOTPBox.setVisibility(View.GONE);
        activitySignupBinding.llInfoBox.setVisibility(View.VISIBLE);
    }

    @Override
    public void otpSubmitFail() {
        activitySignupBinding.llOTPBox.setVisibility(View.VISIBLE);
        activitySignupBinding.llInfoBox.setVisibility(View.GONE);
    }

    @Override
    public void showSubmitInfoProgress() {
        activitySignupBinding.progressInfo.setVisibility(View.VISIBLE);
        activitySignupBinding.btnInfoSubmit.setVisibility(View.GONE);
    }

    @Override
    public void hideSubmitInfoProgress() {
        activitySignupBinding.progressInfo.setVisibility(View.GONE);
        activitySignupBinding.btnInfoSubmit.setVisibility(View.VISIBLE);
    }

    @Override
    public void infoSubmitSuccess() {
        startActivity(HomeActivity.intent());
        finish();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(App.get(), message, Toast.LENGTH_LONG).show();
    }

    String[] areas;
    String[] pincodes = new String[0];
    List<AreaData> areaData;

    @Override
    public void onAreaReceived(AreaResponse areaResponse) {
        areaData = areaResponse.getData();
        areas = new String[areaData.size()];
        for (int i = 0; i < areaData.size(); i++) {
            areas[i] = areaData.get(i).getName();
        }
        if (areaData.size() > 0) {
            pincodes = areaData.get(0).getPincode();
        }
        ArrayAdapter<String> adapterArea = new ArrayAdapter<>(App.get(),
                R.layout.dropdown_menu_popup_item,
                areas);
        activitySignupBinding.areaDropdown.setAdapter(adapterArea);
    }

    @Override
    public void onSignInClick() {
        onBackPressed();
    }

    public static Intent intent() {
        return new Intent(App.get(), SignupActivity.class);
    }

}
