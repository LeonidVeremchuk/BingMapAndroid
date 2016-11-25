package com.snail.bingandroid.serialization.entry;

/**
 * Created by Leonid Veremchuk on 11/8/16.
 */

public enum MapTypeId {
    aerial(), canvasDark(), canvasLight(), grayscale(), mercator(), ordnanceSurvey(), road(), streetside();
    private static final String mPrefix = "Microsoft.Maps.MapTypeId.";

    public String getName() {
        return mPrefix + name();
    }
}
