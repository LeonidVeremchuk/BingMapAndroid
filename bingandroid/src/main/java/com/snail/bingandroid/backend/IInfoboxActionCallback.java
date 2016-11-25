package com.snail.bingandroid.backend;

import com.snail.bingandroid.backend.base.BaseCallback;

/**
 * Created by Leonid Veremchuk on 11/9/16.
 */

public interface IInfoboxActionCallback extends BaseCallback {
    void onLabelClick(String labelId);
}
