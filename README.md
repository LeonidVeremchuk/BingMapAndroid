# Bing Map Android V8
 Porting Bing Maps v8 to android using standart [API](http://www.bing.com/api/maps/sdk/mapcontrol/isdk#loadMapAsync+JS) 

###How to use:
## XML:
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <com.snail.bingandroid.MapView
        android:id="@+id/map_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
</LinearLayout>
```
## Activity/Fragment BingMap setup:

```
public class SampleActivity extends AppCompatActivity implements OnMapReadyCallback {
    private BingMap mBingMap;
    private MapView mMapView;
    
        private void initMap() {
        mMapView = (MapView) findViewById(R.id.map_view);
        mMapView.getMapAsync("Your Bing API Key", this);
    }

    @Override
    public void onMapReady(BingMap bingMap) {
        mBingMap = bingMap;
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMap();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }
    
```
###License
```
Copyright 2016 SnailPro, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
