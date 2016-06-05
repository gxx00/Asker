package com.example.gxx.asker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.gxx.util.SharedPUtils;

public class SplashActivity1 extends AppCompatActivity implements Animation.AnimationListener{

    private ImageView splash1_iv;
    private Animation aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);
        DecFirstStart();
        initView();
        initAnimation();
        doViews();
    }

    private void initAnimation() {
        aa=new AlphaAnimation(0.5f,1.0f);
        aa.setDuration(2000);
        aa.setInterpolator(new AccelerateDecelerateInterpolator());
        aa.setAnimationListener(this);
    }

    private void doViews() {
        splash1_iv.setAnimation(aa);
    }

    private void DecFirstStart() {
        SharedPUtils sp = new SharedPUtils(getApplicationContext(), "asker", SharedPUtils.VALUES_GET);
        if (sp.getBooleanValue("isStart")) {
            SharedPreferences sharedPreferences = getSharedPreferences("asker", Context.MODE_PRIVATE);
            sharedPreferences.edit().putBoolean("isStart", false).commit();
            startActivity(new Intent(this, SplashActivity.class));
            this.finish();
        }
    }

    private void initView() {
        splash1_iv = (ImageView) findViewById(R.id.splash1_iv);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
       startActivity(new Intent(this,HomeActivity.class));
        this.finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
