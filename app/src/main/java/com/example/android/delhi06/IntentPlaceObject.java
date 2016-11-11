package com.example.android.delhi06;

import java.io.Serializable;

//An instance of this class will be passed within Intent when a card is clicked inside the fragment. See onClick(); PlaceAdapter.java for usage purpose
public class IntentPlaceObject implements Serializable {

    private int mImageResourceId;
    private String mPlaceName;

    private int mPlaceImage1;
    private int mPlaceImage2;
    private int mPlaceImage3;
    private String mPlaceDescription;

    private double mLat;
    private double mLng;

    private String mAddress;
    private String mPhoneNo;


    public IntentPlaceObject(int id, String placeName, int placeImage1, int placeImage2,
                 int placeImage3, String placeDescription, double lat, double lng, String address, String phoneNo){
        mImageResourceId = id;
        mPlaceName = placeName;
        mPlaceImage1 = placeImage1;
        mPlaceImage2 = placeImage2;
        mPlaceImage3 = placeImage3;
        mPlaceDescription = placeDescription;
        mLat = lat;
        mLng = lng;
        mAddress = address;
        mPhoneNo = phoneNo;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public int getPlaceImage1() {
        return mPlaceImage1;
    }

    public int getPlaceImage2() {
        return mPlaceImage2;
    }

    public int getPlaceImage3() {
        return mPlaceImage3;
    }

    public String getPlaceDescription() {
        return mPlaceDescription;
    }

    public double getLattitude() {
        return mLat;
    }

    public double getLongitude() {
        return mLng;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhoneNo() {
        return mPhoneNo;
    }
}
