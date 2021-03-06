package com.villezone.gautam.adapter;

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
import com.villezone.gautam.model.SearchResult;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<SearchResult> listdata;
    private ItemClickListener<SearchResult> itemClickListener;

    // RecyclerView recyclerView;
    public SearchAdapter() {
        listdata = new ArrayList<>();
    }

    public void setItemClickListener(ItemClickListener<SearchResult> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setData(List<SearchResult> listdata) {
        this.listdata = listdata;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.row_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SearchResult myListData = listdata.get(position);
        holder.textView.setText(myListData.getName());
        Glide.with(App.get())
                .load(myListData.getImage())
                .into(holder.imageView);
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
        ImageView imageView;
        public TextView textView;
        public LinearLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.ivImage);
            this.textView = itemView.findViewById(R.id.tvName);
            relativeLayout = itemView.findViewById(R.id.llMain);
        }
    }
}