package com.example.android.delhi06;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class ShoppingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(R.drawable.connaught_place_3, (String) getText(R.string.CP), (String) getText(R.string.CP_summary),
                R.drawable.connaught_place_1, R.drawable.connaught_place_2, R.drawable.connaught_place_4, (String) getText(R.string.CP_description),
                28.631640, 77.216672, (String) getText(R.string.CP_address), (String) getText(R.string.CP_no)));

        places.add(new Place(R.drawable.khan_market_2, (String) getText(R.string.Khan), (String) getText(R.string.Khan_summary),
                R.drawable.khan_market_1, R.drawable.khan_market_3, R.drawable.khan_market_4, (String) getText(R.string.Khan_description),
                28.600392, 77.226814, (String) getText(R.string.Khan_address), (String) getText(R.string.Khan_no)));

        places.add(new Place(R.drawable.sarojini_nagar_4, (String) getText(R.string.Sarojini), (String) getText(R.string.Sarojini_summary),
                R.drawable.sarojini_nagar_1, R.drawable.sarojini_nagar_2, R.drawable.sarojini_nagar_3, (String) getText(R.string.Sarojini_description),
                28.576749, 77.196219, (String) getText(R.string.Sarojini_address), (String) getText(R.string.Sarojini_no)));

        places.add(new Place(R.drawable.chandini_chowk_1, (String) getText(R.string.Chowk), (String) getText(R.string.Chowk_summary),
                R.drawable.chandini_chowk_2, R.drawable.chandini_chowk_3, R.drawable.chandini_chowk_4, (String) getText(R.string.Chowk_description),
                28.657870, 77.230145, (String) getText(R.string.Chowk_address), (String) getText(R.string.Chowk_no)));

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        PlaceAdapter adapter = new PlaceAdapter(places);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}