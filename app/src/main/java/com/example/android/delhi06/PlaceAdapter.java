package com.example.android.delhi06;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private ArrayList<Place> places;

    public PlaceAdapter(ArrayList<Place> pl){
        places = pl;
    }

    // provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mPlaceImage;  //has to be public as it is accessed directly by ViewHolder object in onBindViewHolder()
        public TextView  mPlaceName;
        public TextView  mPlaceSummary;

        public ViewHolder(View v) {
            super(v);
            mPlaceImage = (ImageView)v.findViewById(R.id.place_image);
            mPlaceName = (TextView)v.findViewById(R.id.place_name);
            mPlaceSummary = (TextView)v.findViewById(R.id.place_summary);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item , parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PlaceAdapter.ViewHolder viewHolder, int position) {
        Place currentPlace = places.get(position);

        viewHolder.mPlaceImage.setImageResource(currentPlace.getImageResourceId());
        viewHolder.mPlaceName.setText(currentPlace.getPlaceName());
        viewHolder.mPlaceSummary.setText(currentPlace.getPlaceSummary());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return places.size();
    }
}
