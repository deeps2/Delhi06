package com.example.android.delhi06;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ReligiousFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(R.drawable.laxminarayan_1, (String) getText(R.string.Laxmi), (String) getText(R.string.Laxmi_summary),
                R.drawable.laxminarayan_2, R.drawable.laxminarayan_3, R.drawable.laxminarayan_4, (String) getText(R.string.Laxmi_description),
                28.633261, 77.199509, (String) getText(R.string.Laxmi_address), (String) getText(R.string.Laxmi_no)));

        places.add(new Place(R.drawable.bangla_sahib_4, (String) getText(R.string.Bangla), (String) getText(R.string.Bangla_summary),
                R.drawable.bangla_sahib_1, R.drawable.bangla_sahib_2, R.drawable.bangla_sahib_3, (String) getText(R.string.Bangla_description),
                28.626442, 77.209042, (String) getText(R.string.Bangla_address), (String) getText(R.string.Bangla_no)));

        places.add(new Place(R.drawable.jama_masjid_1, (String) getText(R.string.Jama), (String) getText(R.string.Jama_summary),
                R.drawable.jama_masjid_2, R.drawable.jama_masjid_3, R.drawable.jama_masjid_4, (String) getText(R.string.Jama_description),
                28.650673, 77.233299, (String) getText(R.string.Jama_address), (String) getText(R.string.Jama_no)));

        places.add(new Place(R.drawable.lotus_temple_3, (String) getText(R.string.Lotus), (String) getText(R.string.Lotus_summary),
                R.drawable.lotus_temple_1, R.drawable.lotus_temple_2, R.drawable.lotus_temple_4, (String) getText(R.string.Lotus_description),
                28.553822, 77.258859, (String) getText(R.string.Lotus_address), (String) getText(R.string.Lotus_no)));

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        PlaceAdapter adapter = new PlaceAdapter(getActivity(),places);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}