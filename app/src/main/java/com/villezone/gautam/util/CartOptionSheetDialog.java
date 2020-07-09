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

public class CartOptionSheetDialog extends BottomSheetDialogFragment
        implements View.OnClickListener {
    public static final String TAG = "ActionBottomDialog";
    private ItemClickListener mListener;
    String s, s1, s2;

    public CartOptionSheetDialog(String s, String s1, String s2) {
        this.s = s;
        this.s1 = s1;
        this.s2 = s2;
    }

    public static CartOptionSheetDialog newInstance(String s, String s1, String s2) {
        return new CartOptionSheetDialog(s, s1, s2);
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
        textView.setText(s);
        TextView textView2 = view.findViewById(R.id.textView2);
        textView2.setOnClickListener(this);
        textView2.setText(s1);
        TextView textView3 = view.findViewById(R.id.textView3);
        textView3.setOnClickListener(this);
        textView3.setText(s2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListener) {
            mListener = (ItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ItemClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        TextView tvSelected = (TextView) view;
        mListener.onItemClick(tvSelected.getText().toString());
        dismiss();
    }

    public interface ItemClickListener {
        void onItemClick(String item);
    }
}