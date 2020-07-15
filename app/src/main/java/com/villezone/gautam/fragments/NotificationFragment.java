package com.villezone.gautam.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.activity.OrderDetailActivity;
import com.villezone.gautam.adapter.NotificationAdapter;
import com.villezone.gautam.adapter.OrderAdapter;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.model.Notification;
import com.villezone.gautam.model.NotificationResponse;
import com.villezone.gautam.model.Order;
import com.villezone.gautam.model.OrderResponse;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.HttpUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    public NotificationFragment() {
        // Required empty public constructor
    }

    private RelativeLayout progress;
    private Activity context;
    private NotificationAdapter adapter;
    MaterialTextView tvEmpty;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_notification, container, false);
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
        Call<NotificationResponse> call = apiInterface.getAllNotifications();
        call.enqueue(new Callback<NotificationResponse>() {
            @Override
            public void onResponse(@NonNull Call<NotificationResponse> call, @NonNull Response<NotificationResponse> response) {
                progress.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    List<Notification> notifications = response.body().getData();
                    if (notifications.isEmpty()) {
                        tvEmpty.setVisibility(View.VISIBLE);
                    } else {
                        tvEmpty.setVisibility(View.GONE);
                    }
                    adapter.setData(notifications);
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<NotificationResponse> call, @NonNull Throwable t) {
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                progress.setVisibility(View.GONE);
            }
        });
    }

    private void initOrders(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.rvNotification);
        adapter = new NotificationAdapter();
        adapter.setItemClickListener(new ItemClickListener<Notification>() {
            @Override
            public void onClick(Notification item) {

            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(App.get()));
        recyclerView.setAdapter(adapter);
    }
}
