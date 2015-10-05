package com.example.peng.pengapp.util;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by PengYin on 14-4-19.
 */
public class ToastUtils {
    private ToastUtils() {
    }

    private static void show(Context context, int resId, int duration) {
        Toast.makeText(context, resId, duration).show();
    }

    private static void show(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    public static void showShort(Context context,String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
//    public static void showShort(Context context,int resId) {
//        Toast.makeText(AppGeneral.getContext(), resId, Toast.LENGTH_SHORT).show();
//    }
//
//
//    public static void showLong(int resId) {
//        Toast.makeText(AppGeneral.getContext(), resId, Toast.LENGTH_LONG).show();
//    }
//
//    public static void showLong(String message) {
//        Toast.makeText(AppGeneral.getContext(), message, Toast.LENGTH_LONG).show();
//    }



}
