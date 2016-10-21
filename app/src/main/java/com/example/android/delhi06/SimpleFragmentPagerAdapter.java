package com.example.android.delhi06;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    // fm is the fragment manager that will keep each fragment's state in the adapter across swipes.
    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TopSpotsFragment();
        } else if (position == 1){
            return new TopSpotsFragment();  //change these fragments
        } else if (position == 2) {
            return new TopSpotsFragment();
        }
        else {
            return new TopSpotsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return mContext.getString(R.string.category_topspots);
        } else if (position == 1) {
            return mContext.getString(R.string.category_restaurants);
        } else if (position == 2) {
            return mContext.getString(R.string.category_religious);
        } else {
            return mContext.getString(R.string.category_shopping);
        }

    }
}
