package com.villezone.gautam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.adapter.ProductAdapter;
import com.villezone.gautam.adapter.SubCategoryAdapter;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.model.CategoryData;
import com.villezone.gautam.model.Products;
import com.villezone.gautam.model.SubCategoryResponse;
import com.villezone.gautam.model.Sub_category;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.Constant;
import com.google.android.material.textview.MaterialTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SubCategoryActivity extends AppCompatActivity {

    private RelativeLayout progress;
    private SubCategoryAdapter adapter;
    private ProductAdapter productAdapter;
    String category_name, category_id;
    MaterialTextView lblFavoriteProduct;
    RecyclerView rvCategory, rvFavoriteProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        initComp();

        category_id = getIntent().getStringExtra(Constant.CATEGORY_ID);
        category_name = getIntent().getStringExtra(Constant.CATEGORY_NAME);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(category_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progress = findViewById(R.id.progress);
        initCategory();
        initFavoriteProduct();
        getCategoryById();
    }

    private void initComp() {
        lblFavoriteProduct = findViewById(R.id.lblFavoriteProduct);
    }

    private void initCategory() {
        rvCategory = findViewById(R.id.rvCategory);
        adapter = new SubCategoryAdapter();
        adapter.setItemClickListener(new ItemClickListener<Sub_category>() {
            @Override
            public void onClick(Sub_category item) {
                startActivity(ProductActivity.intent(item.getId(), item.getTitle()));
            }
        });
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(new GridLayoutManager(App.get(), 3));
        rvCategory.setAdapter(adapter);
    }

    private void initFavoriteProduct() {
        rvFavoriteProduct = findViewById(R.id.rvFavoriteProduct);
        productAdapter = new ProductAdapter(false);
        productAdapter.setItemClickListener(new ItemClickListener<Products>() {
            @Override
            public void onClick(Products item) {
                startActivity(ProductDetailActivity.intent(item.getId(),item.getName()));
            }
        });
        rvFavoriteProduct.setHasFixedSize(true);
        rvFavoriteProduct.setLayoutManager(new GridLayoutManager(App.get(), 2));
        rvFavoriteProduct.setAdapter(productAdapter);
    }

    private void getCategoryById() {
        progress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<SubCategoryResponse> call = apiInterface.getCategoryById(category_id);
        call.enqueue(new Callback<SubCategoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<SubCategoryResponse> call, @NonNull Response<SubCategoryResponse> response) {
                progress.setVisibility(View.GONE);
                if (response.body() != null) {
                    CategoryData categoryData = response.body().getData();
                    if (categoryData.getSub_category() != null) {
                        adapter.setData(categoryData.getSub_category());
                        rvCategory.setVisibility(View.VISIBLE);
                    }
                    if (categoryData.getProducts() != null) {
                        productAdapter.setData(categoryData.getProducts());
                        rvFavoriteProduct.setVisibility(View.VISIBLE);
                        lblFavoriteProduct.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<SubCategoryResponse> call, @NonNull Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });
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

    public static Intent intent(String id, String name) {
        Intent intent = new Intent(App.get(), SubCategoryActivity.class);
        intent.putExtra(Constant.CATEGORY_ID, id);
        intent.putExtra(Constant.CATEGORY_NAME, name);
        return intent;
    }
}
