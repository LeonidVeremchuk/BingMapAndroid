package com.snail.bingandroid.serialization.entry;

import android.support.annotation.NonNull;

import com.snail.bingandroid.serialization.ISerializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leonid Veremchuk on 11/7/16.
 */

abstract class BaseBingEntry {
    Map<String, Object> mValues;

    String getEntryName(@NonNull Object object) {
        return object.getClass().getSimpleName().toLowerCase();
    }

    BaseBingEntry() {
        mValues = new HashMap<>();
    }

    String getEntryName(Class clazz) {
        return clazz.getSimpleName().toLowerCase();
    }

    String toBaseString(Map<String, Object> values) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (String key : values.keySet()) {
            Object current = values.get(key);
            if (stringBuilder.length() > 1) {
                stringBuilder.append(",");
            }

            stringBuilder.append(key);
            stringBuilder.append(":");

            if (ISerializable.class.isInstance(current)) {
                stringBuilder.append(((ISerializable) current).toJsObject());
            } else {
                if (String.class.isInstance(current)) {
                    stringBuilder.append("\"");
                    stringBuilder.append(current.toString());
                    stringBuilder.append("\"");
                } else if (current instanceof String[]) {
                    stringBuilder.append(Arrays.toString((String[]) current));
                } else if (Enum.class.isInstance(current)) {
                    stringBuilder.append(((MapTypeId) current).getName());
                } else {
                    stringBuilder.append(String.valueOf(current));
                }
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

}
