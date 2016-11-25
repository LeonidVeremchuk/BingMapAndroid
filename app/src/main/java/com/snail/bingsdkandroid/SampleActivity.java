package com.snail.bingsdkandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.snail.bingandroid.BingMap;
import com.snail.bingandroid.MapView;
import com.snail.bingandroid.OnMapReadyCallback;
import com.snail.bingandroid.serialization.entry.Color;
import com.snail.bingandroid.serialization.entry.Location;
import com.snail.bingandroid.util.PushpinCreator;

import java.util.Random;

public class SampleActivity extends AppCompatActivity implements OnMapReadyCallback, BingMap.OnMapClickListener {
    private BingMap mBingMap;
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
    }

    private void initMap() {
        mMapView = (MapView) findViewById(R.id.map_view);
        mMapView.getMapAsync("Your Bing API Key", this);
    }

    @Override
    public void onMapReady(BingMap bingMap) {
        mBingMap = bingMap;
        mBingMap.setOnMapClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMap();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onMapClick(Location latLng) {
        createPushpin(latLng);
    }

    private void createPushpin(Location location){
        PushpinCreator pushpinCreator = new PushpinCreator(String.valueOf(new Random().nextInt()));
        pushpinCreator.setLocation(location);
        pushpinCreator.setPushingColor(Color.Colors.BLUE);
        pushpinCreator.setInfobox("Test","Infobox");

        mBingMap.addPushpin(pushpinCreator.create());
    }
}
