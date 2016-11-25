package com.snail.bingandroid.util;

import com.snail.bingandroid.serialization.entry.Color;
import com.snail.bingandroid.serialization.entry.Infobox;
import com.snail.bingandroid.serialization.entry.InfoboxActions;
import com.snail.bingandroid.serialization.entry.InfoboxOptions;
import com.snail.bingandroid.serialization.entry.Location;
import com.snail.bingandroid.serialization.entry.Pushpin;
import com.snail.bingandroid.serialization.entry.PushpinOptions;

/**
 * Created by Leonid Veremchuk on 11/7/16.
 */

public class PushpinCreator {
    private Pushpin mPushpin;

    public PushpinCreator(String id) {
        mPushpin = new Pushpin();
        mPushpin.setId(id);
    }

    public PushpinCreator setLocation(double latitude, double longitude) {
        if (mPushpin.getLocation() == null) {
            mPushpin.setLocation(new Location(latitude, longitude));
        }
        return this;
    }

    public PushpinCreator setInfobox(String title, String description) {
        if (mPushpin.getLocation() == null) {
            throw new NullPointerException("Please set current Pushpin location before set Infobox data");
        }
        InfoboxOptions infoboxOptions = new InfoboxOptions();
        infoboxOptions.setTitle(title);
        infoboxOptions.setDescription(description);

        Infobox infobox = new Infobox(mPushpin.getLocation(), infoboxOptions);
        mPushpin.setInfobox(infobox);
        return this;
    }

    public PushpinCreator setInfoboxActions(String id, String labelName) {
        if (mPushpin.getInfobox() == null) {
            throw new NullPointerException("Please set current InfoboxOptions before set InfoboxActions");
        }

        InfoboxActions infoboxActions = new InfoboxActions(labelName, id);
        mPushpin.getInfobox().getInfoboxOptions().addInfoboxAction(infoboxActions);
        return this;
    }

    public PushpinCreator setPushingColor(int red, int green, int blue) {
        PushpinOptions pushpinOptions = new PushpinOptions();
        Color color = new Color();
        color.setColor(red, green, blue);
        pushpinOptions.setColor(color);
        mPushpin.setPushpinOptions(pushpinOptions);
        return this;
    }

    public PushpinCreator setPushingColor(Color.Colors colors) {
        PushpinOptions pushpinOptions = new PushpinOptions();
        Color color = new Color();
        color.setColor(colors);
        pushpinOptions.setColor(color);
        mPushpin.setPushpinOptions(pushpinOptions);
        return this;
    }


    public PushpinCreator setPushingColor(String color) {
        PushpinOptions pushpinOptions = new PushpinOptions();
        pushpinOptions.setColor(color);
        mPushpin.setPushpinOptions(pushpinOptions);
        return this;
    }

    public Pushpin create() {
        return mPushpin;
    }
}
