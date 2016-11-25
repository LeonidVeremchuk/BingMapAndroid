package com.snail.bingandroid.serialization.entry;


import com.snail.bingandroid.serialization.ISerializable;

/**
 * Created by Leonid Veremchuk on 11/8/16.
 */

public class ViewOptions extends BaseBingEntry implements ISerializable {

    public void setZoom(int zoom) {
        mValues.put("zoom", zoom);
    }

    public void setMapTypeId(MapTypeId mapTypeId) {
        mValues.put("mapTypeId", mapTypeId);
    }

    public void setPadding(int paddingInPixel) {
        mValues.put("padding", paddingInPixel);
    }

    public int getZoom() {
        return (int) mValues.get("zoom");
    }

    @Override
    public String toJsObject() {
        return toBaseString(mValues);
    }
}
