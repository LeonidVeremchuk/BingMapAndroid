package com.snail.bingandroid;


import com.snail.bingandroid.backend.IBindMapClickCallback;
import com.snail.bingandroid.backend.IBingScreenLocationCallback;
import com.snail.bingandroid.backend.IInfoboxActionCallback;
import com.snail.bingandroid.backend.IPushpinAddCallback;
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

class MapController {
    private String TAG = getClass().getSimpleName();

    private BingMap.OnMapClickListener mOnMapClickListener;
    private BingMap.OnInfoBoxClickListener mOnInfoboxActionListener;
    private IPushpinClickCallback mOnPushpinClickCallback;
    private PushpinManager mPushpinManager;

    MapController() {
        mPushpinManager = new PushpinManager();
    }

    Pushpin addPushpin(Pushpin pushpin) {
        addPushpinToMapView(pushpin);
        return pushpin;
    }

    void setPushpins(List<ISerializable> pushPins) {
        setPushpinsToMapView(pushPins);
    }

    private void addPushpinToMapView(final Pushpin pushpin) {
        IPushpinAddCallback iPushpinAddCallback = new IPushpinAddCallback() {
            @Override
            public void onPushpinAdded() {
                mPushpinManager.addPushpin(pushpin);
            }
        };
        JsCommandService.getInstance().observe(iPushpinAddCallback, IPushpinAddCallback.class);
        JsCommandService.getInstance().loadPushpin(pushpin);
    }

    private void setPushpinsToMapView(List<ISerializable> pushpinsList) {
        JsCommandService.getInstance().loadPushpins(pushpinsList);
    }

    void clear() {
        JsCommandService.getInstance().clearPushpin();
    }

    void moveCamera(CameraUpdate cameraUpdate) {
        JsCommandService.getInstance().moveCamera(cameraUpdate);
    }

    void updateViewOption(ViewOptions viewOptions) {
        JsCommandService.getInstance().updateViewOptions(viewOptions);
    }

    void updateMapOption(MapOption mapOption) {
        JsCommandService.getInstance().updateMapOptions(mapOption);
    }

    void setOnPushpinClickListener(IPushpinClickCallback onPushpinClickCallback) {
        mOnPushpinClickCallback = onPushpinClickCallback;
        initPushpinsClickListener();
    }

    void setOnMapClickListener(BingMap.OnMapClickListener onMapClickListener) {
        mOnMapClickListener = onMapClickListener;
        initMapClickListener();
    }

    void setOnInfoboxActionListener(BingMap.OnInfoBoxClickListener clickListener) {
        mOnInfoboxActionListener = clickListener;
        initInfoboxActionListener();
    }

    private void initPushpinsClickListener() {
        IPushpinClickCallback iPushpinClickCallback = new IPushpinClickCallback() {
            @Override
            public Infobox onPushPinClick(Pushpin pushpin) {
                if (mOnPushpinClickCallback != null) {
                    return mOnPushpinClickCallback.onPushPinClick(pushpin);
                }
                return null;
            }
        };
        JsCommandService.getInstance().observe(iPushpinClickCallback, IPushpinClickCallback.class);
        JsCommandService.getInstance().addPushpinClickListener();
    }

    private void initMapClickListener() {
        IBindMapClickCallback iBindMapClickCallback = new IBindMapClickCallback() {
            @Override
            public void onMapClick(Location location) {
                if (mOnMapClickListener != null) {
                    mOnMapClickListener.onMapClick(location);
                }
            }
        };
        JsCommandService.getInstance().observe(iBindMapClickCallback, IBindMapClickCallback.class);
    }

    void showInfobox(Infobox infobox) {
        JsCommandService.getInstance().showInfobox(infobox);
    }

    private void initInfoboxActionListener() {
        IInfoboxActionCallback infoboxActionCallback = new IInfoboxActionCallback() {
            @Override
            public void onLabelClick(String labelId) {
                if (mOnInfoboxActionListener != null) {
                    mOnInfoboxActionListener.onInfoboxClick(labelId);
                }
            }
        };
        JsCommandService.getInstance().observe(infoboxActionCallback, IInfoboxActionCallback.class);
    }

    void toScreenLocation(Location marker, IBingScreenLocationCallback callback) {
        JsCommandService.getInstance().getScreenLocation(marker);
        JsCommandService.getInstance().observe(callback, IBingScreenLocationCallback.class);
    }
}
