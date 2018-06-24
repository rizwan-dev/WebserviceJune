package com.relfor.webserviceexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.relfor.webserviceexample.Constant;
import com.relfor.webserviceexample.R;
import com.relfor.webserviceexample.data.direction.DirectionResponse;
import com.relfor.webserviceexample.data.direction.Element;
import com.relfor.webserviceexample.service.ApiClient;
import com.relfor.webserviceexample.service.MoviesEndpoint;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

        edtSource = findViewById(R.id.edtSource);
        edtDestination = findViewById(R.id.edtDestination);
        txtDistance = findViewById(R.id.txtDistance);
        txtTime = findViewById(R.id.txtTime);
        progress = findViewById(R.id.progress);
    }

    public void onSearchClick(View view) {
        progress.setVisibility(View.VISIBLE);
        String origin = edtSource.getText().toString().trim();
        String destination = edtDestination.getText().toString().trim();

        String url = BASE_URL_ETA + ORIGIN_PLACE_HOLDER + origin + DESTINATION_PLACE_HOLDER +
                destination + MODE_PLACE_HOLDER + "driving" + ALTERNATIVE_PLACE_HOLDER + false
                + KEY_PLACEHOLDER + DIRECTION_API_KEY;

        MoviesEndpoint apiService = ApiClient.getClient().create(MoviesEndpoint.class);

        Call<DirectionResponse> callDirection = apiService.getDirectionData(url);

        callDirection.enqueue(new Callback<DirectionResponse>() {
            @Override
            public void onResponse(Call<DirectionResponse> call, Response<DirectionResponse> response) {
                progress.setVisibility(View.GONE);
                DirectionResponse directionResponse = response.body();
                Element element = directionResponse.getRows().get(0).getElements().get(0);

                String distance = element.getDistance().getText();
                String time = element.getDuration().getText();

                txtDistance.setText("Distance in km : " + distance);
                txtTime.setText("Time in mins : " + time);

            }

            @Override
            public void onFailure(Call<DirectionResponse> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });

        Log.e("API URL", "URL " + url);


    }
}
