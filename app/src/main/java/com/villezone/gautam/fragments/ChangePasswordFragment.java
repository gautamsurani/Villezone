package com.villezone.gautam.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.villezone.gautam.R;
import com.villezone.gautam.model.BaseModel;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.HttpUtil;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChangePasswordFragment extends Fragment {

    private TextInputEditText etOldPassword, etNewPassword, etConfirmPassword;
    private MaterialButton btnUpdatePassword;
    private ProgressBar progressInfo;
    private Activity context;

    private String old_password, new_password, confirm_password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_password, container, false);

        context = getActivity();
        initComp(view);

        btnUpdatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean canNext = true;
                old_password = etOldPassword.getText().toString();
                new_password = etNewPassword.getText().toString();
                confirm_password = etConfirmPassword.getText().toString();
                if (!isOldPasswordValid()) {
                    canNext = false;
                    etOldPassword.setError("Old Password length must be 8 character or more");
                }
                if (!isNewPasswordValid()) {
                    canNext = false;
                    etNewPassword.setError("New Password length must be 8 character or more");
                }
                if (!isConfirmPasswordValid()) {
                    canNext = false;
                    etConfirmPassword.setError("Password and confirm password does not match");
                }
                if (canNext) {
                    updatePassword();
                }
            }
        });

        return view;
    }

    private void updatePassword() {
        progressInfo.setVisibility(View.VISIBLE);
        btnUpdatePassword.setVisibility(View.GONE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<BaseModel> call = apiInterface.updatePassword(old_password
                , new_password
                , confirm_password);
        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(@NonNull Call<BaseModel> call, @NonNull Response<BaseModel> response) {
                progressInfo.setVisibility(View.GONE);
                btnUpdatePassword.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    Toast.makeText(context, response.body().getData().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseModel> call, @NonNull Throwable t) {
                progressInfo.setVisibility(View.GONE);
                btnUpdatePassword.setVisibility(View.VISIBLE);
                Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initComp(View view) {
        etOldPassword = view.findViewById(R.id.etOldPassword);
        etNewPassword = view.findViewById(R.id.etNewPassword);
        etConfirmPassword = view.findViewById(R.id.etConfirmPassword);
        btnUpdatePassword = view.findViewById(R.id.btnUpdatePassword);
        progressInfo = view.findViewById(R.id.progressInfo);
    }

    private boolean isNewPasswordValid() {
        return !TextUtils.isEmpty(new_password) && new_password.length() > 7;
    }

    private boolean isConfirmPasswordValid() {
        return !TextUtils.isEmpty(new_password) && !TextUtils.isEmpty(confirm_password) && new_password.equals(confirm_password);
    }

    public boolean isOldPasswordValid() {
        return !TextUtils.isEmpty(old_password) && old_password.length() > 7;
    }
}
