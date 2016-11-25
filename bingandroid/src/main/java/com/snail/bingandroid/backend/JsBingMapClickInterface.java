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

public class JsBingMapClickInterface {
    String TAG = getClass().getSimpleName();

    private IBackendObserverCallback mHandler;

    public JsBingMapClickInterface(@NonNull IBackendObserverCallback handler) {
        mHandler = handler;
    }

    @JavascriptInterface
    public void onMapClick(Object object) {
        Log.i(TAG, "onMapClick");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                IBindMapClickCallback callback = (IBindMapClickCallback) mHandler.getInterface(IBindMapClickCallback.class);
                if (callback != null) {
                    callback.onMapClick(null);
                }
            }
        });
    }
}
