package com.snail.bingandroid;

import android.annotation.SuppressLint;
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
import android.widget.FrameLayout;

import java.util.List;

/**
 * Created by Leonid Veremchuk on 11/3/16.
 */

public class MapView extends FrameLayout implements IBindMapJsCommandCallback, View.OnTouchListener {
    private WebView mWebView;
    private BingMap mBingMap;
    private UiSettings mUiSettings;
    private String TAG = getClass().getSimpleName();

    public MapView(Context context) {
        super(context);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        mWebView = new WebView(getContext());
        addView(mWebView);
        setOnTouchListener(this);
        mUiSettings = new UiSettings();
        mBingMap = new BingMap();
        JsCommandService.getInstance().init(this);
    }

    public void getMapAsync(final String key, final OnMapReadyCallback callback) {
        Log.d(TAG, "getMapAsync() called with: key = [" + key + "], callback = [" + callback + "]");
        init();
        final WebSettings webSettings = mWebView.getSettings();
        mBingMap.initMap(webSettings, callback, key, this);
    }

    @Override
    public void loadFunction(final String jsFunctionString) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                MapView.this.mWebView.loadUrl(jsFunctionString);
            }
        });
    }

    @Override
    public void setInterfaceList(final List<Object> jsObjectInterface, final String assetPatch) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @SuppressLint("JavascriptInterface")
            @Override
            public void run() {
                for (Object object : jsObjectInterface) {
                    MapView.this.mWebView.addJavascriptInterface(object, object.getClass().getSimpleName());
                }
                MapView.this.mWebView.loadUrl(assetPatch);
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

    public void onPause() {
        removeView(mWebView);
    }

}
