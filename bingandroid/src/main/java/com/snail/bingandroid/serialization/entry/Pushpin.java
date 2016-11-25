package com.snail.bingandroid.serialization.entry;

import com.snail.bingandroid.serialization.ISerializable;

/**
 * Created by Leonid Veremchuk on 11/3/16.
 */

public class Pushpin extends BaseBingEntry implements ISerializable {

    public Pushpin setPushpinOptions(PushpinOptions pushpinOptions) {
        mValues.put(getEntryName(pushpinOptions), pushpinOptions);
        return this;
    }

    public Pushpin setLocation(Location location) {
        mValues.put(getEntryName(location), location);
        return this;
    }

    public Pushpin setInfobox(Infobox infobox) {
        mValues.put(getEntryName(infobox), infobox);
        return this;
    }

    public Pushpin setId(String id) {
        mValues.put("id", id);
        return this;
    }

    public Pushpin getPushpinsOptions() {
        return (Pushpin) mValues.get(getEntryName(Pushpin.class));
    }

    public Location getLocation() {
        return (Location) mValues.get(getEntryName(Location.class));
    }

    public Infobox getInfobox() {
        return (Infobox) mValues.get(getEntryName(Infobox.class));
    }

    @Override
    public String toJsObject() {
        return toBaseString(mValues);
    }

    public String getId() {
        return String.valueOf(mValues.get("id"));
    }
}
