package com.example.android.delhi06;

public class Place {

    private int mImageResourceId;
    private String mPlaceName;
    private String mPlaceSummary;

    public Place(int id, String placeName, String placeSummary){
        mImageResourceId = id;
        mPlaceName = placeName;
        mPlaceSummary = placeSummary;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public String getPlaceSummary(){
        return mPlaceSummary;
    }

}

