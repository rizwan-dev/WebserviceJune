package com.relfor.webserviceexample.service;

import com.relfor.webserviceexample.data.Movie;
import com.relfor.webserviceexample.data.direction.DirectionResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MoviesEndpoint {

    @GET("demos/marvel/")
    public Call<List<Movie>> getMoviesData();

    @GET()
    public Call<DirectionResponse> getDirectionData(@Url String url);
}
