package com.villezone.gautam.rest;

public class ApiURLs {

    public static final String API_TOKEN = "Authorization";

    /* Account URLs*/
    public static final String VILLE_LOGIN_URL = "auth/login";
    public static final String VILLE_SIGNUP_URL = "auth/create/customer";
    public static final String VILLE_UPDATE_PROFILE = "customer/update/profile";
    public static final String VILLE_AREA = "area";
    public static final String VILLE_SEND_OTP = "auth/verify/mobile-number";
    public static final String VILLE_FORGOT_SEND_OTP = "auth/forgot/passowrd/verify/mobile-number";
    public static final String VILLE_LOGIN_SEND_OTP = "auth/otp-login/verify/mobile-number";
    public static final String VILLE_SUBMIT_OTP = "auth/verify/code";
    public static final String VILLE_FORGOT_SUBMIT_OTP = "auth/forgot/passowrd/verify/code";
    public static final String VILLE_SUBMIT_LOGIN_OTP = "auth/otp-login/verify/code";
    public static final String VILLE_FORGOT_SUBMIT = "auth/forgot/passowrd/update";
    public static final String VILLE_UPDATE_PASSWORD = "customer/update/password";
    public static final String VILLE_LOGOUT = "customer/logout";
    public static final String VILLE_CATEGORY = "category";
    public static final String VILLE_PRODUCTS = "product";
    public static final String VILLE_DASHBOARD_PRODUCTS = "dashboard/products";
    public static final String VILLE_SUB_CATEGORY = "sub-category";
    public static final String VILLE_ADD_TO_CART = "cart/product/add-to-cart";
    public static final String VILLE_GET_CART = "cart/get";
    public static final String VILLE_UPDATE_CART_ITEM = "cart/product-quantity/update";
    public static final String VILLE_PLACE_ORDER = "order/place";
    public static final String VILLE_LOCK_CART = "cart/lock";
    public static final String VILLE_UNLOCK_CART = "cart/unlock";
    public static final String VILLE_SEARCH = "product/search";
    public static final String VILLE_DELETE_CART_ITEM = "cart/product/delete";
    public static final String VILLE_ORDERS = "order/previous";
    public static final String VILLE_NOTIFICATION = "customer/notification/get-all";
    public static final String VILLE_ORDER_DETAIL = "order";
    public static final String VILLE_CANCEL_ORDER = "order/cancel";
    public static final String VILLE_SEND_FEEDBACK = "order/add/feedback";
    public static final String VILLE_DOWNLOAD_INVOICE = "order/get-invoice";
    public static final String VILLE_SEND_FCM_TOKEN = "customer/me";
}
