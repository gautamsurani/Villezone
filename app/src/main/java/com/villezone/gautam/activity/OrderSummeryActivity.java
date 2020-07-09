package com.villezone.gautam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.model.AreaByIdResponse;
import com.villezone.gautam.model.AreaData;
import com.villezone.gautam.model.BaseModel;
import com.villezone.gautam.model.User_detail;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.Constant;
import com.villezone.gautam.util.HttpUtil;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderSummeryActivity extends AppCompatActivity {
    Activity context;
    private String cartTotal;
    AreaData deliveryCharge;
    String time_slot;
    RelativeLayout progress;
    TextView tvName, tvMobileNumber, tvAddress, tvCartTotal, tvDeliveryCharge, tvTotal, tvDate, tvMinimumAmount;
    RadioButton rbTimeSlot1, rbTimeSlot2, rbTimeSlot3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summery);

        context = this;

        cartTotal = getIntent().getStringExtra(Constant.CART_TOTAL);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Order Summary");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvName = findViewById(R.id.tvName);
        tvMobileNumber = findViewById(R.id.tvMobileNumber);
        tvAddress = findViewById(R.id.tvAddress);
        tvCartTotal = findViewById(R.id.tvCartTotal);
        tvDeliveryCharge = findViewById(R.id.tvDeliveryCharge);
        tvTotal = findViewById(R.id.tvTotal);
        tvDate = findViewById(R.id.tvDate);
        tvMinimumAmount = findViewById(R.id.tvMinimumAmount);
        progress = findViewById(R.id.progress);
        MaterialTextView btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        MaterialButton btnChangeAddress = findViewById(R.id.btnChangeAddress);

        RadioGroup rgTimeSlot = findViewById(R.id.rgTimeSlot);
        rbTimeSlot1 = findViewById(R.id.rbTimeSlot1);
        rbTimeSlot2 = findViewById(R.id.rbTimeSlot2);
        rbTimeSlot3 = findViewById(R.id.rbTimeSlot3);

        rgTimeSlot.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rbTimeSlot1:
                    time_slot = "first";
                    break;
                case R.id.rbTimeSlot2:
                    time_slot = "second";
                    break;
                case R.id.rbTimeSlot3:
                    time_slot = "third";
                    break;
            }
        });

        btnPlaceOrder.setOnClickListener(view1 -> {
            if (deliveryCharge != null) {
                if (Integer.parseInt(cartTotal) < Integer.parseInt(deliveryCharge.getMinimum_order())) {
                    Toast.makeText(App.get(), "You need minimum cart amount more then Rs. " + deliveryCharge.getMinimum_order(), Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(time_slot)) {
                    Toast.makeText(App.get(), "Please select Delivery Option", Toast.LENGTH_LONG).show();
                } else {
                    lockCart();
                }
            }
        });

        btnChangeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(ChangeAddressActivity.intent(), LAUNCH_SECOND_ACTIVITY);
            }
        });
        getDeliveryCharges();
    }

    int LAUNCH_SECOND_ACTIVITY = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            getDeliveryCharges();
        }
    }

    private void lockCart() {
        progress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.lockCart();
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                if (response.body() != null && response.body().getData() != null) {
                    placeOrder();
                } else {
                    progress.setVisibility(View.GONE);
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                progress.setVisibility(View.GONE);
                Toast.makeText(App.get(), "Something want wrong...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void placeOrder() {
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.placeOrder("cod", time_slot);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                if (response.body() != null && response.body().getData() != null) {
                    User_detail user_detail = App.getPreference().getUserDetails();
                    user_detail.setTotal_cart_products(0);
                    App.getPreference().setUserDetails(user_detail);
                    Toast.makeText(App.get(), response.body().getData().getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(HomeActivity.intent());
                    finish();
                } else {
                    unlockCart();
                    HttpUtil.handleError(response);
                }
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                progress.setVisibility(View.GONE);
                unlockCart();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getDeliveryCharges() {
        progress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<AreaByIdResponse> call = apiInterface.getAreaById(String.valueOf(App.getPreference().getUserDetails().getArea().getId()));
        call.enqueue(new Callback<AreaByIdResponse>() {
            @Override
            public void onResponse(@NonNull Call<AreaByIdResponse> call, @NonNull Response<AreaByIdResponse> response) {
                progress.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    User_detail user_detail = App.getPreference().getUserDetails();
                    deliveryCharge = response.body().getData();
                    tvDate.setText("Expected delivery date " + deliveryCharge.getExpected_delivery_date());
                    tvMinimumAmount.setText("Minimum order amount Rs. " + deliveryCharge.getMinimum_order());
                    tvName.setText(user_detail.getName());
                    tvMobileNumber.setText(user_detail.getMobile_number());
                    tvAddress.setText(App.getPreference().getUserDetails().getAddress()
                            + ", " + App.getPreference().getUserDetails().getArea().getName()
                            + " - " + App.getPreference().getUserDetails().getPin_code());
                    tvCartTotal.setText(App.get().getResources().getString(R.string.Rs) + cartTotal);
                    tvDeliveryCharge.setText(App.get().getResources().getString(R.string.Rs) + deliveryCharge.getDelivery_charge());
                    tvTotal.setText(App.get().getResources().getString(R.string.Rs) + (Integer.parseInt(cartTotal) + Integer.parseInt(deliveryCharge.getDelivery_charge())));
                    rbTimeSlot1.setText(deliveryCharge.getTime_slot().getFirst().getTime());
                    rbTimeSlot2.setText(deliveryCharge.getTime_slot().getSecond().getTime());
                    rbTimeSlot3.setText(deliveryCharge.getTime_slot().getThird().getTime());
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AreaByIdResponse> call, @NonNull Throwable t) {
                progress.setVisibility(View.GONE);
                Toast.makeText(App.get(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void unlockCart() {
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.unlockCart();
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
            }
        });
    }

    public static Intent intent(String cartTotal) {
        Intent intent = new Intent(App.get(), OrderSummeryActivity.class);
        intent.putExtra(Constant.CART_TOTAL, cartTotal);
        return intent;
    }
}
