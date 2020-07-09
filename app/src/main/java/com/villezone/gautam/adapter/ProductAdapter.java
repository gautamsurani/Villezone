package com.villezone.gautam.adapter;

import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.listner.ItemClickListener;
import com.villezone.gautam.model.Products;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Products> listdata;
    private ItemClickListener<Products> itemClickListener;
    private boolean isFavorite;

    // RecyclerView recyclerView;
    public ProductAdapter(boolean isFavorite) {
        this.isFavorite = isFavorite;
        listdata = new ArrayList<>();
    }

    public void setItemClickListener(ItemClickListener<Products> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Products> listdata) {
        this.listdata = listdata;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
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
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        public MaterialTextView tvName, tvPrice, tvDiscountPrice;
        public LinearLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDiscountPrice = itemView.findViewById(R.id.tvDiscountPrice);
            relativeLayout = itemView.findViewById(R.id.llMain);
        }
    }
}
