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
import com.villezone.gautam.adapter.CategoryAdapter;
import com.villezone.gautam.adapter.ProductAdapter;
import com.villezone.gautam.adapter.SubCategoryAdapter;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.listner.ProductItemListener;
import com.villezone.gautam.model.CategoryData;
import com.villezone.gautam.model.CategoryResponse;
import com.villezone.gautam.model.Products;
import com.villezone.gautam.model.SubCategoryResponse;
import com.villezone.gautam.model.Sub_category;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.Constant;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SubCategoryActivity extends AppCompatActivity {

    private RelativeLayout progress;
    private CategoryAdapter adapter;
    String category_name, category_id;
    RecyclerView rvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        category_id = getIntent().getStringExtra(Constant.CATEGORY_ID);
        category_name = getIntent().getStringExtra(Constant.CATEGORY_NAME);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(category_name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        progress = findViewById(R.id.progress);
        initCategory();
        getCategoryById();
    }

    private void initCategory() {
        rvCategory = findViewById(R.id.rvCategory);
        adapter = new CategoryAdapter();
        adapter.setItemClickListener(new ItemClickListener<CategoryData>() {
            @Override
            public void onClick(CategoryData item) {
                startActivity(ProductActivity.intent(item.getId(), item.getTitle()));
            }
        });
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(new GridLayoutManager(App.get(), 3));
        rvCategory.setAdapter(adapter);
    }

    private void getCategoryById() {
        progress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CategoryResponse> call = apiInterface.getSubCategoryById(category_id, "");
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<CategoryResponse> call, @NonNull Response<CategoryResponse> response) {
                progress.setVisibility(View.GONE);
                if (response.body() != null) {
                    List<CategoryData> categoryData = response.body().getData();
                    if (categoryData != null) {
                        adapter.setData(categoryData);
                        rvCategory.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<CategoryResponse> call, @NonNull Throwable t) {
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
