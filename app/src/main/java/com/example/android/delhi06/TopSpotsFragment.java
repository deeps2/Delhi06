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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(R.drawable.bangla_sahib_1));//("one", "lutti", R.drawable.number_one, R.raw.number_one));
        places.add(new Place(R.drawable.bangla_sahib_2));//("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        places.add(new Place(R.drawable.sarojini_nagar_1));//("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        places.add(new Place(R.drawable.bukhara_2));//("four", "oyyisa", R.drawable.number_four, R.raw.number_four));

             // PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);//, R.color.category_numbers);
                RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);


        PlaceAdapter adapter = new PlaceAdapter(getActivity(),places);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));   //in fragment this-> getactivity()...note it down somewhere


    /*
      RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new PlaceAdapter(getActivity(),places);
        mRecyclerView.setAdapter(mAdapter);
    */
                //listView.setAdapter(adapter);

        return rootView;
    }
}
