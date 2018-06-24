package com.relfor.webserviceexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.relfor.webserviceexample.Constant;
import com.relfor.webserviceexample.R;

import static com.relfor.webserviceexample.Constant.ALTERNATIVE_PLACE_HOLDER;
import static com.relfor.webserviceexample.Constant.BASE_URL_ETA;
import static com.relfor.webserviceexample.Constant.DESTINATION_PLACE_HOLDER;
import static com.relfor.webserviceexample.Constant.DIRECTION_API_KEY;
import static com.relfor.webserviceexample.Constant.KEY_PLACEHOLDER;
import static com.relfor.webserviceexample.Constant.MODE_PLACE_HOLDER;
import static com.relfor.webserviceexample.Constant.ORIGIN_PLACE_HOLDER;

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

    public void onSearchClick(View view) {

        String origin = edtSource.getText().toString().trim();
        String destination = edtDestination.getText().toString().trim();

        String url = BASE_URL_ETA + ORIGIN_PLACE_HOLDER + origin + DESTINATION_PLACE_HOLDER +
                destination + MODE_PLACE_HOLDER + "driving" + ALTERNATIVE_PLACE_HOLDER + false
                + KEY_PLACEHOLDER + DIRECTION_API_KEY;

        Log.e("API URL", "URL "+url);



    }
}
