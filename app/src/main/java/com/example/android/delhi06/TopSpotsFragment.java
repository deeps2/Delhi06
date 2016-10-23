package com.example.android.delhi06;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class TopSpotsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.drawable.red_fort_1,"Red Fort","Iconic 1600s imperial residence & museum"));
        places.add(new Place(R.drawable.qutub_minar_1,"Qutub Minar","5-storey victory tower with balconies"));
        places.add(new Place(R.drawable.india_gate_1,"India Gate","1920s triumphal arcch & war memorial"));
        places.add(new Place(R.drawable.humayun_tomb_1,"Humayun's Tomb","Palatial 16th-century tomb of Humayun"));

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        PlaceAdapter adapter = new PlaceAdapter(places);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}
