package com.snail.bingandroid.serialization.entry;


import com.snail.bingandroid.serialization.ISerializable;
import com.snail.bingandroid.serialization.SerializationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonid Veremchuk on 11/7/16.
 */

public class InfoboxOptions extends BaseBingEntry implements ISerializable {
    private List<ISerializable> mInfoboxActionsList;

    public InfoboxOptions() {
        mInfoboxActionsList = new ArrayList<>();
    }

    public InfoboxOptions setTitle(String title) {
        mValues.put("title", title);
        return this;
    }

    public InfoboxOptions setDescription(String description) {
        mValues.put("description", description);
        return this;
    }

    public InfoboxOptions addInfoboxAction(InfoboxActions actions) {
        mInfoboxActionsList.add(actions);
        return this;
    }

    public String getTitle() {
        return (String) mValues.get("title");
    }

    @Override
    public String toJsObject() {
        if (mInfoboxActionsList.size() > 0) {
            mValues.put("actions", new SerializationManager<>().serializeToStringArray(mInfoboxActionsList));
        }
        return toBaseString(mValues);
    }
}
