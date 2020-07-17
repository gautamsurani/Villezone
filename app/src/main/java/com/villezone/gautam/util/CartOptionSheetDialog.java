package com.villezone.gautam.util;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.villezone.gautam.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.villezone.gautam.listner.AddToCartListner;
import com.villezone.gautam.model.Price;

import java.util.List;

public class CartOptionSheetDialog extends BottomSheetDialogFragment
        implements View.OnClickListener {
    public static final String TAG = "ActionBottomDialog";
    private AddToCartListner mListener;
    List<Price> prices;

    public CartOptionSheetDialog(List<Price> prices, AddToCartListner mListener) {
        this.mListener = mListener;
        this.prices = prices;
    }

    public static CartOptionSheetDialog newInstance(List<Price> prices, AddToCartListner mListener) {
        return new CartOptionSheetDialog(prices, mListener);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottomsheetlayout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.textView);
        textView.setOnClickListener(this);
        if (prices.size() > 0) {
            textView.setText(prices.get(0).getPrice() + " (" + prices.get(0).getWeight() + ")");
        } else {
            textView.setVisibility(View.GONE);
        }
        TextView textView2 = view.findViewById(R.id.textView2);
        textView2.setOnClickListener(this);
        if (prices.size() > 1) {
            textView2.setText(prices.get(1).getPrice() + " (" + prices.get(1).getWeight() + ")");
        } else {
            textView2.setVisibility(View.GONE);
        }
        TextView textView3 = view.findViewById(R.id.textView3);
        textView3.setOnClickListener(this);
        if (prices.size() > 2) {
            textView3.setText(prices.get(2).getPrice() + " (" + prices.get(2).getWeight() + ")");
        } else {
            textView3.setVisibility(View.GONE);
        }

        TextView textView4 = view.findViewById(R.id.textView4);
        textView4.setOnClickListener(this);
        if (prices.size() > 3) {
            textView4.setText(prices.get(3).getPrice() + " (" + prices.get(3).getWeight() + ")");
        } else {
            textView4.setVisibility(View.GONE);
        }

        TextView textView5 = view.findViewById(R.id.textView5);
        textView5.setOnClickListener(this);
        if (prices.size() > 4) {
            textView5.setText(prices.get(4).getPrice() + " (" + prices.get(4).getWeight() + ")");
        } else {
            textView5.setVisibility(View.GONE);
        }

        TextView textView6 = view.findViewById(R.id.textView6);
        textView6.setOnClickListener(this);
        if (prices.size() > 5) {
            textView6.setText(prices.get(5).getPrice() + " (" + prices.get(5).getWeight() + ")");
        } else {
            textView6.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        TextView tvSelected = (TextView) view;
        mListener.onItemClick(tvSelected.getText().toString());
        dismiss();
    }
}