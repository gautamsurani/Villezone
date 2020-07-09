package com.villezone.gautam.adapter;

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
import com.villezone.gautam.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<Order> listdata;
    private ItemClickListener<Order> itemClickListener;

    // RecyclerView recyclerView;
    public OrderAdapter() {
        listdata = new ArrayList<>();
    }

    public void setItemClickListener(ItemClickListener<Order> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<Order> listdata) {
        this.listdata = listdata;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row_order, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Order myListData = listdata.get(position);
        holder.tvName.setText(myListData.getOrder_key());
        holder.tvPrice.setText("Total Amount: " + App.get().getResources().getString(R.string.Rs) + myListData.getTotal_order_price());
        holder.tvOrderDate.setText("Order Date: " + myListData.getOrder_date());
        if (myListData.getOrder_status().equalsIgnoreCase("canceled")) {
            holder.tvOrderStatus.setTextColor(App.get().getResources().getColor(R.color.red));
            //holder.tvOrderStatus.setBackground(App.get().getResources().getDrawable(R.drawable.cancel_status_bg));
        } else {
            holder.tvOrderStatus.setTextColor(App.get().getResources().getColor(R.color.green));
            //holder.tvOrderStatus.setBackground(App.get().getResources().getDrawable(R.drawable.placed_btn_bg));
        }
        holder.tvOrderStatus.setText(myListData.getOrder_status());
        Glide.with(App.get())
                .load(myListData.getImage())
                .into(holder.ivImage);
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
        public TextView tvName, tvPrice, tvOrderDate, tvOrderStatus;
        public LinearLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvOrderDate = itemView.findViewById(R.id.tvOrderDate);
            tvOrderStatus = itemView.findViewById(R.id.tvOrderStatus);
            relativeLayout = itemView.findViewById(R.id.llMain);
        }
    }
}