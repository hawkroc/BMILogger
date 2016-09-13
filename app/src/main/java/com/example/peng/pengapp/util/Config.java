package com.example.peng.pengapp.util;

import android.content.Context;

/**
 * Created by peng on 13/09/16.
 */
class Config {

    private final static  String KEY_API="";
    private final static String Token="";

    public  static String  getKeyFromContext(Context context){
        return  context.getSharedPreferences(KEY_API,Context.MODE_PRIVATE).getString(Token,null);



    }





}
