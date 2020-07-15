package com.villezone.gautam.adapter;

import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.activity.CartActivity;
import com.villezone.gautam.activity.ProductDetailActivity;
import com.villezone.gautam.listner.AddToCartListner;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.listner.ProductItemListener;
import com.villezone.gautam.model.BaseModel;
import com.villezone.gautam.model.Products;
import com.google.android.material.textview.MaterialTextView;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.CartOptionSheetDialog;
import com.villezone.gautam.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Products> listdata;
    private ProductItemListener<Products> itemClickListener;
    private boolean isFavorite;
    FragmentManager supportFragmentManager;

    // RecyclerView recyclerView;
    public ProductAdapter(boolean isFavorite, FragmentManager supportFragmentManager) {
        this.supportFragmentManager = supportFragmentManager;
        this.isFavorite = isFavorite;
        listdata = new ArrayList<>();
    }

    public void setItemClickListener(ProductItemListener<Products> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Products> popularList) {
        listdata.clear();
        notifyDataSetChanged();
        listdata.addAll(popularList);
        notifyDataSetChanged();
    }

    public void addData(List<Products> listdata) {
        this.listdata.addAll(listdata);
        notifyDataSetChanged();
    }

    public void clear() {
        listdata.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem;
        if (isFavorite) {
            listItem = layoutInflater.inflate(R.layout.row_favorite_product, parent, false);
        } else {
            listItem = layoutInflater.inflate(R.layout.row_product, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Products myListData = listdata.get(position);
        holder.tvName.setText(myListData.getName() + ", " + myListData.getGujarati_name() + ", " + myListData.getHindi_name());
        if (myListData.getSell_type().equals("weight")) {
            holder.tvPrice.setText(App.get().getResources().getString(R.string.Rs) + myListData.getDiscounted_price() + "(1kg)");
            holder.tvDiscountPrice.setText(App.get().getResources().getString(R.string.Rs) + myListData.getPrice() + "(1kg)");
        } else {
            holder.tvPrice.setText(App.get().getResources().getString(R.string.Rs) + myListData.getDiscounted_price());
            holder.tvDiscountPrice.setText(App.get().getResources().getString(R.string.Rs) + myListData.getPrice());
        }
        holder.tvDiscountPrice.setPaintFlags(holder.tvDiscountPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        if (myListData.getImages().size() > 0) {
            if (TextUtils.isEmpty(myListData.getImages().get(0))) {
                Glide.with(App.get())
                        .load("https://5.imimg.com/data5/HF/CW/MY-51857835/organic-apple-fruit-500x500.jpg")
                        .into(holder.ivImage);
            } else {
                Glide.with(App.get())
                        .load(myListData.getImages().get(0))
                        .into(holder.ivImage);
            }
        } else {
            Glide.with(App.get())
                    .load("https://5.imimg.com/data5/HF/CW/MY-51857835/organic-apple-fruit-500x500.jpg")
                    .into(holder.ivImage);
        }
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onClick(myListData);
                }
            }
        });
        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myListData != null) {
                    if (myListData.getStock().equals("0")) {
                        Toast.makeText(App.get(), "OUT OF STOCK, Currently product not available", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (myListData.getSell_type_options() != null) {
                        AddToCartListner addToCartListner = new AddToCartListner() {
                            @Override
                            public void onItemClick(String item) {
                                String weight = item.substring(item.indexOf("(") + 1, item.indexOf(")"));
                                addToCart(weight, holder, myListData);
                            }
                        };
                        CartOptionSheetDialog openBottomSheet = CartOptionSheetDialog
                                .newInstance("Rs. " + myListData.getSell_type_options().get(0).getPrice() + " (" + myListData.getSell_type_options().get(0).getWeight() + ")"
                                        , "Rs. " + myListData.getSell_type_options().get(1).getPrice() + " (" + myListData.getSell_type_options().get(1).getWeight() + ")"
                                        , "Rs. " + myListData.getSell_type_options().get(2).getPrice() + " (" + myListData.getSell_type_options().get(2).getWeight() + ")"
                                        , addToCartListner);
                        openBottomSheet.show(supportFragmentManager, CartOptionSheetDialog.TAG);
                    } else {
                        addToCart(null, holder, myListData);
                    }
                }
            }
        });
    }

    private void addToCart(String weight, ViewHolder holder, Products products) {
        holder.progress.setVisibility(View.VISIBLE);
        holder.btnAddToCart.setVisibility(View.GONE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.addToCart(products.getId(), weight);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(App.get(), response.body().getData().getMessage(), Toast.LENGTH_SHORT).show();
                    if (!response.body().getData().getMessage().contains("already")) {
                        itemClickListener.onCartAdded();
                    }
                } else {
                    HttpUtil.handleError(response);
                }
                holder.progress.setVisibility(View.GONE);
                holder.btnAddToCart.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                Toast.makeText(App.get(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                holder.progress.setVisibility(View.GONE);
                holder.btnAddToCart.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        public MaterialTextView tvName, tvPrice, tvDiscountPrice;
        public LinearLayout relativeLayout;
        RelativeLayout btnAddToCart;
        ProgressBar progress;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDiscountPrice = itemView.findViewById(R.id.tvDiscountPrice);
            relativeLayout = itemView.findViewById(R.id.llMain);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
            progress = itemView.findViewById(R.id.progress);
        }
    }
}
