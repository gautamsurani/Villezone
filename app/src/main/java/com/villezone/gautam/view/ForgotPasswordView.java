package com.villezone.gautam.view;

public interface ForgotPasswordView {
    void onInvalidMobile();
    void onInvalidOTP();
    void onInvalidPassword();
    void onInvalidConfirmPassword();

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
}
