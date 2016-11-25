package com.snail.bingandroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.List;

/**
 * Created by Leonid Veremchuk on 11/3/16.
 */

public class MapView extends WebView implements IBindMapJsCommandCallback, View.OnTouchListener {
    private BingMap mBingMap;
    private UiSettings mUiSettings;
    private String TAG=getClass().getSimpleName();

    public MapView(Context context) {
        super(context);
        init();
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public MapView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        init();
    }

    private void init() {
        setOnTouchListener(this);
        mUiSettings = new UiSettings();
        mBingMap = new BingMap();
        JsCommandService.getInstance().init(this);
    }

    public void getMapAsync(final String key, final OnMapReadyCallback callback) {
        Log.d(TAG, "getMapAsync() called with: key = [" + key + "], callback = [" + callback + "]");
        final WebSettings webSettings = getSettings();
        mBingMap.initMap(webSettings, callback, key, this);
    }

    @Override
    public void loadFunction(final String jsFunctionString) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                MapView.this.loadUrl(jsFunctionString);
            }
        });
    }

    @Override
    public void setInterfaceList(final List<Object> jsObjectInterface, final String assetPatch) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                for (Object object : jsObjectInterface) {
                    MapView.this.addJavascriptInterface(object, object.getClass().getSimpleName());
                }
                MapView.this.loadUrl(assetPatch);
            }
        });
    }

    UiSettings getUiSettings() {
        return mUiSettings;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return !mUiSettings.isTouchEnable();
    }

    public void clear() {
        if (Build.VERSION.SDK_INT < 18) {
            clearView();
        } else {
            loadUrl("javascript:document.open();document.close();");
        }
    }
}
