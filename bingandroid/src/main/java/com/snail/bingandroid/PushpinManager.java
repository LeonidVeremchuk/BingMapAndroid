package com.snail.bingandroid;

import com.snail.bingandroid.serialization.entry.Pushpin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Leonid Veremchuk on 11/2/16.
 */

public class PushpinManager {
    private Map<String, Pushpin> mMarkerMap;

    PushpinManager() {
        mMarkerMap = new HashMap<>();
    }

    void addPushpin(Pushpin marker) {
        mMarkerMap.put(marker.getId(), marker);
    }

    void removeMarker(Pushpin marker) {
        for (String key : mMarkerMap.keySet()) {
            Pushpin current = mMarkerMap.get(key);
            if (current.getId().equals(marker.getId())) {
                mMarkerMap.remove(key);
                break;
            }
        }
        invalidateMarkers();
    }

    void removeMarker(String markerId) {
        mMarkerMap.remove(markerId);
        invalidateMarkers();
    }

    void clear() {
        mMarkerMap.clear();
        invalidateMarkers();
    }

    private void invalidateMarkers() {

    }
}
