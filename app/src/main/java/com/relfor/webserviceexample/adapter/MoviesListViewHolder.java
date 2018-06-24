package com.relfor.webserviceexample.adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.relfor.webserviceexample.R;

public class MoviesListViewHolder extends RecyclerView.ViewHolder {

    TextView txtName, txtTeam, txtPublisher;
    ImageView img;

    public MoviesListViewHolder(View itemView) {
        super(itemView);

        txtName = itemView.findViewById(R.id.txtName);
        txtPublisher = itemView.findViewById(R.id.txtPublisher);
        txtTeam = itemView.findViewById(R.id.txtTeam);
        img = itemView.findViewById(R.id.img);
    }
}
