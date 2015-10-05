package com.example.peng.pengapp;

import android.app.Application;
import android.content.Context;


/**
 * Created by PengYin on 14-3-24.
 */
public class AppGeneral extends Application {
    private static Context sContext;


    private static String thin = null;
    private static String normal = null;
    private static String fat = null;
    private static String fatter = null;

    public static String getThin() {
        return thin;
    }

    public static String getNormal() {
        return normal;
    }

    public static String getFat() {
        return fat;
    }

    public static String getFatter() {
        return fatter;
    }

    public static String getMuchFatter() {
        return muchFatter;
    }

    public static String getFattest() {
        return fattest;
    }

    public static String getError() {
        return error;
    }

    private static String muchFatter = null;
    private static String fattest = null;
    private static String error = null;



    private static String DBname="BMI.db";
    private static AppGeneral app;

    public static Context getsContext() {
        return sContext;
    }

    public static void setsContext(Context sContext) {
        AppGeneral.sContext = sContext;
    }

    public static String getDBname() {
        return DBname;
    }

    /**
     *
     */
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        thin = getResources().getString(R.string.thin);
        normal = getResources().getString(R.string.hot);
        fat = getResources().getString(R.string.fat);
        fatter = getResources().getString(R.string.fatter);
        muchFatter = getResources().getString(R.string.much_fatter);
        fattest = getResources().getString(R.string.fattest);
        error = getResources().getString(R.string.error);
        sContext = getApplicationContext();

    }

    /**
     * @return
     */
    public static AppGeneral getInstance() {
        return app;
    }

    public Context getContext() {
        if (sContext == null) {
            sContext = getApplicationContext();
        }


        return sContext;
    }



}
