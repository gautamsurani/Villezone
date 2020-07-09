package com.villezone.gautam.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.activity.ProductDetailActivity;
import com.villezone.gautam.activity.SearchActivity;
import com.villezone.gautam.activity.SubCategoryActivity;
import com.villezone.gautam.adapter.CategoryAdapter;
import com.villezone.gautam.adapter.ProductAdapter;
import com.villezone.gautam.adapter.SliderAdapterExample;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.model.CategoryData;
import com.villezone.gautam.model.CategoryResponse;
import com.villezone.gautam.model.DashboardResponse;
import com.villezone.gautam.model.Products;
import com.villezone.gautam.model.SliderItem;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.HttpUtil;
import com.villezone.gautam.view.HomeView;
import com.google.android.material.card.MaterialCardView;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment implements HomeView {

    private RelativeLayout progress;
    private CategoryAdapter adapter;
    private ProductAdapter productAdapter, latestAdapter;
    private Activity context;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        progress = root.findViewById(R.id.progress);
        MaterialCardView svProduct = root.findViewById(R.id.svProduct);
        mSwipeRefreshLayout = root.findViewById(R.id.swipeToRefresh);
        context = getActivity();
        initCategory(root);
        initFavoriteProduct(root);
        initLatestProduct(root);
        initSlider(root);
        getCategory();
        getDashboardProduct();
        svProduct.setOnClickListener(view -> search());

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            getCategory();
            getDashboardProduct();
        });

        return root;
    }

    private void search() {
        startActivity(SearchActivity.intent());
    }

    SliderAdapterExample sliderAdapterExample;

    private void initSlider(View root) {
        SliderView sliderView = root.findViewById(R.id.imageSlider);

        sliderAdapterExample = new SliderAdapterExample(context, false);

        sliderView.setSliderAdapter(sliderAdapterExample);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }

    private void initCategory(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rvCategory);
        adapter = new CategoryAdapter();
        adapter.setItemClickListener(new ItemClickListener<CategoryData>() {
            @Override
            public void onClick(CategoryData item) {
                startActivity(SubCategoryActivity.intent(item.getId(), item.getTitle()));
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(App.get(), 3));
        recyclerView.setAdapter(adapter);
    }

    RecyclerView rvFavoriteProduct, rvLatestProduct;

    private void initFavoriteProduct(View view) {
        rvFavoriteProduct = view.findViewById(R.id.rvFavoriteProduct);
        productAdapter = new ProductAdapter(true);
        productAdapter.setItemClickListener(new ItemClickListener<Products>() {
            @Override
            public void onClick(Products item) {
                startActivity(ProductDetailActivity.intent(item.getId(), item.getName()));
            }
        });
        rvFavoriteProduct.setHasFixedSize(true);
        rvFavoriteProduct.setLayoutManager(new LinearLayoutManager(App.get(), LinearLayoutManager.HORIZONTAL, false));
        rvFavoriteProduct.setAdapter(productAdapter);
    }

    private void initLatestProduct(View view) {
        rvLatestProduct = view.findViewById(R.id.rvLatestProduct);
        latestAdapter = new ProductAdapter(true);
        latestAdapter.setItemClickListener(new ItemClickListener<Products>() {
            @Override
            public void onClick(Products item) {
                startActivity(ProductDetailActivity.intent(item.getId(), item.getName()));
            }
        });
        rvLatestProduct.setHasFixedSize(true);
        rvLatestProduct.setLayoutManager(new LinearLayoutManager(App.get(), LinearLayoutManager.HORIZONTAL, false));
        rvLatestProduct.setAdapter(latestAdapter);
    }

    private void getCategory() {
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CategoryResponse> call = apiInterface.getAllCategory();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<CategoryResponse> call, @NonNull Response<CategoryResponse> response) {
                if (response.isSuccessful()) {
                    List<CategoryData> categoryData = response.body().getData();
                    adapter.setData(categoryData);
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<CategoryResponse> call, @NonNull Throwable t) {
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDashboardProduct() {
        progress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<DashboardResponse> call = apiInterface.getDashboardProducts();
        call.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(@NonNull Call<DashboardResponse> call, @NonNull Response<DashboardResponse> response) {
                progress.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    DashboardResponse dashboardResponse = response.body();
                    List<Products> popularList = dashboardResponse.getPopular_products();
                    List<Products> latestList = dashboardResponse.getLatest_products();
                    productAdapter.setData(popularList);
                    latestAdapter.setData(latestList);

                    SliderItem sliderItem1 = new SliderItem();
                    sliderItem1.setImageUrl(dashboardResponse.getSlider_images().getSlider_image_1());
                    sliderItem1.setDescription("Buy fresh fruit from Villezone - always delivered from the farm to your door.");

                    SliderItem sliderItem2 = new SliderItem();
                    sliderItem2.setImageUrl(dashboardResponse.getSlider_images().getSlider_image_2());
                    sliderItem2.setDescription("Hello Surat !! all fresh Villezone.com purchases fruits and vegetables");

                    SliderItem sliderItem3 = new SliderItem();
                    sliderItem3.setImageUrl(dashboardResponse.getSlider_images().getSlider_image_3());
                    sliderItem3.setDescription("The only thing good about summer is Mangoes!");

                    List<SliderItem> sliderItems = new ArrayList<>();
                    sliderItems.add(sliderItem1);
                    sliderItems.add(sliderItem2);
                    sliderItems.add(sliderItem3);

                    sliderAdapterExample.renewItems(sliderItems);

                } else {
                    HttpUtil.handleError(response);
                }
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(@NonNull Call<DashboardResponse> call, @NonNull Throwable t) {
                progress.setVisibility(View.GONE);
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
