package com.relfor.webserviceexample.service;

import com.relfor.webserviceexample.data.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesEndpoint {

    @GET("demos/marvel/")
    public Call<List<Movie>> getMoviesData();
}
