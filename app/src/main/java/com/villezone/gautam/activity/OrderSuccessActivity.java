package com.villezone.gautam.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.villezone.gautam.App;
import com.villezone.gautam.R;
import com.villezone.gautam.util.Constant;

public class OrderSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Order Success");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView tvMessage = findViewById(R.id.tvMessage);
        MaterialButton btnHome = findViewById(R.id.btnHome);

        tvMessage.setText(getIntent().getStringExtra(Constant.MESSAGE));

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomeActivity.intent());
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(HomeActivity.intent());
    }

    public static Intent intent(String message) {
        Intent intent = new Intent(App.get(), OrderSuccessActivity.class);
        intent.putExtra(Constant.MESSAGE, message);
        return intent;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_cart) {

            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
