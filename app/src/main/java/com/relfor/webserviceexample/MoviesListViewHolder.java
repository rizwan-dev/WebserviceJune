package com.relfor.webserviceexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MoviesListViewHolder extends RecyclerView.ViewHolder {

    TextView txtName, txtTeam, txtPublisher;

    public MoviesListViewHolder(View itemView) {
        super(itemView);

        txtName = itemView.findViewById(R.id.txtName);
        txtPublisher = itemView.findViewById(R.id.txtPublisher);
        txtTeam = itemView.findViewById(R.id.txtTeam);
    }
}
