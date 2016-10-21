package com.example.android.delhi06;

import android.content.Context;
import android.support.v7.widget.RecyclerView;           //read whole code and understand it...better read codepath also
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
//    private String[] mDataset;

    private ArrayList<Place> places;
    private Context mContext;                                                       //and in getting position also .get();
                                                             //'places' we are using at the bottom to get the size ..see bottom of file...but why mContext even getContext() mouse hover says never used
    public PlaceAdapter(Context context,ArrayList<Place> pl){ // is this constructor needed i mean may be needed but compare it with miwok constructor...not making super call and assigning word object...why...if working this code then remove this constructor or instance variable of this file and comment initialisation of them in this constructor

        places = pl;     //we are just assigning to instance variable but are we using these instance variables below in this file...in miwok even we were not using words but we passed to it(confirmed by highlighting words in miwok wordadapter constructor...try to change that constructor call() and method + or not making super call or make super call without passing words obj in the constructor as we are not using it <- in miwok app, then in this file)
        mContext = context;
    }


    // Easy access to the context object in the recyclerview
    private Context getContext() {                              // try removing  this also....from codepath i copied
        return mContext;
    }

    //
    // rovide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public ViewHolder(View v) {   //later it will be the i think cardview or whatever which holds all things...read recycler view android doc(usme cardview bhee tha with recycle view) or xamarin vala if needed
            super(v);                       //or container view + all the views inside the container view.....parametrised constructor then......read in docs why this ViewHolder class is used
            mImageView = (ImageView)v.findViewById(R.id.tempoimage);
        }
        // each data item is just a string in this case  <--- IMPORTANT
//        public TextView mTextView;
//        public ViewHolder(TextView v) {
//            super(v);
//            mTextView = v;
//        }
    }

//    public PlaceAdapter(Context context, ArrayList<Place> places){//, int colorResourceID) {
//       // super(context, 0, places);     //see whether to call or not...according to below not required....if not required then change this constructor to non parametrised one...or no constructor and in TopSpotsFraggment.java last 3rd line modify the call
//    }

    // Provide a suitable constructor (depends on the kind of dataset)
//    public MyAdapter(String[] myDataset) {
//        mDataset = myDataset;
//    }

    // Create new views (invoked by the layout manager)
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item , parent, false);
        // set the view's size, margins, paddings and layout parameters
//        ...



//       Place currentPlace = getItem(position);                              --- get item not working...maybe not needed...whole 3 lines

//        ImageView i = (ImageView)listItemView.findViewById(R.id.tempoimage);
//        i.setImageResource(currentPlace.getImageResourceId());





        ViewHolder vh = new ViewHolder(v);     //is reduntant as warning why???????????????????
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
 //   public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mTextView.setText(mDataset[position]);

    public void onBindViewHolder(PlaceAdapter.ViewHolder viewHolder, int position) {
        Place currentPlace = places.get(position);

        ImageView i = viewHolder.mImageView;
        i.setImageResource(currentPlace.getImageResourceId());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
//        return mDataset.length;

        return places.size();
    }
}

/*
public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Context context, ArrayList<Place> places){//, int colorResourceID) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        ImageView i = (ImageView)listItemView.findViewById(R.id.tempoimage);
        i.setImageResource(currentPlace.getImageResourceId());

        return listItemView;

    }
}*/