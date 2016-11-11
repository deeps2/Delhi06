package com.example.android.delhi06;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private ArrayList<Place> places;

    public PlaceAdapter(ArrayList<Place> pl) {
        places = pl;
    }

    // provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mPlaceImage;  //has to be public as it is accessed directly by ViewHolder object in onBindViewHolder()
        public TextView mPlaceName;
        public TextView mPlaceSummary;
        public final Context context;

        public ViewHolder(final Context context, View v) {
            super(v);
            mPlaceImage = (ImageView) v.findViewById(R.id.place_image);
            mPlaceName = (TextView) v.findViewById(R.id.place_name);
            mPlaceSummary = (TextView) v.findViewById(R.id.place_summary);
            this.context = context;
            v.setOnClickListener(this);
        }

        //when a card gets clicked in the recycler view
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Place currentPlaceObject = places.get(position);

            IntentPlaceObject currentPlace = new IntentPlaceObject(currentPlaceObject.getImageResourceId(),
                    currentPlaceObject.getPlaceName(),
                    currentPlaceObject.getPlaceImage1(),
                    currentPlaceObject.getPlaceImage2(),
                    currentPlaceObject.getPlaceImage3(),
                    currentPlaceObject.getPlaceDescription(),
                    currentPlaceObject.getLattitude(),
                    currentPlaceObject.getLongitude(),
                    currentPlaceObject.getAddress(),
                    currentPlaceObject.getPhoneNo());

            Intent mainIntent = new Intent(context, PlaceDescription.class);
            mainIntent.putExtra("CLICKED_PLACE", currentPlace);
            context.startActivity(mainIntent);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(context, v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PlaceAdapter.ViewHolder viewHolder, int position) {
        Place currentPlace = places.get(position);

        //populate the views inside cardviews
        viewHolder.mPlaceImage.setImageResource(currentPlace.getImageResourceId());
        viewHolder.mPlaceName.setText(currentPlace.getPlaceName());
        viewHolder.mPlaceSummary.setText(currentPlace.getPlaceSummary());
    }

    //Returns the total number of items in the data set held by the adapter.(invoked by the layout manager)
    @Override
    public int getItemCount() {
        return places.size();
    }
}
