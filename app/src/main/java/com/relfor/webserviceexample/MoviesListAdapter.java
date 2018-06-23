package com.relfor.webserviceexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.relfor.webserviceexample.data.Movie;

import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListViewHolder> {

    List<Movie> movieList;

    public MoviesListAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MoviesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_list, null);

        return new MoviesListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesListViewHolder holder, int position) {

        Movie movie = movieList.get(position);

        holder.txtName.setText(movie.getName());

        holder.txtPublisher.setText(movie.getPublisher());

        holder.txtTeam.setText(movie.getTeam());


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
