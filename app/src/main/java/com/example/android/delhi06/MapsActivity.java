package com.example.android.delhi06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

        // sample code snippet to set the text content on the ExpandableTextView
        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.expand_text_view);

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        expTv1.setText(getString(R.string.dummy_text1));


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);

        DefaultSliderView textSliderView = new DefaultSliderView(this);
        textSliderView.image(R.drawable.pic1).setScaleType(BaseSliderView.ScaleType.FitCenterCrop);
        sliderShow.addSlider(textSliderView);

        DefaultSliderView textSliderView2 = new DefaultSliderView(this);
        textSliderView2.image(R.drawable.pic2);
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