package com.example.android.delhi06;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TopSpotsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        //final ArrayList<Place> places = new ArrayList<Place>();

        /*
        places.add(new Place(R.drawable.red_fort_1, (String) getText(R.string.Red_fort), (String) getText(R.string.Red_fort_summary),
                R.drawable.red_fort_2, R.drawable.red_fort_3, R.drawable.red_fort_4, (String) getText(R.string.Red_fort_description),
                28.656179, 77.241022, (String) getText(R.string.Red_fort_address), (String) getText(R.string.Red_fort_no)));

        places.add(new Place(R.drawable.qutub_minar_4, (String) getText(R.string.Qutub_Minar), (String) getText(R.string.Qutub_Minar_summary),
                R.drawable.qutub_minar_1, R.drawable.qutub_minar_2, R.drawable.qutub_minar_3, (String) getText(R.string.Qutub_Minar_description),
                28.524504, 77.185461, (String) getText(R.string.Qututb_Minar_address), (String) getText(R.string.Qutub_Minar_no)));

        places.add(new Place(R.drawable.india_gate_2, (String) getText(R.string.India_Gate), (String) getText(R.string.India_Gate_summary),
                R.drawable.india_gate_1, R.drawable.india_gate_3, R.drawable.india_gate_4, (String) getText(R.string.India_Gate_description),
                28.612933, 77.229511, (String) getText(R.string.India_Gate_address), (String) getText(R.string.India_Gate_no)));

        places.add(new Place(R.drawable.humayun_tomb_1, (String) getText(R.string.Humayun_Tomb), (String) getText(R.string.Humayun_Tomb_summary),
                R.drawable.humayun_tomb_2, R.drawable.humayun_tomb_3, R.drawable.humayaun_tomb_4, (String) getText(R.string.Humayun_Tomb_description),
                28.593573, 77.250727, (String) getText(R.string.Humayun_Tomb_address), (String) getText(R.string.Humayun_Tomb_no)));
        */

        final RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        //PlaceAdapter adapter = new PlaceAdapter(places);

        //mRecyclerView.setAdapter(adapter); //this line will go down
        mRecyclerView.setHasFixedSize(true);




        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("topspots");

        final FirebaseRecyclerAdapter<PlaceInfo, PlaceViewHolder> adapter =
                new FirebaseRecyclerAdapter<PlaceInfo, PlaceViewHolder>(
                        PlaceInfo.class,
                        R.layout.list_item,
                        PlaceViewHolder.class,
                        ref
                ){
                    @Override
                    protected void populateViewHolder(PlaceViewHolder viewHolder, PlaceInfo place, int position) {
                        viewHolder.setTopImage(place.getTopimage());
                       // ImageView i = (ImageView) viewHolder.mView.findViewById(R.id.place_image);
                        //Log.v("PLACE_IMG",place.getTopimage());
                      // Glide.with(getActivity()).load(place.getTopimage()).into(viewHolder.mPlaceImage);

                        //Log.v("PLACE_NAME",place.getName());
                        viewHolder.setPlaceName(place.getName());
                       // viewHolder.mPlaceName.setText(place.getName());

                        //Log.v("PLACE_SUMMARY",place.getSummary());
                        viewHolder.setPlaceSummary(place.getSummary());
                        //viewHolder.mPlaceSummary.setText(place.getSummary());
                    }
                };

       final LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { //what should be position of this???
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                int friendlyMessageCount = adapter.getItemCount();
                int lastVisiblePosition = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                // If the recycler view is initially being loaded or the
                // user is at the bottom of the list, scroll to the bottom
                // of the list to show the newly added message.
                if (lastVisiblePosition == -1 ||
                        (positionStart >= (friendlyMessageCount - 1) &&
                                lastVisiblePosition == (positionStart - 1))) {
                    mRecyclerView.scrollToPosition(positionStart);
                }
            }
        });

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(adapter);

        return rootView;
    }


}
