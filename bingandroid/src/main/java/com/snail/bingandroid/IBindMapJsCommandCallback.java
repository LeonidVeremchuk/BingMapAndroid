package com.snail.bingandroid;

import java.util.List;

/**
 * Created by Leonid Veremchuk on 11/4/16.
 */

interface IBindMapJsCommandCallback {
    void loadFunction(String jsFunctionString);

    void setInterfaceList(List<Object> jsObjectInterface, String assetPatch);
}
