package com.example.gxx.asker;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gxx.fragment.fragment_Splash_vp;
import com.example.gxx.view.PointView;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,fragment_Splash_vp.OnFragmentInteractionListener{

    private ViewPager splash_vp;
    private LinearLayout splash_ll;
    private List<Fragment> fragments;
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        initFragments();
        doViews();
    }

    private void doViews() {
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        splash_vp.setAdapter(adapter);
        splash_vp.setOnPageChangeListener(this);
        for (int i=0;i<splash_ll.getChildCount();i++)
        {
            PointView pv= (PointView) splash_ll.getChildAt(i);
            if(i>0)
            {
                pv.setColor(Color.YELLOW);
            }
        }
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            fragments.add(fragment_Splash_vp.newInstance(i + ""));
        }
    }

    private void initView() {
        splash_vp = (ViewPager) findViewById(R.id.splash_vp);
        splash_ll = (LinearLayout) findViewById(R.id.splash_ll);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
      for (int i=0;i<splash_ll.getChildCount();i++)
      {

          PointView pv= (PointView) splash_ll.getChildAt(i);
          if(position==i)
          {
              pv.changeColor(Color.RED);
          }else{
              pv.changeColor(Color.YELLOW);
          }

      }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
