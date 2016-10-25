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
        //places.add(new Place(R.drawable.bukhara_1,"Bukhara - ITC Maurya", "10-time winner of the 'Times Food Award'"));
        //places.add(new Place(R.drawable.karim_1,"Karim's","Long established (Est.1913) chain cooking up a range of traditional Mughlai dishes"));
        //places.add(new Place(R.drawable.motimahal_3,"Moti Mahal","“Coming to Delhi without eating at Moti Mahal would be like visiting Agra without seeing Taj Mahal.” – Maulana Azad, Former Education Minister"));
        //places.add(new Place(R.drawable.wengers_3,"Wenger's","Enduring cafe serving a range of sweet patisserie and international snack dishes for over 75 years."));

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        PlaceAdapter adapter = new PlaceAdapter(getActivity(),places);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}
