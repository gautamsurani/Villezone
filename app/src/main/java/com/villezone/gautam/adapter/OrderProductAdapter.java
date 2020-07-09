package com.villezone.gautam.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.model.OrderDetail;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class OrderProductAdapter extends RecyclerView.Adapter<OrderProductAdapter.ViewHolder> {
    private List<OrderDetail> listdata;
    private ItemClickListener<OrderDetail> itemClickListener;

    // RecyclerView recyclerView;
    public OrderProductAdapter() {
        listdata = new ArrayList<>();
    }

    public void setItemClickListener(ItemClickListener<OrderDetail> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<OrderDetail> listdata) {
        this.listdata = listdata;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem;
        listItem = layoutInflater.inflate(R.layout.row_order_product, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final OrderDetail myListData = listdata.get(position);
        if (TextUtils.isEmpty(myListData.getWeight())) {
            holder.tvName.setText(myListData.getProduct_name());
        } else {
            holder.tvName.setText(myListData.getProduct_name() + " (" + myListData.getWeight() + ")");
        }
        holder.tvPrice.setText(App.get().getResources().getString(R.string.Rs) + myListData.getPrice());
        holder.tvQuantity.setText("Quantity: " + myListData.getQuantity());

        if(myListData.getProduct()!=null) {
            if (!myListData.getProduct().getImages().isEmpty()) {
                Glide.with(App.get())
                        .load(myListData.getProduct().getImages().get(0))
                        .into(holder.ivProduct);
            } else {
                Glide.with(App.get())
                        .load(R.drawable.default_product)
                        .into(holder.ivProduct);
            }
        }else {
            Glide.with(App.get())
                    .load(R.drawable.default_product)
                    .into(holder.ivProduct);
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onClick(myListData);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProduct;
        MaterialTextView tvName, tvPrice, tvQuantity;
        LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            linearLayout = itemView.findViewById(R.id.llMain);
        }
    }
}
