package com.villezone.gautam.fragments;

import android.app.Activity;
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

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.activity.OrderDetailActivity;
import com.villezone.gautam.activity.SubCategoryActivity;
import com.villezone.gautam.adapter.CategoryAdapter;
import com.villezone.gautam.adapter.OrderAdapter;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.model.CategoryData;
import com.villezone.gautam.model.CategoryResponse;
import com.villezone.gautam.model.Order;
import com.villezone.gautam.model.OrderResponse;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.HttpUtil;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyOrdersFragment extends Fragment {

    private RelativeLayout progress;
    private Activity context;
    private OrderAdapter adapter;
    MaterialTextView tvEmpty;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        context = getActivity();
        progress = root.findViewById(R.id.progress);
        tvEmpty = root.findViewById(R.id.tvEmpty);
        initOrders(root);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        getOrders();
    }

    private void getOrders() {
        progress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<OrderResponse> call = apiInterface.getAllOrders();
        call.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(@NonNull Call<OrderResponse> call, @NonNull Response<OrderResponse> response) {
                progress.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    List<Order> categoryData = response.body().getData();
                    if (categoryData.isEmpty()) {
                        tvEmpty.setVisibility(View.VISIBLE);
                    } else {
                        tvEmpty.setVisibility(View.GONE);
                    }
                    adapter.setData(categoryData);
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<OrderResponse> call, @NonNull Throwable t) {
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                progress.setVisibility(View.GONE);
            }
        });
    }

    private void initOrders(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.rvOrders);
        adapter = new OrderAdapter();
        adapter.setItemClickListener(new ItemClickListener<Order>() {
            @Override
            public void onClick(Order item) {
                startActivity(OrderDetailActivity.intent(item));
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(App.get()));
        recyclerView.setAdapter(adapter);
    }
}
