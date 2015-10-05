package com.example.peng.pengapp.util;


import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by peng on 15/10/1.
 */
public class RegexpUtil {
    static boolean flag = false;
    static String regex = "";
    public static boolean check(String str, String regex) {
        boolean flag= false;
        if(str==null&&str.equals("")){
            return  flag;
        }

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str.trim());
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * not null
     *
     * @param email
     * @return
     */
    public static boolean checkNotEmputy(String notEmputy) {
        regex = "^\\s*$";
        return check(notEmputy, regex) ? false : true;
    }


}