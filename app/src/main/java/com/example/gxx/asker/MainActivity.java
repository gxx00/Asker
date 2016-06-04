package com.example.gxx.asker;

import android.content.Intent;
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
        SharedPUtils sp=new SharedPUtils(this,"asker",SharedPUtils.VALUES_GET);
        if(sp.getBooleanValue("isStart"))
        {
            startActivity(new Intent(this,SplashActivity.class));
            sp.ChangeMode(SharedPUtils.VALUES_PUT);
            sp.PutValue("isStart",false);
            this.finish();
        }
    }
}
