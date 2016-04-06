package com.meunicorn.fancy2u.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Fancy on 2016/3/30.
 */
public class SpUtil {
    public static final String SP_NAME = "dribbble_data";
    private SharedPreferences sp;
    private static SpUtil instance;

    private SpUtil(Context context) {
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public static SpUtil make(Context context) {
        if (instance == null) {
            synchronized (SpUtil.class) {
                if (instance == null) {
                    instance = new SpUtil(context);
                }
            }
        }
        return instance;
    }

    public void setIntData(String key, int value) {
        sp.edit().putInt(key, value).commit();
    }

    public int getIntData(String key, int dValue) {
        return sp.getInt(key, dValue);
    }

    public void setLongData(String key, long value) {
        sp.edit().putLong(key, value).commit();
    }

    public long getLongData(String key, Long dValue) {
        return sp.getLong(key, dValue);
    }

    public void setFloatData(String key, float value) {
        sp.edit().putFloat(key, value).commit();
    }

    public Float getFloatData(String key, Float dValue) {
        return sp.getFloat(key, dValue);
    }

    public void setBooleanData(String key, boolean value) {
        sp.edit().putBoolean(key, value).commit();
    }

    public Boolean getBooleanData(String key, boolean dValue) {
        return sp.getBoolean(key, dValue);
    }

    public void setStringData(String key, String value) {
        sp.edit().putString(key, value).commit();
    }

    public String getStringData(String key, String dValue) {
        return sp.getString(key, dValue);
    }
}
