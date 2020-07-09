package com.villezone.gautam.view;

public interface LoginView {
    void onInvalidMobile();
    void onInvalidPassword();
    void viewProgress();
    void hideProgress();
    void onSignUpClicked();
    void onLoginSuccess();
    void showToast(String message);
}
