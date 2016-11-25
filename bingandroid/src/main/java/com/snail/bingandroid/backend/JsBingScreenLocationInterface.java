package com.snail.bingandroid.backend;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.snail.bingandroid.backend.base.IBackendObserverCallback;
import com.snail.bingandroid.serialization.entry.Point;


/**
 * Created by Leonid Veremchuk on 11/10/16.
 */

public class JsBingScreenLocationInterface {
    String TAG = getClass().getSimpleName();

    private IBackendObserverCallback mHandler;

    public JsBingScreenLocationInterface(@NonNull IBackendObserverCallback handler) {
        mHandler = handler;
    }

    @JavascriptInterface
    public void onPoint(final int x, final int y) {
        Log.i(TAG, "onPoint");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                IBingScreenLocationCallback callback = (IBingScreenLocationCallback) mHandler.getInterface(IBingScreenLocationCallback.class);
                if (callback != null) {
                    callback.onPoint(new Point(x, y));
                }
            }
        });
    }
}
