package com.snail.bingandroid.serialization.entry;


import com.snail.bingandroid.serialization.ISerializable;

/**
 * Created by Leonid Veremchuk on 11/10/16.
 */
public class Point extends BaseBingEntry implements ISerializable {

    public Point(int x, int y) {
        mValues.put("x", x);
        mValues.put("y", y);
    }

    public int getX() {
        return (int) mValues.get("x");
    }

    public int getY() {
        return (int) mValues.get("y");
    }

    @Override
    public String toJsObject() {
        return toBaseString(mValues);
    }
}
