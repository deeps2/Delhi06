package com.example.android.delhi06;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    ImageView mSample;
   // Firebase mRef;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    //to exit the application when back button '<- ' is clicked on toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Firebase.setAndroidContext(this);
        mSample = (ImageView) findViewById(R.id.sample);
        //mRef = new Firebase("https://delhi06-31a81.firebaseio.com/Name");

        StorageReference gsReference = storage.getReferenceFromUrl("gs://delhi06-31a81.appspot.com/red_fort_1.jpg");
        Glide.with(this /* context */)
                .using(new FirebaseImageLoader())
                .load(gsReference)
                .into(mSample);



        //this was for the sample text view
        /*mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                mSample.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });*/


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);                          //will display the toolbar along with App's name i.e Delhi06
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//will display the back arrow '<-' button

        //set adapter to viewpager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.tab_viewpager);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //set viewpager with tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        //when a tab is clicked or selected via scrolling horizontally
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //adding animation to images corresponding to whatever category is selected
                Animation mAnim = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in);
                mAnim.setInterpolator(new DecelerateInterpolator());
                mAnim.setDuration(1100);

                ImageView i = (ImageView) findViewById(R.id.top_image);
                i.startAnimation(mAnim);

                int position = tab.getPosition();
                if (position == 0) {
                    i.setImageResource(R.drawable.topspots);
                } else if (position == 1) {
                    i.setImageResource(R.drawable.restaurant);
                } else if (position == 2) {
                    i.setImageResource(R.drawable.religious);
                } else {
                    i.setImageResource(R.drawable.shopping);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //do nothing
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //do nothing
            }
        });
    }
}
