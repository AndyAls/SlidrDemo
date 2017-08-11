package cn.evun.sdlirtext;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.transition.Slide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai.Li13 on 2017/8/10.
 */

public class LeftBackActivity extends BaseLeftBackActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        initView();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_in_right);
    }

    private void initView() {

        getToolbar().setTitle("LeftBackActivity");
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public static void start(MainActivity mainActivity) {
        Intent intent=new Intent(mainActivity,LeftBackActivity.class);
        mainActivity.startActivity(intent);
        mainActivity.overridePendingTransition(R.anim.slide_in_left, 0);
    }



    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return MyFragment.newInstance(mDatas.get(position));
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mDatas.get(position);
        }
    }

}
