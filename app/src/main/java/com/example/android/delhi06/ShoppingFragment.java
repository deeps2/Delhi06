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
        places.add(new Place(R.drawable.connaught_place_3,"Connaught Place","5th most expensive office market in the world"));
        places.add(new Place(R.drawable.khan_market_2,"Khan Market","Khan Market (Est.1951) has been ranked as the costliest retail location in India"));
        places.add(new Place(R.drawable.sarojini_nagar_4,"Sarojini-Nagar Market","One of Delhi's biggest markets and a destination for every girl who's out on a hunt for trendy clothes at killer prices"));
        places.add(new Place(R.drawable.chandini_chowk_1,"Chandini Chowk","One of the oldest and busiest markets in Old Delhi"));

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}