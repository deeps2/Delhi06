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
        places.add(new Place(R.drawable.laxminarayan_1,"Laxmi Narayan Mandir","Expansive hindu temple with shrines"));
        places.add(new Place(R.drawable.bangla_sahib_4,"Bangla Sahib Gurudwara","Sikh religious site with healing waters"));
        places.add(new Place(R.drawable.jama_masjid_1,"Jama Masjid","Vast, 17th-century Mughal-style mosque"));
        places.add(new Place(R.drawable.lotus_temple_3,"Lotus Temple","Temple with a flower-like design"));

        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        PlaceAdapter adapter = new PlaceAdapter(getActivity(),places);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}