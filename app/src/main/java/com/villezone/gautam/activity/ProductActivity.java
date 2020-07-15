package com.villezone.gautam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.adapter.ProductAdapter;
import com.villezone.gautam.listner.ProductItemListener;
import com.villezone.gautam.model.AllProductsResponse;
import com.villezone.gautam.model.PageMeta;
import com.villezone.gautam.model.Products;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.Constant;
import com.villezone.gautam.util.HttpUtil;
import com.villezone.gautam.util.SortProductSheetDialog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductActivity extends AppCompatActivity implements SortProductSheetDialog.ItemClickListener {

    private RelativeLayout progress;
    private ProductAdapter productAdapter;
    String category_name, category_id;
    RecyclerView rvProduct;
    PageMeta pageMeta;
    String current_sort = "";
    boolean hold = false;
    ProgressBar progressBar;
    TextView tvEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        category_id = getIntent().getStringExtra(Constant.CATEGORY_ID);
        category_name = getIntent().getStringExtra(Constant.CATEGORY_NAME);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(category_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progress = findViewById(R.id.progress);
        progressBar = findViewById(R.id.progressBar);
        tvEmpty = findViewById(R.id.tvEmpty);
        initProduct();
        getProduct(current_sort, 1);
    }

    private void initProduct() {
        rvProduct = findViewById(R.id.rvFavoriteProduct);
        productAdapter = new ProductAdapter(false, getSupportFragmentManager());
        productAdapter.setItemClickListener(new ProductItemListener<Products>() {
            @Override
            public void onClick(Products item) {
                startActivity(ProductDetailActivity.intent(item.getId(), item.getName()));
            }

            @Override
            public void onCartAdded() {
                App.getPreference().increaseCartCount();
                setupBadge();
            }
        });
        rvProduct.setHasFixedSize(true);
        rvProduct.setLayoutManager(new GridLayoutManager(App.get(), 2));
        rvProduct.setAdapter(productAdapter);

        rvProduct.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 1 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    if (pageMeta != null) {
                        if (pageMeta.getCurrent_page() != pageMeta.getLast_page()) {
                            if (!hold) {
                                hold = true;
                                getProduct(current_sort, pageMeta.getCurrent_page() + 1);
                            }
                        }
                    }
                }
            }
        });
    }

    private void getProduct(String sort, int page) {
        if (page == 1) {
            progress.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.VISIBLE);
        }
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<AllProductsResponse> call = apiInterface.getProductsByCatId(category_id, page, sort);
        call.enqueue(new Callback<AllProductsResponse>() {
            @Override
            public void onResponse(@NonNull Call<AllProductsResponse> call, @NonNull Response<AllProductsResponse> response) {
                if (response.isSuccessful()) {
                    pageMeta = response.body().getMeta();
                    List<Products> products = response.body().getData();
                    Log.e("Products", "page: " + pageMeta.getCurrent_page() + " size: " + products.size());
                    if (!products.isEmpty()) {
                        if (page == 1) {
                            productAdapter.setData(products);
                        } else {
                            productAdapter.addData(products);
                        }
                        rvProduct.setVisibility(View.VISIBLE);
                        tvEmpty.setVisibility(View.GONE);
                    } else {
                        if (pageMeta.getCurrent_page() == 1) {
                            tvEmpty.setVisibility(View.VISIBLE);
                        }
                    }
                } else {
                    HttpUtil.handleError(response);
                }
                progress.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                hold = false;
            }

            @Override
            public void onFailure(@NonNull Call<AllProductsResponse> call, @NonNull Throwable t) {
                progress.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                hold = false;
            }
        });
    }

    public static Intent intent(String id, String name) {
        Intent intent = new Intent(App.get(), ProductActivity.class);
        intent.putExtra(Constant.CATEGORY_ID, id);
        intent.putExtra(Constant.CATEGORY_NAME, name);
        return intent;
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
        getMenuInflater().inflate(R.menu.product_menu, menu);

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
        } else if (id == R.id.action_sort) {
            SortProductSheetDialog openBottomSheet = SortProductSheetDialog
                    .newInstance();
            openBottomSheet.show(getSupportFragmentManager(), SortProductSheetDialog.TAG);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(String item) {
        current_sort = item;
        getProduct(current_sort, 1);
    }
}
