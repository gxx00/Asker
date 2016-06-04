package com.example.gxx.asker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gxx.util.SharedPUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        DecFirstStart();

    }

    private void DecFirstStart() {
        SharedPUtils sp=new SharedPUtils(getApplicationContext(),"asker",SharedPUtils.VALUES_GET);
        if(sp.getBooleanValue("isStart"))
        {
            SharedPreferences sharedPreferences=getSharedPreferences("asker", Context.MODE_PRIVATE);
            sharedPreferences.edit().putBoolean("isStart",false).commit();
            startActivity(new Intent(this,SplashActivity.class));
            this.finish();
        }
    }
}
