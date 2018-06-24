package com.relfor.webserviceexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.relfor.webserviceexample.R;

public class DirectionActivity extends AppCompatActivity {
    TextView txtDistance, txtTime;
    EditText edtSource, edtDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

        edtSource = findViewById(R.id.edtSource);
        edtDestination = findViewById(R.id.edtDestination);
        txtDistance = findViewById(R.id.txtDistance);
        txtTime = findViewById(R.id.txtTime);
    }

    public void onSearchClick(View view){

    }
}
