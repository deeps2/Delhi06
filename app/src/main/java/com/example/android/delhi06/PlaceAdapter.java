package com.example.android.delhi06;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private ArrayList<Place> places;
    private Context mContext;

    public PlaceAdapter(Context context,ArrayList<Place> pl){
        places = pl;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    public Context getContext() {
        return mContext;
    }

    // provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder{//} implements View.OnClickListener {

        public ImageView mPlaceImage;  //has to be public as it is accessed directly by ViewHolder object in onBindViewHolder()
        public TextView  mPlaceName;
        public TextView  mPlaceSummary;
        public final Context context;

        public ViewHolder(final Context context, View v) {
            super(v);
            mPlaceImage = (ImageView)v.findViewById(R.id.place_image);
            mPlaceName = (TextView)v.findViewById(R.id.place_name);
            mPlaceSummary = (TextView)v.findViewById(R.id.place_summary);

            this.context = context;
            // Attach a click listener to the entire row view
            //v.setOnClickListener(this);

/*
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MapsActivity.class);
                    context.startActivity(intent);
                }
            });*/


            itemView.setOnClickListener(new CardOnClickListener());




        }


        class CardOnClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                // TODO Handle item click
                Log.e("click","Clicked !!!");
            }
        }










  /*
        // Handles the row being being clicked
        @Override
        public void onClick(View view) {
          // int position = getAdapterPosition(); // gets item position
           // if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it

            //    User user = users.get(position);
                // We can access the data within the views
            //    Toast.makeText(context, mPlaceName.getText(), Toast.LENGTH_SHORT).show();

                String str = mPlaceName.getText().toString();
                String str2 = mPlaceSummary.getText().toString();
                Log.i(str,str2);

                Intent intent =  new Intent(context, MapsActivity.class);
                //context.startActivity(intent);
                view.getContext().startActivity(intent);


           // Intent mainIntent = new Intent(MainActivity.this,MainActivity.class);
           // startActivity(mainIntent);

           //}
        }    */
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item , parent, false);
        ViewHolder vh = new ViewHolder(context, v);
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
