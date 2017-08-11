package cn.evun.sdlirtext;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai.Li13 on 2017/8/11.
 */

public class SlidrActivity extends BaseActivity{

    List<ImageView> mList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slidr_activity);

        initSlidr();
        initList();
        initView();
    }

    private void initList() {
        for (int i = 0; i < mDatas.size(); i++) {
            ImageView imageView = new ImageView(SlidrActivity.this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(getDrawable(R.drawable.andy));
            mList.add(imageView);
        }
    }

    private void initView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final LinearLayout ll= (LinearLayout) findViewById(R.id.ll);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Integer.MAX_VALUE/2;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

              container.addView(mList.get(position%mList.size()));
                return mList.get(position%mList.size());
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mList.get(position%mDatas.size()));
            }
        });

        viewPager.setCurrentItem(Integer.MAX_VALUE/2-(Integer.MAX_VALUE/2)%mDatas.size());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                ArgbEvaluator evaluator = new ArgbEvaluator();
                int evaluate = (int) evaluator.evaluate(positionOffset, getResources().getColor(R.color.green), getResources().getColor(R.color.yellow));
                ll.setBackgroundColor(evaluate);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initSlidr() {

        SlidrConfig config = new SlidrConfig.Builder()
                .position(SlidrPosition.VERTICAL)
                .secondaryColor(getColor(R.color.yellow))
                .scrimColor(getColor(R.color.green))
                .scrimColor(getColor(R.color.colorAccent))
                .build();
        Slidr.attach(this,config);
    }
}
