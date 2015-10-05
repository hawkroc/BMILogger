package com.example.peng.pengapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.peng.pengapp.AppGeneral;
import com.example.peng.pengapp.R;
import com.example.peng.pengapp.model.BMIModel;
import com.example.peng.pengapp.util.BMIUtil;
import com.example.peng.pengapp.util.RegexpUtil;
import com.example.peng.pengapp.util.database.DBDao;
import com.example.peng.pengapp.util.database.DBHelper;

import java.util.List;

public class SecondActivity extends Activity {
    private String email;
    private boolean isInter = true;
    private Button button_first;
    private Button button_sec;
    private RadioGroup radioGroup;
    private EditText height;
    private EditText weight;
    private Spinner standard;
    private DBHelper myDBHelper;
    private SQLiteDatabase db;
    // private Switch isSave;
    private DBDao dbDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.scale_in, R.anim.alpha);
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme);
        setContentView(R.layout.input_layout);
        email = getIntent().getStringExtra("email");


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        myDBHelper = new DBHelper(AppGeneral.getInstance().getContext());
        db = myDBHelper.getWritableDatabase();
        dbDao = DBDao.getDBDaoInstance(db);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rad = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                TextView h = (TextView) findViewById(R.id.height_uni);
                TextView w = (TextView) findViewById(R.id.weight_uni);
                if (rad.getText().equals(getResources().getString(R.string.british))) {

                    h.setText(R.string.inch);
                    w.setText(R.string.pound);
                    isInter = false;

                } else {
                    h.setText(R.string.cm);
                    w.setText(R.string.kg);
                    isInter = true;
                }


            }
        });


    }

    /**
     *
     */
    @Override
    public void finish() {
        super.finish();

        //  overridePendingTransition(R.anim.scale_in, R.anim.alpha);
    }

    /**
     * @param view
     */
    public void onClick_Cal(View view) {

        button_first = (Button) findViewById(R.id.button_first);
        //isSave =(Switch)findViewById(R.id.save);
//      //  isSave.setBackg(android.graphics.Color.RED);
//        isSave.setAnimation();
//        isSave.setTextColor(Color.WHITE);
        button_first.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                height = (EditText) findViewById(R.id.height);
                                                String sh = height.getText().toString();

                                                weight = (EditText) findViewById(R.id.weight);
                                                String sw = weight.getText().toString();

                                                if (sh == null || sw == null || sw.equals("") || sw.equals("") || !RegexpUtil.check(sh, getResources().getString(R.string.reg_int)) || !RegexpUtil.check(sw, getResources().getString(R.string.reg_int))) {

                                                    height.setError(getResources().getString(R.string.error_number));
                                                    weight.setError(getResources().getString(R.string.error_number));
                                                } else {

                                                    Double bmi = BMIUtil.getBMI(sh, sw, isInter);
                                                    standard = (Spinner) findViewById(R.id.standard);
                                                    String temp = standard.getSelectedItem().toString();
                                                    String advice = BMIUtil.getAdviceDifferentStandard(bmi, temp);

                                                    BMIModel b = new BMIModel();
                                                    b.setBmi(String.valueOf(bmi));
                                                    b.setEmail(email);
                                                    dbDao.createBMI(b);


                                                    // Log.e("", "" + l.size() + "))))))" + l.get(0));
                                                    TextView textView = (TextView) findViewById(R.id.result);
                                                    TextView textAdvice = (TextView) findViewById(R.id.advice);
                                                    if (bmi > 25 || bmi < 18.5) {
                                                        textAdvice.setTextColor(Color.RED);
                                                        textView.setTextColor(Color.RED);
                                                    } else {
                                                        textAdvice.setTextColor(Color.GREEN);
                                                        textView.setTextColor(Color.GREEN);
                                                    }
                                                    textView.setText(" your bmi is:  " + bmi);
                                                    textAdvice.setText(advice);


                                                }

                                            }
                                        }
        );

    }

    /**
     * @param view
     */
    public void onClick_history(View view) {


        Intent intent = new Intent(SecondActivity.this, RecordActivity.class);
        intent.putExtra("email", email);

        startActivity(intent);

        button_sec = (Button) findViewById(R.id.button_sec);
        button_sec.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                List<BMIModel> l = dbDao.queryBMI(email);

                for (BMIModel b : l) {
                    //  TextView te = new TextView(getBaseContext());
                    //   te.setTextSize(16);
                    Log.e("&&&&", "%%%%%%)))))" + l.size());
                    //   te.setText("" + b.getId() + b.getBmi() + b.getTime());

                }
            }


        });

    }
}
