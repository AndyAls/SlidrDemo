package cn.evun.sdlirtext;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai.Li13 on 2017/8/10.
 */

public class BaseActivity extends AppCompatActivity {

    protected List<String> mDatas=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 12; i++) {
            mDatas.add("Tab"+i);
        }
    }
}
