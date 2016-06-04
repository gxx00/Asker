package com.example.gxx.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by gxx on 2016/6/3.
 */
public class SharedPUtils {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor se;
    public static final int VALUES_PUT=1;
    public static final int VALUES_GET=2;
    public SharedPUtils(Context context,String name,int mode){

            sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        if(mode==VALUES_PUT)
        se=sharedPreferences.edit();
    }
    public  String geStringtValue(String key)
    {
     return sharedPreferences.getString(key,"");
    }
    public int getIntValue(String key)
    {
        return sharedPreferences.getInt(key,0);
    }
    public boolean getBooleanValue(String key)
    {
        return sharedPreferences.getBoolean(key,true);
    }
    public long getLongVaule(String key)
    {
        return sharedPreferences.getLong(key,0l);
    }
    public float getFloatVaue(String key)
    {
        return sharedPreferences.getFloat(key,0.0f);
    }
    public void PutValue(String key,Object o)
    {
        if (o instanceof String)
        {
            se.putString(key, (String) o);
        }else if(o instanceof Integer)
        {
            se.putInt(key, (Integer) o);
        }else if(o instanceof  Long)
        {
            se.putLong(key, (Long) o);
        }else if(o instanceof  Float)
        {
            se.putFloat(key, (Float) o);
        }
        se.commit();
    }
    public void ChangeMode(int mode)
    {
        if(mode==VALUES_PUT)
            se=sharedPreferences.edit();
    }

}
