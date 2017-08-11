package cn.evun.sdlirtext;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

/**
 * Created by Shuai.Li13 on 2017/8/10.
 */

public class TopBackActivity extends BaseActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_back_activity);

        getWindow().setEnterTransition(new Slide().setDuration(500));
        getWindow().setExitTransition(new Slide().setDuration(500));
        initView();
        initSlidr();
    }

    private void initSlidr() {
        SlidrConfig config=new SlidrConfig.Builder()
                .position(SlidrPosition.TOP)//滑动起始方向
                .edge(true)
                .edgeSize(0.3f)//边界占屏幕大小30%
                .build();
        Slidr.attach(this,config);
    }

    private void initView() {

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout ctl= (CollapsingToolbarLayout) findViewById(R.id.ctl);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        toolbar.setTitleTextColor(getColor(R.color.white));
        ctl.setCollapsedTitleGravity(Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK);
        ctl.setExpandedTitleColor(Color.parseColor("#00ffffff"));
        ctl.setCollapsedTitleTextColor(getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
    }

    private class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(TopBackActivity.this).inflate(R.layout.item, parent, false);
            return new MyHolder(inflate);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            ((MyHolder) holder).tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
    }
    class MyHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
