package com.example.peng.pengapp.util;

import android.content.Context;

/**
 * Created by PengYin on 14-5-9.
 */
public class DensityUtils {
    /**
     *
     * from db to px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     *
     * from px to dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
