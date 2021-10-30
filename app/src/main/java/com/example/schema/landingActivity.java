package com.example.schema;
import android.os.*;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class landingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landingactivity);
        Handler mHandler = new Handler();
        Intent intent=new Intent(this,signin.class);
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(intent);
                landingActivity.this.finish();
                //start your activity here
            }

        }, 5000L);

    }
}