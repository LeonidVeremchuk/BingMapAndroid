package com.snail.bingandroid.serialization.entry;

import com.snail.bingandroid.serialization.ISerializable;

/**
 * Created by Leonid Veremchuk on 11/8/16.
 */

public class MapOption extends BaseBingEntry implements ISerializable {

    public MapOption setZoomLevel(int min, int max) {
        mValues.put("minZoom", min);
        mValues.put("maxZoom", max);
        return this;
    }

    public MapOption showDashboard(boolean isEnable) {
        mValues.put("showDashboard", isEnable);
        return this;
    }

    public MapOption showLocalMeButton(boolean isEnable) {
        mValues.put("showLocalMeButton", isEnable);
        return this;
    }

    public MapOption showZoomButton(boolean isEnable) {
        mValues.put("showZoomButton", isEnable);
        return this;
    }

    public int getMaxZoom() {
        return (int) mValues.get("maxZoom");
    }

    public int getMinZoom() {
        return (int) mValues.get("minZoom");
    }

    @Override
    public String toJsObject() {
        return toBaseString(mValues);
    }
}
