package com.villezone.gautam.view;

public interface LoginOTPView {
    void onInvalidMobile();
    void onInvalidOTP();

    void showSendOtpProgress();
    void hideSendOtpProgress();
    void otpSendSuccess();
    void otpSendFail();

    void showSubmitOtpProgress();
    void hideSubmitOtpProgress();
    void otpSubmitSuccess();
    void otpSubmitFail();

    void showToast(String message);
}
