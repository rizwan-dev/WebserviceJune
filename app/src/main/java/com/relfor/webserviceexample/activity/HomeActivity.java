package com.relfor.webserviceexample.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.relfor.webserviceexample.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onMovieClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void onDirectionClick(View view){
        Intent intent = new Intent(this, DirectionActivity.class);
        startActivity(intent);
    }
}
