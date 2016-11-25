package com.snail.bingandroid.serialization.entry;


import com.snail.bingandroid.serialization.ISerializable;

import org.json.JSONException;
import org.json.JSONObject;

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

    public Location(String jsLocation) {
        try {
            JSONObject jsObject = new JSONObject(jsLocation);
            if(jsObject.has("latitude")){
                mValues.put("latitude",jsObject.getDouble("latitude"));
            }

            if(jsObject.has("longitude")){
                mValues.put("longitude",jsObject.getDouble("longitude"));
            }

            if(jsObject.has("altitude")){
                mValues.put("altitude",jsObject.getDouble("altitude"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public double getLatitude() {
        if (mValues.get("latitude") != null) {
            return (double) mValues.get("latitude");
        }
        return 0;
    }

    public double getLongitude() {
        if (mValues.get("longitude") != null) {
            return (double) mValues.get("longitude");
        }
        return 0;
    }

    public double getAltitude() {
        if (mValues.get("altitude") != null) {
            return (double) mValues.get("altitude");
        }
        return 0;
    }

    public String toString() {
        return "lat/lng: (" + this.getLatitude() + "," + this.getLongitude() + ")  alt: " + "(" + this.getAltitude() + ")";
    }

    @Override
    public String toJsObject() {
        return toBaseString(mValues);
    }
}
