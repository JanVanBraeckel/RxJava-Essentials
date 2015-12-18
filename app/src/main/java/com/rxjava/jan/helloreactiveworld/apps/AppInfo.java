package com.rxjava.jan.helloreactiveworld.apps;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Jan on 18/12/2015.
 */
@Data
@Accessors(prefix = "m")
public class AppInfo implements Comparable<Object>{
    long mLastUpdateTime;
    String mName;
    String mIcon;

    public AppInfo(String name, String icon, long lastUpdateTime){
        mName = name;
        mIcon = icon;
        mLastUpdateTime = lastUpdateTime;
    }

    @Override
    public int compareTo(Object another) {
        AppInfo f = (AppInfo) another;
        return getName().compareTo(f.getName());
    }
}
