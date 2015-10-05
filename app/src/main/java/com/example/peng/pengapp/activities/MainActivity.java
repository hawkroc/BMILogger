package com.example.peng.pengapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.peng.pengapp.R;
import com.example.peng.pengapp.util.RegexpUtil;
import com.example.peng.pengapp.util.ToastUtils;


public class MainActivity extends Activity {
    private final String Tag = "MainActivity";
    EditText login_email;
    Button button_login, button_rest;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(Tag, "this is MainActivity");
        //add or remove the windows title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme);
        setContentView(R.layout.first_layout);


    }

    @Override
    protected void onResume() {
        Log.i(Tag, "first activity--------onResume()");
        // System.out.println("first activity--------onResume()");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.i(Tag, "first activity--------onStart()");
        // System.out.println("first activity--------onStart()");
        super.onStart();
        this.addAnimation();
    }

    @Override
    protected void onStop() {
        Log.i(Tag, "first activity--------onStop()");
        //System.out.println("first activity--------onStop()");
        super.onStop();
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        Log.i(Tag, "first activity--------onCreate()");
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            showToastText("yes you add something");
            return true;
        }

        if (id == R.id.action_remove) {
            showToastText("you remove something");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * @param toastText
     */
    private void showToastText(String toastText) {

        Toast toast = Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT);

        toast.setGravity(Gravity.CENTER, -50, 100);

        toast.show();

    }

    /**
     *
     */
    private void addAnimation() {
        Animation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(2000);
        TableRow t = (TableRow) findViewById(R.id.email);
        t.startAnimation(alphaAnimation);
    }


    /**
     * @param v
     */
    public void onClick_Login(View v) {
        Log.e("****","4324324%%%%%23411@@");
        button_login = (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                login_email = (EditText) findViewById(R.id.login_email);
                                                email = login_email.getText().toString();
                                                if (!RegexpUtil.check(email, getResources().getString(R.string.reg_email))) {

                                                    login_email.setError(getResources().getString(R.string.error_login));
                                                } else {

                                                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                                    intent.putExtra("email",email);

                                                    startActivity(intent);

                                                    ToastUtils.showShort(getApplicationContext(), email + getResources().getString(R.string.toast_message_welcome));
                                                }

                                            }
                                        }
        );

    }

    /**
     * @param v
     */
    public void onClick_Reset(View v) {
        button_rest = (Button) findViewById(R.id.button_rest);
        button_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_email = (EditText) findViewById(R.id.login_email);
                login_email.setText(null);
                // finish();
            }
        });
    }
}
