package com.relfor.webserviceexample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.relfor.webserviceexample.adapter.MoviesListAdapter;
import com.relfor.webserviceexample.R;
import com.relfor.webserviceexample.data.Movie;
import com.relfor.webserviceexample.service.ApiClient;
import com.relfor.webserviceexample.service.MoviesEndpoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMovies;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovies = findViewById(R.id.rvMovies);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        rvMovies.addItemDecoration(new
                DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        MoviesEndpoint apiService = ApiClient.getClient().create(MoviesEndpoint.class);

        Call<List<Movie>> callResult = apiService.getMoviesData();

        callResult.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                List<Movie> moviesList = response.body();
                MoviesListAdapter moviesListAdapter = new MoviesListAdapter(moviesList, MainActivity.this);
                rvMovies.setAdapter(moviesListAdapter);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });


    }
}
