package com.villezone.gautam.rest;

import com.villezone.gautam.model.AllProductsResponse;
import com.villezone.gautam.model.AreaByIdResponse;
import com.villezone.gautam.model.AreaResponse;
import com.villezone.gautam.model.BaseModel;
import com.villezone.gautam.model.CartResponse;
import com.villezone.gautam.model.CategoryData;
import com.villezone.gautam.model.CategoryResponse;
import com.villezone.gautam.model.CustomerDetailResponse;
import com.villezone.gautam.model.DashboardResponse;
import com.villezone.gautam.model.LoginResponse;
import com.villezone.gautam.model.NotificationResponse;
import com.villezone.gautam.model.OrderDetailResponse;
import com.villezone.gautam.model.OrderResponse;
import com.villezone.gautam.model.ProductDetailResponse;
import com.villezone.gautam.model.ProductResponse;
import com.villezone.gautam.model.SearchResponse;
import com.villezone.gautam.model.SubCategoryResponse;
import com.villezone.gautam.model.UpdateProfileResponse;
import com.villezone.gautam.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    String CATEGORY_ID = "category_id";
    String PRODUCT_ID = "product_id";
    String AREA_ID = "area_id";
    String CART_PRODUCT_ID = "cartProductId";
    String ORDER_ID = "order_id";

    @POST(ApiURLs.VILLE_LOGIN_URL)
    Call<LoginResponse> login(@Query("mobile_number") String mobile_number
            , @Query("password") String password);

    @GET(ApiURLs.VILLE_AREA)
    Call<AreaResponse> getArea();

    @GET(ApiURLs.VILLE_AREA + "/{" + AREA_ID + "}")
    Call<AreaByIdResponse> getAreaById(@Path(AREA_ID) String area_id);

    @POST(ApiURLs.VILLE_SEND_OTP)
    Call<BaseModel> sendOTP(@Query("mobile_number") String mobile_number);

    @POST(ApiURLs.VILLE_FORGOT_SEND_OTP)
    Call<BaseModel> sendForgotOTP(@Query("mobile_number") String mobile_number);

    @POST(ApiURLs.VILLE_LOGIN_SEND_OTP)
    Call<BaseModel> sendLoginViaOTP(@Query("mobile_number") String mobile_number);

    @POST(ApiURLs.VILLE_SUBMIT_OTP)
    Call<BaseModel> submitOTP(@Query("mobile_number") String mobile_number
            , @Query("code") String code);

    @POST(ApiURLs.VILLE_FORGOT_SUBMIT_OTP)
    Call<BaseModel> submitForgotOTP(@Query("mobile_number") String mobile_number
            , @Query("code") String code);

    @POST(ApiURLs.VILLE_SUBMIT_LOGIN_OTP)
    Call<LoginResponse> submitLoginOTP(@Query("mobile_number") String mobile_number
            , @Query("code") String code);

    @POST(ApiURLs.VILLE_SIGNUP_URL)
    Call<LoginResponse> signup(@Query("name") String name
            , @Query("mobile_number") String mobile_number
            , @Query("address") String address
            , @Query("email") String email
            , @Query("password") String password
            , @Query("area_id") String area_id
            , @Query("pin_code") String pin_code);

    @POST(ApiURLs.VILLE_FORGOT_SUBMIT)
    Call<BaseModel> forgotSubmit(@Query("mobile_number") String mobile_number
            , @Query("password") String password
            , @Query("password_confirmation") String password_confirmation);

    @POST(ApiURLs.VILLE_UPDATE_PASSWORD)
    Call<BaseModel> updatePassword(@Query("old_password") String old_password
            , @Query("password") String password
            , @Query("password_confirmation") String password_confirmation);

    @POST(ApiURLs.VILLE_UPDATE_PROFILE)
    Call<UpdateProfileResponse> updateProfile(@Query("name") String name
            , @Query("address") String address
            , @Query("email") String email
            , @Query("area_id") String area_id
            , @Query("pin_code") String pin_code);

    @POST(ApiURLs.VILLE_LOGOUT)
    Call<Void> logout();

    @GET(ApiURLs.VILLE_CATEGORY)
    Call<CategoryResponse> getAllCategory();

    @GET(ApiURLs.VILLE_PRODUCTS)
    Call<AllProductsResponse> getAllProducts();

    @GET(ApiURLs.VILLE_PRODUCTS)
    Call<AllProductsResponse> getProductsByCatId(@Query("sub_category_id") String category_id
            , @Query("page") int page
            , @Query("sort_by") String sort_by);

    @GET(ApiURLs.VILLE_DASHBOARD_PRODUCTS)
    Call<DashboardResponse> getDashboardProducts();

    @GET(ApiURLs.VILLE_PRODUCTS + "/{" + PRODUCT_ID + "}")
    Call<ProductDetailResponse> getProductById(@Path(PRODUCT_ID) String product_id);

    @GET(ApiURLs.VILLE_CATEGORY + "/{" + CATEGORY_ID + "}")
    Call<SubCategoryResponse> getCategoryById(@Path(CATEGORY_ID) String category_id);

    @GET(ApiURLs.VILLE_SUB_CATEGORY + "/{" + CATEGORY_ID + "}")
    Call<SubCategoryResponse> getSubCategory(@Path(CATEGORY_ID) String category_id, @Query("sort_by") String sort_by);

    @GET(ApiURLs.VILLE_SUB_CATEGORY)
    Call<CategoryResponse> getSubCategoryById(@Query(CATEGORY_ID) String category_id, @Query("sort_by") String sort_by);

    @POST(ApiURLs.VILLE_ADD_TO_CART)
    Call<BaseModel> addToCart(@Query("product_id") String product_id
            , @Query("weight") String weight);

    @GET(ApiURLs.VILLE_GET_CART)
    Call<CartResponse> getCart();

    @GET(ApiURLs.VILLE_LOCK_CART)
    Call<BaseModel> lockCart();

    @GET(ApiURLs.VILLE_UNLOCK_CART)
    Call<BaseModel> unlockCart();

    @POST(ApiURLs.VILLE_UPDATE_CART_ITEM + "/{" + CART_PRODUCT_ID + "}")
    Call<BaseModel> updateCartItem(@Path(CART_PRODUCT_ID) String cartProductId,
                                   @Query("increment") String increment);

    @GET(ApiURLs.VILLE_DELETE_CART_ITEM + "/{" + CART_PRODUCT_ID + "}")
    Call<BaseModel> deleteCartItem(@Path(CART_PRODUCT_ID) String cartProductId);

    @POST(ApiURLs.VILLE_PLACE_ORDER)
    Call<BaseModel> placeOrder(@Query("payment_method") String payment_method
            , @Query("time_slot") String time_slot);

    @GET(ApiURLs.VILLE_SEARCH)
    Call<SearchResponse> search(@Query("keyword") String keyword);

    @GET(ApiURLs.VILLE_ORDERS)
    Call<OrderResponse> getAllOrders();

    @GET(ApiURLs.VILLE_NOTIFICATION)
    Call<NotificationResponse> getAllNotifications();

    @GET(ApiURLs.VILLE_ORDER_DETAIL + "/{" + ORDER_ID + "}" + "/details")
    Call<OrderDetailResponse> getOrderDetail(@Path(ORDER_ID) String order_id);

    @GET(ApiURLs.VILLE_CANCEL_ORDER + "/{" + ORDER_ID + "}")
    Call<BaseModel> cancelOrder(@Path(ORDER_ID) String order_id);

    @POST(ApiURLs.VILLE_SEND_FEEDBACK)
    Call<BaseModel> sendFeedback(@Query(ORDER_ID) String order_id, @Query("feedback") String feedback);

    @GET(ApiURLs.VILLE_DOWNLOAD_INVOICE + "/{" + ORDER_ID + "}")
    Call<ResponseBody> downloadInvoice(@Path(ORDER_ID) String order_id);

    @GET(ApiURLs.VILLE_SEND_FCM_TOKEN)
    Call<LoginResponse> sendToken(@Query("device_id") String device_id);
}