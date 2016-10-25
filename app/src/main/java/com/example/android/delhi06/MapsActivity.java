package com.example.android.delhi06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        IntentPlaceObject currentPlace = (IntentPlaceObject) getIntent().getSerializableExtra("CLICKED_PLACE");

        TextView  tv1 = (TextView)findViewById(R.id.tv1);
        TextView  tv2 = (TextView)findViewById(R.id.tv2);
        TextView  tv3 = (TextView)findViewById(R.id.tv3);
        TextView  tv4 = (TextView)findViewById(R.id.tv4);
        TextView  tv5 = (TextView)findViewById(R.id.tv5);
        TextView  tv6 = (TextView)findViewById(R.id.tv6);
        TextView  tv7 = (TextView)findViewById(R.id.tv7);
        TextView  tv8 = (TextView)findViewById(R.id.tv8);
        TextView  tv9 = (TextView)findViewById(R.id.tv9);
        TextView  tv10 = (TextView)findViewById(R.id.tv10);
        TextView  tv11 = (TextView)findViewById(R.id.tv11);

        tv1.setText(getResources().getResourceEntryName(currentPlace.getImageResourceId()));
        tv2.setText(currentPlace.getPlaceName());
        tv3.setText(currentPlace.getPlaceSummary());
        tv4.setText(getResources().getResourceEntryName(currentPlace.getPlaceImage1()));
        tv5.setText(getResources().getResourceEntryName(currentPlace.getPlaceImage2()));
        tv6.setText(getResources().getResourceEntryName(currentPlace.getPlaceImage3()));
        tv7.setText(currentPlace.getPlaceDescription());
        tv8.setText(Double.toString(currentPlace.getLattitude()));
        tv9.setText(Double.toString(currentPlace.getLongitude()));
        tv10.setText(currentPlace.getAddress());
        tv11.setText(currentPlace.getPhoneNo());


        // sample code snippet to set the text content on the ExpandableTextView
        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.expand_text_view);

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        expTv1.setText(getString(R.string.dummy_text1));


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);

        DefaultSliderView textSliderView = new DefaultSliderView(this);
        textSliderView.image(R.drawable.red_fort_1).setScaleType(BaseSliderView.ScaleType.FitCenterCrop);
        sliderShow.addSlider(textSliderView);

        DefaultSliderView textSliderView2 = new DefaultSliderView(this);
        textSliderView2.image(R.drawable.bangla_sahib_2).setScaleType(BaseSliderView.ScaleType.FitCenterCrop);;
        sliderShow.addSlider(textSliderView2);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        String loc = "Red Fort";

        // Add a marker at location and move the camera.
        LatLng redFort = new LatLng(28.656451, 77.241031);
        mMap.addMarker(new MarkerOptions().position(redFort).title(loc));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redFort));
    }
}