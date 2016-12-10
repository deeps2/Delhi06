package com.example.android.delhi06;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceViewHolder extends RecyclerView.ViewHolder{

    public ImageView mPlaceImage;  //has to be public as it is accessed directly inside populateViewHolder() in all Fragments
    public TextView mPlaceName;
    public TextView mPlaceSummary;
    public View mView;

    public PlaceViewHolder(View v) {
        super(v);
        this.mView = v;
        this.mPlaceImage = (ImageView) mView.findViewById(R.id.place_image);
        this.mPlaceName = (TextView) mView.findViewById(R.id.place_name);
        this.mPlaceSummary = (TextView) mView.findViewById(R.id.place_summary);
    }
}