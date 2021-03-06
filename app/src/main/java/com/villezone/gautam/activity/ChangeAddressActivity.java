package com.villezone.gautam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.model.Area;
import com.villezone.gautam.model.AreaData;
import com.villezone.gautam.model.AreaResponse;
import com.villezone.gautam.model.UpdateProfile;
import com.villezone.gautam.model.UpdateProfileResponse;
import com.villezone.gautam.model.User_detail;
import com.villezone.gautam.rest.ApiInterface;
import com.villezone.gautam.rest.RetrofitInstance;
import com.villezone.gautam.util.HttpUtil;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChangeAddressActivity extends AppCompatActivity {

    Activity context;
    private MaterialButton btnInfoSubmit;
    private TextInputEditText etName, etEmail, etAddress;
    private AutoCompleteTextView pincodeDropdown, areaDropdown;

    private String[] areas;
    private String[] pincodes = new String[0];
    private List<AreaData> areaData;

    private String pincode, area_id, area_name, name, email, address;

    RelativeLayout rlProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address);

        context = this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Manage Address");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initComp();
        getArea();

        areaDropdown.setFocusable(false);
        areaDropdown.setFocusableInTouchMode(false);
        areaDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = areas[i];
                pincodeDropdown.setText("");
                pincode = "";
                setPincode(value);
            }
        });

        pincodeDropdown.setFocusable(false);
        pincodeDropdown.setFocusableInTouchMode(false);
        pincodeDropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pincode = pincodes[i];
            }
        });

        etName.setText(App.getPreference().getUserDetails().getName());
        etEmail.setText(App.getPreference().getUserDetails().getEmail());
        etAddress.setText(App.getPreference().getUserDetails().getAddress());

        btnInfoSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean canNext = true;
                name = etName.getText().toString();
                email = etEmail.getText().toString();
                address = etAddress.getText().toString();
                if (!isNameValid()) {
                    canNext = false;
                    etName.setError("Please enter Name");
                }
                if (!isEmailValid()) {
                    canNext = false;
                    etEmail.setError("Please enter Email");
                }
                if (!isAddressValid()) {
                    canNext = false;
                    etAddress.setError("Please enter Address");
                }
                if (!isAreaValid()) {
                    canNext = false;
                    areaDropdown.setError("Please select Area");
                }
                if (!isPincodeValid()) {
                    canNext = false;
                    pincodeDropdown.setError("Please select Pin-Code");
                }
                if (canNext) {
                    updateAccount();
                }
            }
        });

    }

    private void updateAccount() {
        rlProgressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<UpdateProfileResponse> call = apiInterface.updateProfile(name
                , address
                , email
                , area_id
                , pincode);
        call.enqueue(new Callback<UpdateProfileResponse>() {
            @Override
            public void onResponse(@NonNull Call<UpdateProfileResponse> call, @NonNull Response<UpdateProfileResponse> response) {
                rlProgressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    UpdateProfile updateProfile = response.body().getData();
                    Toast.makeText(App.get(), updateProfile.getMessage(), Toast.LENGTH_SHORT).show();
                    User_detail user_detail = App.getPreference().getUserDetails();
                    user_detail.setName(updateProfile.getCustomer().getName());
                    user_detail.setEmail(updateProfile.getCustomer().getEmail());
                    user_detail.setAddress(updateProfile.getCustomer().getAddress());
                    Area area = new Area();
                    area.setId(area_id);
                    area.setName(area_name);
                    user_detail.setArea(area);
                    user_detail.setPin_code(updateProfile.getCustomer().getPin_code());
                    App.getPreference().setUserDetails(user_detail);
                    finish();
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<UpdateProfileResponse> call, @NonNull Throwable t) {
                rlProgressBar.setVisibility(View.GONE);
                Toast.makeText(App.get(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getArea() {
        Retrofit retrofit = RetrofitInstance.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<AreaResponse> call = apiInterface.getArea();
        call.enqueue(new Callback<AreaResponse>() {
            @Override
            public void onResponse(@NonNull Call<AreaResponse> call, @NonNull Response<AreaResponse> response) {
                if (response.body() != null) {
                    onAreaReceived(response.body());
                    areaDropdown.setText(App.getPreference().getUserDetails().getArea().getName(), false);
                    pincodeDropdown.setText(App.getPreference().getUserDetails().getPin_code(), false);
                    area_id = App.getPreference().getUserDetails().getArea().getId();
                    area_name = App.getPreference().getUserDetails().getArea().getName();
                    pincode = App.getPreference().getUserDetails().getPin_code();
                } else {
                    HttpUtil.handleError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AreaResponse> call, @NonNull Throwable t) {
                Toast.makeText(App.get(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onAreaReceived(AreaResponse areaResponse) {
        areaData = areaResponse.getData();
        areas = new String[areaData.size()];
        for (int i = 0; i < areaData.size(); i++) {
            areas[i] = areaData.get(i).getName();
        }
        if (areaData.size() > 0) {
            pincodes = areaData.get(0).getPincode();
        }
        ArrayAdapter<String> adapterArea = new ArrayAdapter<>(App.get(),
                R.layout.dropdown_menu_popup_item,
                areas);
        areaDropdown.setAdapter(adapterArea);
    }

    private void setPincode(String area) {
        for (int i = 0; i < areaData.size(); i++) {
            if (areaData.get(i).getName().equals(area)) {
                pincodes = areaData.get(i).getPincode();
                area_id = areaData.get(i).getId();
                area_name = areaData.get(i).getName();
                setPincodeAdapter();
                break;
            }
        }
    }

    private void setPincodeAdapter() {
        ArrayAdapter<String> adapterPincode = new ArrayAdapter<>(App.get(),
                R.layout.dropdown_menu_popup_item,
                pincodes);
        pincodeDropdown.setAdapter(adapterPincode);
    }

    public boolean isNameValid() {
        return !TextUtils.isEmpty(name);
    }

    public boolean isEmailValid() {
        return !TextUtils.isEmpty(email);
    }

    public boolean isAddressValid() {
        return !TextUtils.isEmpty(address);
    }

    public boolean isAreaValid() {
        return !TextUtils.isEmpty(area_id);
    }

    public boolean isPincodeValid() {
        return !TextUtils.isEmpty(pincode);
    }

    private void initComp() {
        btnInfoSubmit = findViewById(R.id.btnInfoSubmit);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        pincodeDropdown = findViewById(R.id.pincode_dropdown);
        areaDropdown = findViewById(R.id.area_dropdown);
        rlProgressBar = findViewById(R.id.rlProgressBar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent intent() {
        return new Intent(App.get(), ChangeAddressActivity.class);
    }
}
