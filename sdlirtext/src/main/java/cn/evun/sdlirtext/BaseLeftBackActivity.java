package cn.evun.sdlirtext;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

/**
 * Created by Shuai.Li13 on 2017/8/10.
 */

public class BaseLeftBackActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSlidr();
    }

    private void initSlidr() {
        SlidrConfig config=new SlidrConfig.Builder()
                .position(SlidrPosition.LEFT)//滑动起始方向
                .edge(true)
                .edgeSize(0.18f)//距离左边界占屏幕大小的18%
                .build();
        Slidr.attach(this,config);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

        View contentView= LayoutInflater.from(this).inflate(R.layout.base_left_back_activity,null);
        FrameLayout flContainer= (FrameLayout) contentView.findViewById(R.id.flContainer);
        Toolbar toolbar= (Toolbar) contentView.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View view=LayoutInflater.from(this).inflate(layoutResID,flContainer,false);
        flContainer.addView(view);
        super.setContentView(contentView);
    }
    protected ActionBar getToolbar(){
        return getSupportActionBar();
    }
}
