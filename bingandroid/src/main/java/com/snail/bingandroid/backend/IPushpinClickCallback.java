package com.snail.bingandroid.backend;


import com.snail.bingandroid.backend.base.BaseCallback;
import com.snail.bingandroid.serialization.entry.Infobox;
import com.snail.bingandroid.serialization.entry.Pushpin;

/**
 * Created by Leonid Veremchuk on 11/7/16.
 */

public interface IPushpinClickCallback extends BaseCallback {
    Infobox onPushPinClick(Pushpin pushpin);
}
