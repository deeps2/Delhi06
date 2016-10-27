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
        places.add(new Place(R.drawable.red_fort_1, (String) getText(R.string.Red_fort), (String) getText(R.string.Red_fort_summary),
                R.drawable.red_fort_2, R.drawable.red_fort_3, R.drawable.red_fort_4, (String) getText(R.string.Red_fort_description),
                28.656179, 77.241022, (String) getText(R.string.Red_fort_address), (String) getText(R.string.Red_fort_no)));

        places.add(new Place(R.drawable.qutub_minar_4, (String) getText(R.string.Qutub_Minar), (String) getText(R.string.Qutub_Minar_summary),
                R.drawable.qutub_minar_1, R.drawable.qutub_minar_2, R.drawable.qutub_minar_3, (String) getText(R.string.Qutub_Minar_description),
                28.524504, 77.185461, (String) getText(R.string.Qututb_Minar_address), (String) getText(R.string.Qutub_Minar_no)));

        // places.add(new Place(R.drawable.qutub_minar_4,"Qutub Minar","5-storey victory tower with balconies"));
        // places.add(new Place(R.drawable.india_gate_2,"India Gate","1920s triumphal arcch & war memorial"));
        // places.add(new Place(R.drawable.humayun_tomb_1,"Humayun's Tomb","Palatial 16th-century tomb of Humayun"));

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}
