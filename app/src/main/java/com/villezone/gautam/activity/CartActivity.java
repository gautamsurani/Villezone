package com.villezone.gautam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.adapter.CartAdapter;
import com.villezone.gautam.listner.CartItemClickListener;
import com.villezone.gautam.model.AreaByIdResponse;
import com.villezone.gautam.model.BaseModel;
import com.villezone.gautam.model.CartItem;
import com.villezone.gautam.model.CartResponse;
import com.villezone.gautam.model.User_detail;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.HttpUtil;
import com.villezone.gautam.util.PlaceOrderSheetDialog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CartActivity extends AppCompatActivity {

    private RelativeLayout progress, update_progress,rlEmpty;
    RecyclerView rvCart;
    private CartAdapter cartAdapter;
    TextView tvPlaceOrder, tvShopping, tvCartTotal;
    int total = 0;
    Activity context;
    List<CartItem> cartItems;
    LinearLayout llPlaceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        context = this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Cart");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progress = findViewById(R.id.progress);
        update_progress = findViewById(R.id.update_progress);
        tvPlaceOrder = findViewById(R.id.tvPlaceOrder);
        rlEmpty = findViewById(R.id.rlEmpty);
        tvShopping = findViewById(R.id.tvShopping);
        tvCartTotal = findViewById(R.id.tvCartTotal);
        llPlaceOrder = findViewById(R.id.llPlaceOrder);

        initCart();

        progress.setVisibility(View.VISIBLE);
        getCart();

        tvPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(OrderSummeryActivity.intent(String.valueOf(total)));
            }
        });

        tvShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomeActivity.intent());
            }
        });
    }

    private void initCart() {
        rvCart = findViewById(R.id.rvCart);
        cartAdapter = new CartAdapter();
        cartAdapter.setItemClickListener(new CartItemClickListener() {
            @Override
            public void onPlusClick(CartItem cartItem) {
                updateCart("1", String.valueOf(cartItem.getId()));
            }

            @Override
            public void onMinusClick(CartItem cartItem) {
                updateCart("0", String.valueOf(cartItem.getId()));
            }

            @Override
            public void onDeleteClick(CartItem cartItem, int position) {
                cartItems.remove(position);
                setCart(cartItems);
                deleteCart(cartItem, position);
            }

        });
        rvCart.setHasFixedSize(true);
        rvCart.setLayoutManager(new LinearLayoutManager(App.get()));
        rvCart.setAdapter(cartAdapter);
    }

    private void updateCart(String s, String id) {
        update_progress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.updateCartItem(id, s);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                if (response.body() != null) {
                    getCart();
                } else {
                    update_progress.setVisibility(View.GONE);
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                update_progress.setVisibility(View.GONE);
            }
        });
    }

    private void deleteCart(CartItem cartItem, int position) {
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.deleteCartItem(String.valueOf(cartItem.getId()));
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                if (!response.isSuccessful()) {
                    HttpUtil.handleError(response);
                    cartItems.add(position, cartItem);
                    cartAdapter.setData(cartItems);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                Toast.makeText(CartActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                cartItems.add(position, cartItem);
                cartAdapter.setData(cartItems);
            }
        });
    }

    private void getCart() {
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CartResponse> call = apiInterface.getCart();
        call.enqueue(new Callback<CartResponse>() {
            @Override
            public void onResponse(@NonNull Call<CartResponse> call, @NonNull Response<CartResponse> response) {
                progress.setVisibility(View.GONE);
                update_progress.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    cartItems = response.body().getData();
                    setCart(cartItems);
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<CartResponse> call, @NonNull Throwable t) {
                progress.setVisibility(View.GONE);
                update_progress.setVisibility(View.GONE);
            }
        });
    }

    public void setCart(List<CartItem> cartItems) {
        total = 0;
        cartAdapter.setData(cartItems);
        User_detail user_detail = App.getPreference().getUserDetails();
        user_detail.setTotal_cart_products(cartItems.size());
        App.getPreference().setUserDetails(user_detail);
        if (cartItems.size() > 0) {
            for (int i = 0; i < cartItems.size(); i++) {
                CartItem cartItem = cartItems.get(i);
                total = total + Integer.parseInt(cartItem.getPrice());
            }
            tvCartTotal.setText(App.get().getResources().getString(R.string.Rs) + total);
            llPlaceOrder.setVisibility(View.VISIBLE);
            rlEmpty.setVisibility(View.GONE);
            rvCart.setVisibility(View.VISIBLE);
        } else {
            rvCart.setVisibility(View.GONE);
            llPlaceOrder.setVisibility(View.GONE);
            rlEmpty.setVisibility(View.VISIBLE);
        }
    }

    public static Intent intent() {
        return new Intent(App.get(), CartActivity.class);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_cart) {

            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
