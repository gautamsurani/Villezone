package com.villezone.gautam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.adapter.SearchAdapter;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.model.SearchData;
import com.villezone.gautam.model.SearchResponse;
import com.villezone.gautam.model.SearchResult;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.Constant;
import com.villezone.gautam.util.HttpUtil;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchActivity extends AppCompatActivity {

    private RelativeLayout progress;
    private SearchAdapter adapter;
    RecyclerView rvCategory;
    TextInputEditText etSearch;
    RelativeLayout rlSearch;
    ImageView ivEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setContentInsetStartWithNavigation(0);

        etSearch = findViewById(R.id.etSearch);
        rlSearch = findViewById(R.id.rlSearch);
        ivEmpty = findViewById(R.id.ivEmpty);

        etSearch.requestFocus();

        rlSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search_text = etSearch.getText().toString();
                if (TextUtils.isEmpty(search_text)) {
                    adapter.setData(new ArrayList<>());
                    rvCategory.setVisibility(View.GONE);
                    ivEmpty.setVisibility(View.VISIBLE);
                } else {
                    search(search_text);
                }
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (call != null) {
                    call.cancel();
                }
                if (TextUtils.isEmpty(charSequence)) {
                    adapter.setData(new ArrayList<>());
                    rvCategory.setVisibility(View.GONE);
                    ivEmpty.setVisibility(View.VISIBLE);
                } else {
                    search(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        progress = findViewById(R.id.progress);
        initCategory();

    }

    private void initCategory() {
        rvCategory = findViewById(R.id.rvCategory);
        adapter = new SearchAdapter();
        adapter.setItemClickListener(new ItemClickListener<SearchResult>() {
            @Override
            public void onClick(SearchResult item) {
                if (item.getType().equals("sub-category")) {
                    startActivity(ProductActivity.intent(String.valueOf(item.getId()), item.getName()));
                } else if (item.getType().equals("category")) {
                    startActivity(SubCategoryActivity.intent(String.valueOf(item.getId()), item.getName()));
                } else {
                    startActivity(ProductDetailActivity.intent(String.valueOf(item.getId()), item.getName()));
                }
            }
        });
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(new GridLayoutManager(App.get(), 3));
        rvCategory.setAdapter(adapter);
    }

    Call<SearchResponse> call;

    private void search(String search_text) {
        progress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        call = apiInterface.search(search_text);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                progress.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    SearchData categoryData = response.body().getData();
                    if (!categoryData.getResult().isEmpty()) {
                        adapter.setData(categoryData.getResult());
                        rvCategory.setVisibility(View.VISIBLE);
                        ivEmpty.setVisibility(View.GONE);
                    } else {
                        adapter.setData(categoryData.getResult());
                        rvCategory.setVisibility(View.GONE);
                        ivEmpty.setVisibility(View.VISIBLE);
                    }
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                progress.setVisibility(View.GONE);
                if (!call.isCanceled()) {
                    Toast.makeText(SearchActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
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

    public static Intent intent() {
        Intent intent = new Intent(App.get(), SearchActivity.class);
        return intent;
    }
}
