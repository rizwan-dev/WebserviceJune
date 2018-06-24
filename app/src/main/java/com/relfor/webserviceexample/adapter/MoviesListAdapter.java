package com.relfor.webserviceexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.relfor.webserviceexample.R;
import com.relfor.webserviceexample.data.Movie;

import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListViewHolder> {

    List<Movie> movieList;
    Context context;

    public MoviesListAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
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

        Glide.with(context).load(movie.getImageurl()).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
