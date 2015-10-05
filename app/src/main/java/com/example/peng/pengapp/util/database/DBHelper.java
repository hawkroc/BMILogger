package com.example.peng.pengapp.util.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.peng.pengapp.AppGeneral;

/**
 * Created by storm on 14-4-8.
 */
public class DBHelper extends SQLiteOpenHelper {
    // DB name
    private static final String DB_NAME = AppGeneral.getInstance().getDBname();

    // DB version
    private static final int VERSION = 1;
    //Create db sql
    private String sql="CREATE  TABLE IF NOT EXISTS BMI " +
            "(BMI_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "email VARCHAR(32)," +
            "bmi VARCHAR(5)," +
            "bmi_Time TIMESTAMP default (datetime('now', 'localtime')))";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
