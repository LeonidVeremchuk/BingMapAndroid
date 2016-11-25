package com.snail.bingandroid.backend;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.snail.bingandroid.backend.base.IBackendObserverCallback;

/**
 * Created by Leonid Veremchuk on 11/7/16.
 */

public class JsPushpinClickInterface {
    String TAG = getClass().getSimpleName();

    private IBackendObserverCallback mHandler;

    public JsPushpinClickInterface(@NonNull IBackendObserverCallback handler) {
        mHandler = handler;
    }

    @JavascriptInterface
    public void onPushpinClick(Object args) {
        Log.i(TAG, "onPushpinClick");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                IPushpinClickCallback callback = (IPushpinClickCallback) mHandler.getInterface(IPushpinClickCallback.class);
                if (callback != null) {
                    callback.onPushPinClick(null);
                }
            }
        });
    }

}
