package com.example.android.delhi06;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(R.drawable.bukhara_1, (String) getText(R.string.Bukhara), (String) getText(R.string.Bukhara_summary),
                R.drawable.bukhara_2, R.drawable.bukhara_3, R.drawable.bukhara_4, (String) getText(R.string.Bukhara_description),
                28.597279, 77.173669, (String) getText(R.string.Bukhara_address), (String) getText(R.string.Bukhara_no)));

        places.add(new Place(R.drawable.karim_4, (String) getText(R.string.Karim), (String) getText(R.string.Karim_summary),
                R.drawable.karim_2, R.drawable.karim_3, R.drawable.karim_1, (String) getText(R.string.Karim_description),
                28.649437, 77.23379, (String) getText(R.string.Karim_address), (String) getText(R.string.Karim_no)));

        places.add(new Place(R.drawable.motimahal_3, (String) getText(R.string.Motimahal), (String) getText(R.string.Motimahal_summary),
                R.drawable.motimahal_1, R.drawable.motimahal_2, R.drawable.motimahal_4, (String) getText(R.string.Motimahal_description),
                28.646546, 77.240179, (String) getText(R.string.Motimahal_address), (String) getText(R.string.Motimahal_no)));

        places.add(new Place(R.drawable.wengers_3, (String) getText(R.string.Wengers), (String) getText(R.string.Wengers_summary),
                R.drawable.wengers_1, R.drawable.wengers_2, R.drawable.wengers_4, (String) getText(R.string.Wengers_description),
                28.631856, 77.216896, (String) getText(R.string.Wengers_address), (String) getText(R.string.Wengers_no)));

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}
