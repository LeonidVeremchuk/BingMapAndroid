package com.snail.bingandroid.serialization.entry;


import com.snail.bingandroid.serialization.ISerializable;

/**
 * Created by Leonid Veremchuk on 11/7/16.
 */

public class Infobox extends BaseBingEntry implements ISerializable {

    public Infobox(Location location, InfoboxOptions infoboxOptions) {
        mValues.put(getEntryName(location), location);
        mValues.put(getEntryName(infoboxOptions), infoboxOptions);
    }

    public InfoboxOptions getInfoboxOptions() {
        return (InfoboxOptions) mValues.get(getEntryName(InfoboxOptions.class));
    }

    public Infobox setId(String id) {
        mValues.put("id", id);
        return this;
    }

    public Location getLocation() {
        return (Location) mValues.get(getEntryName(Location.class));
    }

    @Override
    public String toJsObject() {
        return toBaseString(mValues);
    }
}
