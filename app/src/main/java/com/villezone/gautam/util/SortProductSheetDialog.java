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

public class SortProductSheetDialog  extends BottomSheetDialogFragment {
    public static final String TAG = "ActionBottomDialog";
    private ItemClickListener mListener;
    String s, s1, s2;

    public SortProductSheetDialog() {

    }

    public static SortProductSheetDialog newInstance() {
        return new SortProductSheetDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sort_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvAToZ = view.findViewById(R.id.tvAToZ);
        TextView tvZToA = view.findViewById(R.id.tvZToA);
        TextView tvLToH = view.findViewById(R.id.tvLToH);
        TextView tvHToL = view.findViewById(R.id.tvHToL);

        tvAToZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick("a_to_z");
                dismiss();
            }
        });

        tvZToA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick("z_to_a");
                dismiss();
            }
        });

        tvLToH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick("low_to_high");
                dismiss();
            }
        });

        tvHToL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick("high_to_low");
                dismiss();
            }
        });
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

    public interface ItemClickListener {
        void onItemClick(String item);
    }
}
