package com.example.peng.pengapp.util.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.peng.pengapp.model.BMIModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peng on 15/10/4.
 */
public class DBDao {
    private static DBDao dbDao = null;
    private SQLiteDatabase db;

    /**
     * @param db
     */
    private DBDao(SQLiteDatabase db) {
        this.db = db;
    }

    /**
     * @param db
     * @return
     */
    public static DBDao getDBDaoInstance(SQLiteDatabase db) {
        if (dbDao == null) {
            dbDao = new DBDao(db);
        }
        return dbDao;
    }

    /**
     * @param bmiModel
     */
    public void createBMI(BMIModel bmiModel) {

        db.execSQL("INSERT INTO BMI(email,bmi) values(?,?)",
                new String[]{bmiModel.getEmail(), bmiModel.getBmi()});

    }

    /**
     * @param email
     * @return
     */
    public List<BMIModel> queryBMI(String email) {
        List<BMIModel> l = new ArrayList<>();


        Cursor cursor = this.queryBMICursor(email);

        if (cursor.moveToFirst()) {
            do {
                int bmi_id = cursor.getInt(cursor.getColumnIndex("BMI_id"));
                String bmi = cursor.getString(cursor.getColumnIndex("bmi"));
                String time = cursor.getString(cursor.getColumnIndex("bmi_Time"));
                l.add(new BMIModel(bmi_id, bmi, time));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return l;


    }


    /**
     *
     * @param email
     * @return
     */
    public Cursor queryBMICursor(String email) {


        Cursor cursor = db.rawQuery("SELECT * FROM BMI WHERE email = ?  order by bmi_Time",
                new String[]{email});


        return cursor;


    }

    /**
     *
     * @param email
     * @return
     */
    public List<Map<String, Object>>  queryBMIList(String email){
        List list= new ArrayList();
        Cursor cursor= this.queryBMICursor(email);
        if (cursor.moveToFirst()) {
            do {
                Map m= new HashMap();
//                int bmi_id = cursor.getInt(cursor.getColumnIndex("BMI_id"));
//                m.put("BMI_ID",bmi_id);
                String bmi = cursor.getString(cursor.getColumnIndex("bmi"));
                m.put("bmi",bmi);
                String time = cursor.getString(cursor.getColumnIndex("bmi_Time"));
                m.put("bmi_Time",time);
                list.add(m);
            }
            while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }
}
