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

public class JsPushpinRemoveInterface {
    String TAG = getClass().getSimpleName();

    private IBackendObserverCallback mHandler;

    public JsPushpinRemoveInterface(@NonNull IBackendObserverCallback handler) {
        mHandler = handler;
    }

    @JavascriptInterface
    public void onPushpinRemove() {
        Log.i(TAG, "onPushpinRemove");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                IPushpinRemoveCallback callback = (IPushpinRemoveCallback) mHandler.getInterface(IPushpinRemoveCallback.class);
                if (callback != null) {
                    callback.onPushpinRemove();
                }
            }
        });
    }
}
