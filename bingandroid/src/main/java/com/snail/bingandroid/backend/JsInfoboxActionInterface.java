package com.snail.bingandroid.backend;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.snail.bingandroid.backend.base.IBackendObserverCallback;

/**
 * Created by Leonid Veremchuk on 11/9/16.
 */

public class JsInfoboxActionInterface {
    String TAG = getClass().getSimpleName();

    private IBackendObserverCallback mHandler;

    public JsInfoboxActionInterface(@NonNull IBackendObserverCallback handler) {
        mHandler = handler;
    }

    @JavascriptInterface
    public void onLabelClick(final String id) {
        Log.i(TAG, "onLabelClick");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                IInfoboxActionCallback callback = (IInfoboxActionCallback) mHandler.getInterface(IInfoboxActionCallback.class);
                if (callback != null) {
                    callback.onLabelClick(id);
                }
            }
        });
    }

}
