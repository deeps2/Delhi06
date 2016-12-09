package com.example.android.delhi06;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.android.delhi06.R.id.place;


public class PlaceViewHolder extends RecyclerView.ViewHolder { //may have to implement onClickListener also so later add implements View.OnClickListener


    public ImageView mPlaceImage;  //has to be public as it is accessed directly by ViewHolder object in onBindViewHolder()


    public TextView mPlaceName;
    public TextView mPlaceSummary;

    //public final Context context;//copied from placeAdapter.java

    public View mView; //may be needed as per copied example below

    public PlaceViewHolder(View v) {
        super(v);
        this.mView = v;
        this.mPlaceImage = (ImageView) mView.findViewById(R.id.place_image);
        this.mPlaceName = (TextView) mView.findViewById(R.id.place_name);
        this.mPlaceSummary = (TextView) mView.findViewById(R.id.place_summary);
    }

    public void setTopImage(String url) {
        //this.mPlaceImage = (ImageView) mView.findViewById(R.id.place_image);


        //Glide.with(MainActivity.class).load(place.getTopimage()).into(viewHolder.mPlaceImage);
        //this.mPlaceImage.setText(firstN);  //something have to do setImageResource or how to fill bytes into an imageview like that
        //process string url and put it inside above imageview
    }

    public void setPlaceName(String pName) {
        //this.mPlaceName = (TextView) mView.findViewById(R.id.place_name);
        this.mPlaceName.setText(pName);
        if(pName == null)
            Log.v("null","NULL");
    }

    public void setPlaceSummary(String pSummary) {
        //this.mPlaceSummary = (TextView) mView.findViewById(R.id.place_summary);
        this.mPlaceSummary.setText(pSummary);
    }

}

    /*
    public void setTopImage(String url) {
          //this.mPlaceImage = (ImageView) mView.findViewById(R.id.place_image);



        //this.mPlaceImage.setText(firstN);  //something have to do setImageResource or how to fill bytes into an imageview like that
        //process string url and put it inside above imageview
    }

    public void setPlaceName(String pName) {
        //this.mPlaceName = (TextView) mView.findViewById(R.id.place_name);
        this.mPlaceName.setText(pName);
        if(pName == null)
           Log.v("null","NULL");
    }

    public void setPlaceSummary(String pSummary) {
        //this.mPlaceSummary = (TextView) mView.findViewById(R.id.place_summary);
        this.mPlaceSummary.setText(pSummary);
    }

    /*public ViewHolder(final Context context, View v) {
        super(v);
        mPlaceImage = (ImageView) v.findViewById(R.id.place_image);
        mPlaceName = (TextView) v.findViewById(R.id.place_name);
        mPlaceSummary = (TextView) v.findViewById(R.id.place_summary);
        this.context = context;
        v.setOnClickListener(this);
    }*/   //copied from PlaceAdapter.java



    //copied code from stack overflow example for a similar viewholder
    /*
    TextView firstName;
    TextView lastName;
    TextView address;
    View mView;


    public DeveloperViewHolder(View v) {
        super(v);
        this.mView = v;
    }

    public void setFirstName(String firstN) {
        this.firstName = (TextView) mView.findViewById(R.id.firstname_row);
        this.firstName.setText(firstN);
    }

    public void setLastName(String lastN) {
        this.lastName = (TextView) mView.findViewById(R.id.lastname_row);
        this.lastName.setText(lastN);
    }

    public void setAddress(String addr) {
        this.address = (TextView) mView.findViewById(R.id.address_row);
        this.address.setText(addr);
    }  */


