package com.example.gxx.asker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gxx.fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private long first_back_time = 0l;
    private LinearLayout home_tab_home;
    private LinearLayout home_tab_ask;
    private LinearLayout home_tab_circle;
    private LinearLayout home_tab_me;
    private FrameLayout home_fragment;
    private LinearLayout lls[] = new LinearLayout[4];
    private HomeFragment homefragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragments();
        doViews();
        ChangeFragments(0);

    }

    private void initFragments() {
        homefragment = new HomeFragment();

    }

    private void ChangeFragments(int i) {
        switch (i) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment, homefragment).commit();
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private void doViews() {
        ImageView iv = (ImageView) home_tab_home.getChildAt(0);
        iv.setSelected(true);

        home_tab_home.setOnClickListener(this);
        home_tab_ask.setOnClickListener(this);
        home_tab_circle.setOnClickListener(this);
        home_tab_me.setOnClickListener(this);
        lls[0] = home_tab_home;
        lls[1] = home_tab_ask;
        lls[2] = home_tab_circle;
        lls[3] = home_tab_me;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (first_back_time == 0) {
                first_back_time = System.currentTimeMillis();
                Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
            } else {
                if (System.currentTimeMillis() - first_back_time <= 2000) {
                    this.finish();
                } else {
                    first_back_time = System.currentTimeMillis();
                    Toast.makeText(this, "再次点击退出", Toast.LENGTH_SHORT).show();
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initView() {
        home_tab_home = (LinearLayout) findViewById(R.id.home_tab_home);
        home_tab_ask = (LinearLayout) findViewById(R.id.home_tab_ask);
        home_tab_circle = (LinearLayout) findViewById(R.id.home_tab_circle);
        home_tab_me = (LinearLayout) findViewById(R.id.home_tab_me);
        home_fragment = (FrameLayout) findViewById(R.id.home_fragment);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_tab_home:
                ChangeTabSelect(0);
                break;
            case R.id.home_tab_ask:
                ChangeTabSelect(1);
                break;
            case R.id.home_tab_circle:
                ChangeTabSelect(2);
                break;
            case R.id.home_tab_me:
                ChangeTabSelect(3);
                break;


        }
    }

    private void ChangeTabSelect(int i) {
        for (int j = 0; j < lls.length; j++) {
            if (j == i) {
                lls[j].getChildAt(0).setSelected(true);
            } else {
                lls[j].getChildAt(0).setSelected(false);
            }
        }
    }
}
