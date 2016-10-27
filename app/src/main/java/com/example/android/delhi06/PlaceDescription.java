package com.example.android.delhi06;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Indicators.PagerIndicator;
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

public class PlaceDescription extends AppCompatActivity implements OnMapReadyCallback {

    IntentPlaceObject currentPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_description);

        currentPlace = (IntentPlaceObject) getIntent().getSerializableExtra("CLICKED_PLACE");

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle(currentPlace.getPlaceName());

        ImageView i = (ImageView)findViewById(R.id.place);
        i.setImageResource(currentPlace.getImageResourceId());

        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // sample code snippet to set the text content on the ExpandableTextView
        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.expand_text_view);

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        expTv1.setText(currentPlace.getPlaceDescription());


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);
        sliderShow.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));

        int image1 = currentPlace.getPlaceImage1();
        int image2 = currentPlace.getPlaceImage2();
        int image3 = currentPlace.getPlaceImage3();
        int image4 = currentPlace.getImageResourceId();

        DefaultSliderView textSliderView = new DefaultSliderView(this);
        textSliderView.image(image1).setScaleType(BaseSliderView.ScaleType.FitCenterCrop);
        sliderShow.addSlider(textSliderView);
        sliderShow.setDuration(1500);

        DefaultSliderView textSliderView2 = new DefaultSliderView(this);  //try using 1 object only
        textSliderView2.image(image2).setScaleType(BaseSliderView.ScaleType.FitCenterCrop);;
        sliderShow.addSlider(textSliderView2);
        sliderShow.setDuration(1500);

        DefaultSliderView textSliderView3 = new DefaultSliderView(this);
        textSliderView3.image(image3).setScaleType(BaseSliderView.ScaleType.FitCenterCrop);;
        sliderShow.addSlider(textSliderView3);
        sliderShow.setDuration(1500);

        DefaultSliderView textSliderView4 = new DefaultSliderView(this);
        textSliderView4.image(image4).setScaleType(BaseSliderView.ScaleType.FitCenterCrop);;
        sliderShow.addSlider(textSliderView4);
        sliderShow.setDuration(1500);

        TextView addr = (TextView)findViewById(R.id.address);
        addr.setText(currentPlace.getAddress());

        TextView phNo = (TextView)findViewById(R.id.phone_No);
        phNo.setText(currentPlace.getPhoneNo());

        LinearLayout call_layer = (LinearLayout) findViewById (R.id.call_layout);
        call_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +  currentPlace.getPhoneNo()));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;
        String name = currentPlace.getPlaceName();

        // Add a marker at location and move the camera.
        LatLng coordinates = new LatLng(currentPlace.getLattitude(), currentPlace.getLongitude());
        mMap.addMarker(new MarkerOptions().position(coordinates).title(name));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coordinates));
    }
}
