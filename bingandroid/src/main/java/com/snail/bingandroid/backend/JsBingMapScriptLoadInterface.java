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

public class JsBingMapScriptLoadInterface {
    String TAG = getClass().getSimpleName();

    private IBackendObserverCallback mHandler;

    public JsBingMapScriptLoadInterface(@NonNull IBackendObserverCallback handler) {
        mHandler = handler;
    }

    @JavascriptInterface
    public void onScriptLoadSuccess() {
        Log.i(TAG, "onScriptLoadSuccess");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                IBingMapScriptLoadCallback callback = (IBingMapScriptLoadCallback) mHandler.getInterface(IBingMapScriptLoadCallback.class);
                if (callback != null) {
                    callback.onScriptLoadSuccess();
                }
            }
        });
    }
}
