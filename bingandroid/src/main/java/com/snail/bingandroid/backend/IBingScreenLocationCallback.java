package com.snail.bingandroid.backend;


import com.snail.bingandroid.backend.base.BaseCallback;
import com.snail.bingandroid.serialization.entry.Point;

/**
 * Created by Leonid Veremchuk on 11/10/16.
 */

public interface IBingScreenLocationCallback extends BaseCallback {
    void onPoint(Point point);
}
