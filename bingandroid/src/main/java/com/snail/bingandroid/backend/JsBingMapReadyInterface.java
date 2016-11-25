package com.snail.bingandroid.backend;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.snail.bingandroid.backend.base.IBackendObserverCallback;


/**
 * Created by Leonid Veremchuk on 11/3/16.
 */

public class JsBingMapReadyInterface {
    String TAG = getClass().getSimpleName();

    private IBackendObserverCallback mHandler;

    public JsBingMapReadyInterface(@NonNull IBackendObserverCallback handler) {
        mHandler = handler;
    }

    @JavascriptInterface
    public void onMapReady() {
        Log.i(TAG, "onMapReady");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                IBingMapReadyCallback callback = (IBingMapReadyCallback) mHandler.getInterface(IBingMapReadyCallback.class);
                if (callback != null) {
                    callback.onMapReady();
                }
            }
        });
    }
}
