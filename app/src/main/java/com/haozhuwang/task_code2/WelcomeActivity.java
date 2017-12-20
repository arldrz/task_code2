package com.haozhuwang.task_code2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               startMainActivity();
           }
       }, 2000);
    }

    private void startMainActivity() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
