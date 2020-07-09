package com.villezone.gautam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.adapter.CartAdapter;
import com.villezone.gautam.adapter.OrderProductAdapter;
import com.villezone.gautam.listner.CartItemClickListener;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.model.BaseModel;
import com.villezone.gautam.model.CartItem;
import com.villezone.gautam.model.Order;
import com.villezone.gautam.model.OrderDetail;
import com.villezone.gautam.model.OrderDetailResponse;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.Constant;
import com.villezone.gautam.util.HttpUtil;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderDetailActivity extends AppCompatActivity {

    Order order;
    RecyclerView rvProduct;
    OrderProductAdapter orderProductAdapter;
    public TextView tvName, tvPrice, tvOrderDate, tvOrderStatus, tvDeliveryCharge, tvPaymentStatus, tvExpectedDelivery;
    TextView tvCancel;
    RelativeLayout rlProgress;
    ProgressBar progress, progress_feedback;
    EditText etFeedback;
    TextView tvSendFeedback, tvInvoice;
    LinearLayout llFeedback;
    private static final int MULTIPLE_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        initComp();

        order = (Order) getIntent().getSerializableExtra(Constant.ORDER);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Order Detail");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvName.setText(order.getOrder_key());
        tvPrice.setText("Total Amount: " + App.get().getResources().getString(R.string.Rs) + order.getTotal_order_price());
        tvOrderDate.setText("Order Date: " + order.getOrder_date());
        tvOrderStatus.setText("Order Status: " + order.getOrder_status());

        tvDeliveryCharge.setText("Delivery Charges: " + App.get().getResources().getString(R.string.Rs) + order.getDelivery_charge());
        tvPaymentStatus.setText("Payment Status: " + order.getPayment_status());

        if (order.getOrder_status().equalsIgnoreCase("delivered")) {
            tvInvoice.setVisibility(View.VISIBLE);
            tvExpectedDelivery.setText("Delivered On: " + order.getExpected_delivery_date());
            llFeedback.setVisibility(View.VISIBLE);
        } else {
            llFeedback.setVisibility(View.GONE);
            tvInvoice.setVisibility(View.GONE);
            tvExpectedDelivery.setText("Expected Delivery: " + order.getExpected_delivery_date());
        }

        if (order.getOrder_status().equalsIgnoreCase("canceled")) {
            tvOrderStatus.setTextColor(App.get().getResources().getColor(R.color.red));
            tvExpectedDelivery.setVisibility(View.GONE);
        } else {
            tvOrderStatus.setTextColor(App.get().getResources().getColor(R.color.green));
            tvExpectedDelivery.setVisibility(View.VISIBLE);
        }

        if (order.getOrder_status().equalsIgnoreCase("placed") || order.getOrder_status().equalsIgnoreCase("accept")) {
            tvCancel.setVisibility(View.VISIBLE);
        } else {
            tvCancel.setVisibility(View.GONE);
        }

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCancelDialog();
            }
        });

        tvInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkPermissions()) {
                        downloadInvoice();
                    }
                } else {
                    downloadInvoice();
                }
            }
        });

        initProduct();

        getOrderDetail(order.getId());

        if (TextUtils.isEmpty(order.getFeedback())) {
            tvSendFeedback.setText("Send Feedback");
        } else {
            tvSendFeedback.setText("Update Feedback");
            etFeedback.setText(order.getFeedback());
        }

        tvSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String feedback = etFeedback.getText().toString();
                if (TextUtils.isEmpty(feedback)) {
                    Toast.makeText(OrderDetailActivity.this, "Please write your feedback", Toast.LENGTH_SHORT).show();
                } else {
                    sendFeedback(feedback);
                }
            }
        });

    }

    String[] permissions = new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,};

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();

        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(getApplicationContext(), p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {  // permissions granted.
                    downloadInvoice();
                } else {
                    String perStr = "";
                    for (String per : permissions) {
                        perStr += "\n" + per;
                    }
                    Toast.makeText(this, "Need permissions...", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private ProgressDialog dialog;

    private void downloadInvoice() {
        File path = Environment.getExternalStorageDirectory();
        File file = new File(path, order.getOrder_key() + ".pdf");
        if (file.exists()) {
            openPdf(file);
        } else {
            dialog = new ProgressDialog(OrderDetailActivity.this);
            dialog.setMessage("Downloading invoice, please wait...");
            dialog.setCancelable(false);
            dialog.show();
            Retrofit retrofit = RetrofitInstance.getClient();
            ApiInterface apiInterface = retrofit.create(ApiInterface.class);
            Call<ResponseBody> call = apiInterface.downloadInvoice(order.getId());
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(response.body().bytes());
                            fileOutputStream.close();
                            openPdf(file);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        HttpUtil.handleError(response);
                    }
                    dialog.dismiss();
                }

                @Override
                public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                    dialog.dismiss();
                    Toast.makeText(OrderDetailActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void openPdf(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    private void sendFeedback(String feedback) {
        progress_feedback.setVisibility(View.VISIBLE);
        tvSendFeedback.setVisibility(View.GONE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.sendFeedback(order.getId(), feedback);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                if (response.isSuccessful()) {
                    tvSendFeedback.setText("Update Feedback");
                    Toast.makeText(OrderDetailActivity.this, response.body().getData().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    HttpUtil.handleError(response);
                }
                progress_feedback.setVisibility(View.GONE);
                tvSendFeedback.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                progress_feedback.setVisibility(View.GONE);
                tvSendFeedback.setVisibility(View.VISIBLE);
                Toast.makeText(OrderDetailActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openCancelDialog() {
        new MaterialAlertDialogBuilder(OrderDetailActivity.this)
                .setTitle("Cancel Order!")
                .setMessage("Are you sure you want to cancel order?")
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        cancelOrder();
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }

    private void cancelOrder() {
        rlProgress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.cancelOrder(order.getId());
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(OrderDetailActivity.this, response.body().getData().getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    HttpUtil.handleError(response);
                }
                rlProgress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                rlProgress.setVisibility(View.GONE);
                Toast.makeText(OrderDetailActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initProduct() {
        rvProduct = findViewById(R.id.rvProduct);
        orderProductAdapter = new OrderProductAdapter();
        orderProductAdapter.setItemClickListener(new ItemClickListener<OrderDetail>() {
            @Override
            public void onClick(OrderDetail item) {
                startActivity(ProductDetailActivity.intent(item.getProduct().getId(), item.getProduct().getName()));
            }
        });
        rvProduct.setHasFixedSize(true);
        rvProduct.setLayoutManager(new LinearLayoutManager(App.get()));
        rvProduct.setAdapter(orderProductAdapter);
    }

    private void getOrderDetail(String order_id) {
        progress.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<OrderDetailResponse> call = apiInterface.getOrderDetail(order_id);
        call.enqueue(new Callback<OrderDetailResponse>() {
            @Override
            public void onResponse(@NonNull Call<OrderDetailResponse> call, @NonNull Response<OrderDetailResponse> response) {
                progress.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    List<OrderDetail> orderDetail = response.body().getData();
                    orderProductAdapter.setData(orderDetail);
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<OrderDetailResponse> call, @NonNull Throwable t) {
                progress.setVisibility(View.GONE);
                Toast.makeText(OrderDetailActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initComp() {
        tvName = findViewById(R.id.tvName);
        tvPrice = findViewById(R.id.tvPrice);
        tvOrderDate = findViewById(R.id.tvOrderDate);
        tvOrderStatus = findViewById(R.id.tvOrderStatus);
        tvDeliveryCharge = findViewById(R.id.tvDeliveryCharge);
        tvPaymentStatus = findViewById(R.id.tvPaymentStatus);
        tvExpectedDelivery = findViewById(R.id.tvExpectedDelivery);
        tvCancel = findViewById(R.id.tvCancel);
        rlProgress = findViewById(R.id.rlProgress);
        progress = findViewById(R.id.progress);
        tvSendFeedback = findViewById(R.id.tvSendFeedback);
        etFeedback = findViewById(R.id.etFeedback);
        progress_feedback = findViewById(R.id.progress_feedback);
        tvInvoice = findViewById(R.id.tvInvoice);
        llFeedback = findViewById(R.id.llFeedback);
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

    public static Intent intent(Order order) {
        Intent intent = new Intent(App.get(), OrderDetailActivity.class);
        intent.putExtra(Constant.ORDER, order);
        return intent;
    }
}
