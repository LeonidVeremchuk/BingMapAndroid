package com.snail.bingandroid;

/**
 * Created by Leonid Veremchuk on 11/11/16.
 */

public class UiSettings {
    private boolean mTouchEnable = true;

    public boolean isTouchEnable() {
        return mTouchEnable;
    }

    public void setScrollGesturesEnabled(boolean scrollGesturesEnabled) {
        this.mTouchEnable = scrollGesturesEnabled;
    }
}
