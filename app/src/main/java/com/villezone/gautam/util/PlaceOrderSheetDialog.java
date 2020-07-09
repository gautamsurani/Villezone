package com.villezone.gautam.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.model.AreaData;
import com.villezone.gautam.model.User_detail;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;

public class PlaceOrderSheetDialog extends BottomSheetDialogFragment {
    public static final String TAG = "ActionBottomDialog";
    private ItemClickListener mListener;
    private String cartTotal;
    AreaData deliveryCharge;
    String time_slot;

    public PlaceOrderSheetDialog(String cartTotal, AreaData deliveryCharge) {
        this.cartTotal = cartTotal;
        this.deliveryCharge = deliveryCharge;
    }

    public static PlaceOrderSheetDialog newInstance(String cartTotal, AreaData deliveryCharge) {
        return new PlaceOrderSheetDialog(cartTotal, deliveryCharge);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_place_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvMobileNumber = view.findViewById(R.id.tvMobileNumber);
        TextView tvAddress = view.findViewById(R.id.tvAddress);
        TextView tvCartTotal = view.findViewById(R.id.tvCartTotal);
        TextView tvDeliveryCharge = view.findViewById(R.id.tvDeliveryCharge);
        TextView tvTotal = view.findViewById(R.id.tvTotal);
        TextView tvDate = view.findViewById(R.id.tvDate);
        TextView tvMinimumAmount = view.findViewById(R.id.tvMinimumAmount);
        MaterialButton btnPlaceOrder = view.findViewById(R.id.btnPlaceOrder);
        MaterialButton btnChangeAddress = view.findViewById(R.id.btnChangeAddress);

        RadioGroup rgTimeSlot = view.findViewById(R.id.rgTimeSlot);
        RadioButton rbTimeSlot1 = view.findViewById(R.id.rbTimeSlot1);
        RadioButton rbTimeSlot2 = view.findViewById(R.id.rbTimeSlot2);
        RadioButton rbTimeSlot3 = view.findViewById(R.id.rbTimeSlot3);
        rbTimeSlot1.setText(deliveryCharge.getTime_slot().getFirst().getTime());
        rbTimeSlot2.setText(deliveryCharge.getTime_slot().getFirst().getTime());
        rbTimeSlot3.setText(deliveryCharge.getTime_slot().getFirst().getTime());

        rgTimeSlot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbTimeSlot1:
                        time_slot = "first";
                        break;
                    case R.id.rbTimeSlot2:
                        time_slot = "second";
                        break;
                    case R.id.rbTimeSlot3:
                        time_slot = "third";
                        break;
                }
            }
        });

        User_detail user_detail = App.getPreference().getUserDetails();

        tvDate.setText("Expected delivery date " + deliveryCharge.getExpected_delivery_date());
        tvMinimumAmount.setText("Minimum order amount Rs. " + deliveryCharge.getMinimum_order());
        tvName.setText(user_detail.getName());
        tvMobileNumber.setText(user_detail.getMobile_number());
        tvAddress.setText(App.getPreference().getUserDetails().getAddress()
                + ", " + App.getPreference().getUserDetails().getArea().getName()
                + " - " + App.getPreference().getUserDetails().getPin_code());
        tvCartTotal.setText(App.get().getResources().getString(R.string.Rs) + cartTotal);
        tvDeliveryCharge.setText(App.get().getResources().getString(R.string.Rs) + deliveryCharge.getDelivery_charge());
        tvTotal.setText(App.get().getResources().getString(R.string.Rs) + (Integer.parseInt(cartTotal) + Integer.parseInt(deliveryCharge.getDelivery_charge())));

        btnPlaceOrder.setOnClickListener(view1 -> {
            if (mListener != null) {
                if (Integer.parseInt(cartTotal) < Integer.parseInt(deliveryCharge.getMinimum_order())) {
                    Toast.makeText(App.get(), "You need minimum cart amount more then Rs. " + deliveryCharge.getMinimum_order(), Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(time_slot)) {
                    Toast.makeText(App.get(), "Please select Delivery Option", Toast.LENGTH_LONG).show();
                } else {
                    mListener.onPlaceOrderClick(time_slot);
                    dismiss();
                }
            }
        });

        btnChangeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onChangeAddressClick();
                    dismiss();
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PlaceOrderSheetDialog.ItemClickListener) {
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

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        dialog.setOnShowListener(dialog1 -> {
            BottomSheetDialog d = (BottomSheetDialog) dialog1;

            FrameLayout bottomSheet = d.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
        });

        // Do something with your dialog like setContentView() or whatever
        return dialog;
    }

    public interface ItemClickListener {
        void onPlaceOrderClick(String time_slot);

        void onChangeAddressClick();
    }
}
