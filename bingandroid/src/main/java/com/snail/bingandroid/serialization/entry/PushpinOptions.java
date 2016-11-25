package com.snail.bingandroid.serialization.entry;

import com.snail.bingandroid.serialization.ISerializable;

/**
 * Created by Leonid Veremchuk on 11/7/16.
 */
public class PushpinOptions extends BaseBingEntry implements ISerializable {
    public PushpinOptions setColor(String color) {
        mValues.put("color", color);
        return this;
    }

    public PushpinOptions setColor(Color color) {
        mValues.put(getEntryName(color), color);
        return this;
    }

    public PushpinOptions setDraggable(boolean draggable) {
        mValues.put("draggable", draggable);
        return this;
    }

    @Override
    public String toJsObject() {
        return toBaseString(mValues);
    }
}
