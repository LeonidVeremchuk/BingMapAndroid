package com.snail.bingandroid.backend;


import com.snail.bingandroid.backend.base.BaseCallback;
import com.snail.bingandroid.serialization.entry.Location;

/**
 * Created by Leonid Veremchuk on 11/3/16.
 */

public interface IBindMapClickCallback extends BaseCallback {
    void onMapClick(Location location);
}
