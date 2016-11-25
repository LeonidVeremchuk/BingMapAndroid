package com.snail.bingandroid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebSettings;

import com.snail.bingandroid.backend.IBingMapReadyCallback;
import com.snail.bingandroid.backend.IBingMapScriptLoadCallback;
import com.snail.bingandroid.backend.IPushpinClickCallback;
import com.snail.bingandroid.serialization.ISerializable;
import com.snail.bingandroid.serialization.entry.CameraUpdate;
import com.snail.bingandroid.serialization.entry.Infobox;
import com.snail.bingandroid.serialization.entry.Location;
import com.snail.bingandroid.serialization.entry.MapOption;
import com.snail.bingandroid.serialization.entry.Pushpin;
import com.snail.bingandroid.serialization.entry.ViewOptions;

import java.util.List;

/**
 * Created by Leonid Veremchuk on 11/2/16.
 */

public class BingMap {
    private MapController mMapController;
    private Projection mProjection;
    private MapView mMapView;

    BingMap() {
        mMapController = new MapController();
        mProjection = new Projection(mMapController);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetJavaScriptEnabled")
    void initMap(final WebSettings webSettings, final OnMapReadyCallback callback, final String key, MapView mapView) {
        mMapView = mapView;
        IBingMapReadyCallback iBingMapReadyCallback = new IBingMapReadyCallback() {
            @Override
            public void onMapReady() {
                callback.onMapReady(BingMap.this);
            }
        };

        IBingMapScriptLoadCallback iBingMapScriptLoadCallback = new IBingMapScriptLoadCallback() {
            @Override
            public void onScriptLoadSuccess() {
                JsCommandService.getInstance().loadMapScenario(key);
            }
        };

        JsCommandService.getInstance().observe(iBingMapReadyCallback, IBingMapReadyCallback.class);
        JsCommandService.getInstance().observe(iBingMapScriptLoadCallback, IBingMapScriptLoadCallback.class);
        if (webSettings != null) {
            webSettings.setJavaScriptEnabled(true);
            webSettings.setAllowFileAccessFromFileURLs(true);
            webSettings.setAllowUniversalAccessFromFileURLs(true);
        }
        JsCommandService.getInstance().loadAssets();
    }

    public void clear() {
        mMapController.clear();
    }

    public void setOnPushpinClickListener(IPushpinClickCallback pushpinClickCallback) {
        mMapController.setOnPushpinClickListener(pushpinClickCallback);
    }

    public void setOnMapClickListener(OnMapClickListener clickListener) {
        mMapController.setOnMapClickListener(clickListener);
    }

    public Pushpin addPushpin(Pushpin pushpin) {
        return mMapController.addPushpin(pushpin);
    }

    public void setPushPins(List<ISerializable> pushpinList) {
        mMapController.setPushpins(pushpinList);
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        mMapController.moveCamera(cameraUpdate);
    }

    public void updateViewOptions(ViewOptions viewOptions) {
        mMapController.updateViewOption(viewOptions);
    }

    public void updateMapOptions(MapOption mapOption) {
        mMapController.updateMapOption(mapOption);
    }

    public void setOnInfoBoxClickListener(OnInfoBoxClickListener clickListener) {
        mMapController.setOnInfoboxActionListener(clickListener);
    }

    public void showInbox(Infobox infobox) {
        mMapController.showInfobox(infobox);
    }

    public Projection getProjection() {
        return mProjection;
    }

    public UiSettings getUiSettings() {
        return mMapView.getUiSettings();
    }

    public interface OnInfoBoxClickListener {
        void onInfoboxClick(String labelId);
    }

    public interface OnMapClickListener {
        void onMapClick(Location location);
    }
}
