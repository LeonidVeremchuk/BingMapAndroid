package com.snail.bingandroid.serialization;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Leonid Veremchuk on 11/3/16.
 */

public class SerializationManager<T extends ISerializable> {

    private String TAG = "SerializationManager";

    public String serialize(T iSerializable) {
        String serializeString = iSerializable.toJsObject();
        Log.i(TAG, "serialize() called with: iSerializable = [" + serializeString + "]");
        return serializeString;
    }

    public String[] serializeToStringArray(List<T> serializeList) {
        String[] pushpins = new String[serializeList.size()];
        for (int i = 0; i < serializeList.size(); i++) {
            pushpins[i] = serializeList.get(i).toJsObject();
        }
        Log.i(TAG, "serializeToStringArray() called with: pushpinList = [" + Arrays.toString(pushpins) + "]");
        return pushpins;
    }
}
