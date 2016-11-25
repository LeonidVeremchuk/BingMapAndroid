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

public class JsPushpinAddInterface {
    String TAG = getClass().getSimpleName();

    private IBackendObserverCallback mHandler;

    public JsPushpinAddInterface(@NonNull IBackendObserverCallback handler) {
        mHandler = handler;
    }

    @JavascriptInterface
    public void onPushpinAdded() {
        Log.i(TAG, "onPushpinAdded");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                IPushpinAddCallback callback = (IPushpinAddCallback) mHandler.getInterface(IPushpinAddCallback.class);
                if (callback != null) {
                    callback.onPushpinAdded();
                }
            }
        });
    }

}
