package com.example.geocontrol.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.geocontrol.R;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}