package com.snail.bingandroid.serialization.entry;

import com.snail.bingandroid.serialization.ISerializable;

/**
 * Created by Leonid Veremchuk on 11/9/16.
 */

public class InfoboxActions extends BaseBingEntry implements ISerializable {

    public InfoboxActions(String label, String id) {
        mValues.put("id", id);
        mValues.put("label", label);
        mValues.put("eventHandler", "");
    }

    @Override
    public String toJsObject() {
        return toBaseString(mValues);
    }
}