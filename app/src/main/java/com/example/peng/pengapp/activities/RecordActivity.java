package com.example.peng.pengapp.activities;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.peng.pengapp.AppGeneral;
import com.example.peng.pengapp.R;
import com.example.peng.pengapp.util.database.DBDao;
import com.example.peng.pengapp.util.database.DBHelper;

import java.util.List;
import java.util.Map;

public class RecordActivity extends Activity {
    private DBHelper myDBHelper;
    private SQLiteDatabase db;
    private DBDao dbDao;
    private String email;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme);
        setContentView(R.layout.record);
        lv = (ListView) findViewById(R.id.list);
        myDBHelper = new DBHelper(AppGeneral.getInstance().getContext());
        db = myDBHelper.getWritableDatabase();
        dbDao = DBDao.getDBDaoInstance(db);
        email = getIntent().getStringExtra("email");

        List<Map<String, Object>> listItem = dbDao.queryBMIList(email);
        SimpleAdapter adapter = new SimpleAdapter(this, listItem, R.layout.item,
                new String[]{"bmi", "bmi_Time"},
                new int[]{R.id.bmi, R.id.time});
        lv.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
