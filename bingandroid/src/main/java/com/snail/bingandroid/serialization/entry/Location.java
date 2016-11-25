package com.snail.bingandroid.serialization.entry;


import com.snail.bingandroid.serialization.ISerializable;

/**
 * Created by Leonid Veremchuk on 11/2/16.
 */

public class Location extends BaseBingEntry implements ISerializable {

    public Location(double latitude, double longitude) {
        double lon;
        double lat;
        if (-180.0D <= longitude && longitude < 180.0D) {
            lon = longitude;
        } else {
            lon = ((longitude - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D;
        }

        lat = Math.max(-90.0D, Math.min(90.0D, latitude));

        mValues.put("latitude", lat);
        mValues.put("longitude", lon);
    }

    public double getLatitude() {
        return (double) mValues.get("latitude");
    }

    public double getLongitude() {
        return (double) mValues.get("longitude");
    }


    public String toString() {
        return "lat/lng: (" + this.getLatitude() + "," + this.getLongitude() + ")";
    }

    @Override
    public String toJsObject() {
        return toBaseString(mValues);
    }
}
