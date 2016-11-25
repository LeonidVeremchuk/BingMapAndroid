package com.snail.bingandroid.serialization.entry;


import com.snail.bingandroid.serialization.ISerializable;

/**
 * Created by Leonid Veremchuk on 11/16/16.
 */

public class Color extends BaseBingEntry implements ISerializable {

    public void setColor(Colors color) {
        switch (color) {
            case RED:
                setColor(219, 19, 33);
                break;
            case GREEN:
                setColor(30, 192, 17);
                break;
            case BLUE:
                setColor(47, 159, 205);
                break;
            case YELLOW:
                setColor(228, 178, 35);
                break;
        }
    }

    public void setColor(int red, int greed, int blue) {
        mValues.put("red", red);
        mValues.put("green", greed);
        mValues.put("blue", blue);
    }

    @Override
    public String toJsObject() {
        return "new Microsoft.Maps.Color(" + "1," + mValues.get("red") + ", " + mValues.get("green") + "," + mValues.get("blue") + ")";
    }

    public enum Colors {
        RED, GREEN, BLUE, YELLOW
    }
}
