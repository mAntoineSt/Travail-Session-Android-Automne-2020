package com.antoinepc.travailsessionandroidautomne2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    signin fSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fSignin =(signin) getSupportFragmentManager().findFragmentById(R.id.fLogin);

    }
}