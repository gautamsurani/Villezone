package com.villezone.gautam.view;

import com.villezone.gautam.model.AreaResponse;

public interface SignupView {
    void onInvalidMobile();
    void onInvalidOTP();
    void onInvalidPassword();
    void onInvalidName();
    void onInvalidEmail();
    void onInvalidAddress();
    void onInvalidArea();
    void onInvalidPincode();

    void showSendOtpProgress();
    void hideSendOtpProgress();
    void otpSendSuccess();
    void otpSendFail();

    void showSubmitOtpProgress();
    void hideSubmitOtpProgress();
    void otpSubmitSuccess();
    void otpSubmitFail();

    void showSubmitInfoProgress();
    void hideSubmitInfoProgress();
    void infoSubmitSuccess();

    void showToast(String message);
    void onAreaReceived(AreaResponse areaResponse);
    void onSignInClick();
}
