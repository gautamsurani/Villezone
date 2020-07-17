package com.villezone.gautam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.adapter.SliderAdapterExample;
import com.villezone.gautam.listner.AddToCartListner;
import com.villezone.gautam.model.BaseModel;
import com.villezone.gautam.model.ProductDetailResponse;
import com.villezone.gautam.model.Products;
import com.villezone.gautam.model.SliderItem;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.CartOptionSheetDialog;
import com.villezone.gautam.util.Constant;
import com.villezone.gautam.util.HttpUtil;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductDetailActivity extends AppCompatActivity {
    Activity context;
    TextView tvName, tvPrice, tvDesc, tvAddToCard, tvBuyNow, tvDiscountPrice;
    RelativeLayout rlProgressBar;
    String product_id, product_name;
    Products products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        product_id = getIntent().getStringExtra(Constant.PRODUCT_ID);
        product_name = getIntent().getStringExtra(Constant.PRODUCT_NAME);
        context = this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(product_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initComp();

        getProduct();

        tvAddToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (products != null) {
                    if (products.getStock().equals("0")) {
                        Toast.makeText(context, "OUT OF STOCK, Currently product not available", Toast.LENGTH_LONG).show();
                        return;
                    }
                    AddToCartListner addToCartListner = new AddToCartListner() {
                        @Override
                        public void onItemClick(String item) {
                            String weight = item.substring(item.indexOf("(") + 1, item.indexOf(")"));
                            addToCart(weight, false);
                        }
                    };
                    if (products.getSell_type_options() != null) {
                        CartOptionSheetDialog openBottomSheet = CartOptionSheetDialog
                                .newInstance(products.getSell_type_options()
                                        , addToCartListner);
                        openBottomSheet.show(getSupportFragmentManager(), CartOptionSheetDialog.TAG);
                    } else {
                        addToCart(null, false);
                    }
                }
            }
        });

        tvBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (products != null) {
                    if (products.getStock().equals("0")) {
                        Toast.makeText(context, "OUT OF STOCK, Currently product not available", Toast.LENGTH_LONG).show();
                        return;
                    }
                    AddToCartListner addToCartListner = new AddToCartListner() {
                        @Override
                        public void onItemClick(String item) {
                            String weight = item.substring(item.indexOf("(") + 1, item.indexOf(")"));
                            addToCart(weight, true);
                        }
                    };
                    if (products.getSell_type_options() != null) {
                        CartOptionSheetDialog openBottomSheet = CartOptionSheetDialog
                                .newInstance(products.getSell_type_options()
                                        , addToCartListner);
                        openBottomSheet.show(getSupportFragmentManager(), CartOptionSheetDialog.TAG);
                    } else {
                        addToCart(null, true);
                    }
                }
            }
        });
    }

    private void initComp() {
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvDiscountPrice = findViewById(R.id.tvDiscountPrice);
        tvDesc = findViewById(R.id.tvDesc);
        tvAddToCard = findViewById(R.id.tvAddToCard);
        rlProgressBar = findViewById(R.id.rlProgressBar);
        tvBuyNow = findViewById(R.id.tvBuyNow);
    }

    private void initSlider() {
        SliderView sliderView = findViewById(R.id.imageSlider);

        SliderAdapterExample adapter = new SliderAdapterExample(context, true);

        sliderView.setSliderAdapter(adapter);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        List<SliderItem> sliderItems = new ArrayList<>();
        for (int i = 0; i < products.getImages().size(); i++) {
            SliderItem sliderItem1 = new SliderItem();
            sliderItem1.setImageUrl(products.getImages().get(i));
            sliderItem1.setDescription("");
            sliderItems.add(sliderItem1);
        }

        adapter.renewItems(sliderItems);
    }

    TextView textCartItemCount;

    @Override
    protected void onResume() {
        super.onResume();
        setupBadge();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cart, menu);

        final MenuItem menuItem = menu.findItem(R.id.action_cart);

        View actionView = menuItem.getActionView();
        textCartItemCount = actionView.findViewById(R.id.cart_badge);

        setupBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });

        return true;
    }

    private void setupBadge() {
        if (textCartItemCount != null) {
            int mCartItemCount = App.getPreference().getUserDetails().getTotal_cart_products();
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_cart) {
            startActivity(CartActivity.intent());
            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    public static Intent intent(String product_id, String product_name) {
        Intent intent = new Intent(App.get(), ProductDetailActivity.class);
        intent.putExtra(Constant.PRODUCT_ID, product_id);
        intent.putExtra(Constant.PRODUCT_NAME, product_name);
        return intent;
    }

    private void addToCart(String weight, boolean goToCart) {
        rlProgressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.addToCart(products.getId(), weight);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                if (response.isSuccessful()) {
                    if (!response.body().getData().getMessage().contains("already")) {
                        App.getPreference().increaseCartCount();
                        setupBadge();
                    }
                    Toast.makeText(ProductDetailActivity.this, response.body().getData().getMessage(), Toast.LENGTH_SHORT).show();
                    if (goToCart) {
                        startActivity(CartActivity.intent());
                    }
                } else {
                    HttpUtil.handleError(response);
                }
                rlProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                Toast.makeText(ProductDetailActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                rlProgressBar.setVisibility(View.GONE);
            }
        });
    }

    private void getProduct() {
        rlProgressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<ProductDetailResponse> call = apiInterface.getProductById(product_id);
        call.enqueue(new Callback<ProductDetailResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductDetailResponse> call, @NonNull Response<ProductDetailResponse> response) {
                if (response.body() != null) {
                    products = response.body().getData();
                    tvName.setText(products.getName() + ", " + products.getGujarati_name() + ", " + products.getHindi_name());
                    tvPrice.setText(getResources().getString(R.string.Rs) + products.getDiscounted_price());
                    tvDiscountPrice.setText(getResources().getString(R.string.Rs) + products.getPrice());
                    tvDiscountPrice.setPaintFlags(tvDiscountPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    tvDesc.setText(products.getDescription());
                    initSlider();
                } else {

                }
                rlProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<ProductDetailResponse> call, @NonNull Throwable t) {
                rlProgressBar.setVisibility(View.GONE);
            }
        });
    }
}
