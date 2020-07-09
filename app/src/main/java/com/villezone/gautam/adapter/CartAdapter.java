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
import com.villezone.gautam.listner.CartItemClickListener;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.model.CartItem;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<CartItem> listdata;
    private CartItemClickListener itemClickListener;

    // RecyclerView recyclerView;
    public CartAdapter() {
        listdata = new ArrayList<>();
    }

    public void setItemClickListener(CartItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<CartItem> listdata) {
        this.listdata = listdata;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem;
        listItem = layoutInflater.inflate(R.layout.row_cart, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CartItem myListData = listdata.get(position);
        if (TextUtils.isEmpty(myListData.getWeight())) {
            holder.tvName.setText(myListData.getProduct_name());
        } else {
            holder.tvName.setText(myListData.getProduct_name() + " (" + myListData.getWeight() + ")");
        }
        holder.tvPrice.setText(App.get().getResources().getString(R.string.Rs) + myListData.getPrice());
        holder.tvQuantity.setText(myListData.getQuantity() + "");

        if (TextUtils.isEmpty(myListData.getError_message()) || myListData.getError_message().equals("false")) {
            holder.tvError.setVisibility(View.GONE);
            holder.tvError.setText("");
        } else {
            holder.tvError.setVisibility(View.VISIBLE);
            holder.tvError.setText(myListData.getError_message());
        }

        Glide.with(App.get())
                .load(myListData.getProduct_image())
                .into(holder.ivProduct);

        holder.ivMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onMinusClick(myListData);
                }
            }
        });

        holder.ivPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onPlusClick(myListData);
                }
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onDeleteClick(myListData, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMinus, ivPlus, ivProduct, ivDelete;
        MaterialTextView tvName, tvPrice, tvQuantity, tvError;
        LinearLayout relativeLayout;

        ViewHolder(View itemView) {
            super(itemView);
            ivMinus = itemView.findViewById(R.id.ivMinus);
            ivPlus = itemView.findViewById(R.id.ivPlus);
            ivDelete = itemView.findViewById(R.id.ivDelete);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            relativeLayout = itemView.findViewById(R.id.llMain);
            tvError = itemView.findViewById(R.id.tvError);
        }
    }
}
