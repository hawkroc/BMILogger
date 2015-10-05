package com.example.peng.pengapp.util;

import com.example.peng.pengapp.AppGeneral;

import java.math.BigDecimal;

/**
 * Created by peng on 15/10/3.
 */
public class BMIUtil {

    private static String thin = AppGeneral.getInstance().getThin();
    private static String normal = AppGeneral.getInstance().getNormal();
    ;
    private static String fat = AppGeneral.getInstance().getFat();
    private static String fatter = AppGeneral.getInstance().getFatter();

    private static String muchFatter = AppGeneral.getInstance().getMuchFatter();
    private static String fattest = AppGeneral.getInstance().getFattest();
    private static String error = AppGeneral.getInstance().getError();


    /**
     * @param sh
     * @param sw
     * @return
     */
    public static double getBMI(String sh, String sw, boolean isInter) {
        Double h = Double.parseDouble(sh) / 100;

        Double w = Double.parseDouble(sw);
        if (!isInter) {
            h = h * 100 * 2.54;
            w = w * 0.4536;
        }


        Double bmi = new BigDecimal(w / (h * h)).setScale(2, 4).doubleValue();
        return bmi;
    }


    /**
     * @param bmi
     * @param st
     * @return
     */
    public static String getAdviceDifferentStandard(Double bmi, String st) {
        String ad = "";

        if (bmi < 18.5) {
            ad = thin;
            return ad;
        }
        if (bmi > 40) {
            ad = fattest;
            return ad;
        }
        if (bmi > 80) {
            ad = error;
        }


        switch (st) {
            case ("Asia"):
                if (bmi <= 22.9) {
                    ad = normal;
                } else if (22.9 < bmi && bmi <= 24.9) {
                    ad = fat;
                } else if (24.9 < bmi && bmi < 29.9) {
                    ad = fatter;
                } else {
                    ad = muchFatter;
                }
                break;
            case ("China"):
                if (bmi <= 23.9) {
                    ad = normal;
                } else if (23.9 < bmi && bmi <= 27.9) {
                    ad = fat;
                } else if (27.9 < bmi && bmi < 29.9) {
                    ad = fatter;
                } else {
                    ad = muchFatter;
                }
                break;
            case ("WHO"):
                if (bmi <= 25) {
                    ad = normal;
                } else if (25 < bmi && bmi <= 29.9) {
                    ad = fat;
                } else if (30 < bmi && bmi < 34.9) {
                    ad = fatter;
                } else {
                    ad = muchFatter;
                }


        }
        return ad;
    }

}
