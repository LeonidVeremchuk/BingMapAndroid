package com.snail.bingandroid;

import com.snail.bingandroid.backend.JsBingMapClickInterface;
import com.snail.bingandroid.backend.JsBingMapReadyInterface;
import com.snail.bingandroid.backend.JsBingMapScriptLoadInterface;
import com.snail.bingandroid.backend.JsBingScreenLocationInterface;
import com.snail.bingandroid.backend.JsInfoboxActionInterface;
import com.snail.bingandroid.backend.JsPushpinAddInterface;
import com.snail.bingandroid.backend.JsPushpinClickInterface;
import com.snail.bingandroid.backend.JsPushpinRemoveInterface;
import com.snail.bingandroid.backend.base.BaseCallback;
import com.snail.bingandroid.backend.base.IBackendObserverCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Leonid Veremchuk on 11/7/16.
 */

class JsCommandServiceObserver implements IBackendObserverCallback {
    private Map<String, BaseCallback> mJsUICallbacks;

    JsCommandServiceObserver() {
        mJsUICallbacks = new HashMap<>();
    }

    List<Object> applyInterfaces() {
        List<Object> jsInterfaceList = new ArrayList<>();

        jsInterfaceList.add(new JsBingMapClickInterface(this));
        jsInterfaceList.add(new JsBingMapReadyInterface(this));
        jsInterfaceList.add(new JsBingMapScriptLoadInterface(this));
        jsInterfaceList.add(new JsPushpinAddInterface(this));
        jsInterfaceList.add(new JsPushpinClickInterface(this));
        jsInterfaceList.add(new JsPushpinRemoveInterface(this));
        jsInterfaceList.add(new JsInfoboxActionInterface(this));
        jsInterfaceList.add(new JsBingScreenLocationInterface(this));

        return jsInterfaceList;
    }

    void observe(BaseCallback baseCallback, Class clazz) {
        mJsUICallbacks.put(getCallbackName(clazz), baseCallback);
    }

    private String getCallbackName(BaseCallback baseCallback) {
        return baseCallback.toString();
    }

    private String getCallbackName(Class clazz) {
        return clazz.toString();
    }

    @Override
    public Object getInterface(Class clazz) {
        return mJsUICallbacks.get(getCallbackName(clazz));
    }
}
