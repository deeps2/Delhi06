package com.example.android.delhi06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TopSpotsFragment extends Fragment {

    FirebaseRecyclerAdapter<PlaceInfo, PlaceViewHolder> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ProgressBar mProgressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

        final RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("topspots");

        adapter = new FirebaseRecyclerAdapter<PlaceInfo, PlaceViewHolder>(
                PlaceInfo.class,
                R.layout.list_item,
                PlaceViewHolder.class,
                ref
        ) {
            @Override
            protected void populateViewHolder(PlaceViewHolder viewHolder, PlaceInfo place, final int position) {
                mProgressBar.setVisibility(ProgressBar.INVISIBLE);

                Glide.with(getActivity()).load(place.getTopimage()).into(viewHolder.mPlaceImage);
                viewHolder.mPlaceName.setText(place.getName());
                viewHolder.mPlaceSummary.setText(place.getSummary());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PlaceInfo item = adapter.getItem(position);
                        Intent mainIntent = new Intent(getActivity(), PlaceDescription.class);
                        mainIntent.putExtra("CLICKED_PLACE", item);
                        getActivity().startActivity(mainIntent);
                    }
                });
            }
        };

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                mRecyclerView.scrollToPosition(0);
            }
        });

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }
}
