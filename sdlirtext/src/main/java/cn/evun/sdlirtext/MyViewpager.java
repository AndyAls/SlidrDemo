package cn.evun.sdlirtext;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Shuai.Li13 on 2017/8/10.
 */

public class MyViewpager extends ViewPager {
    public MyViewpager(Context context) {
        super(context);
    }

    public MyViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


//        int height = 0;
//        for (int i = 0; i < getChildCount(); i++) {
//            View child = getChildAt(i);
//            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//            int h = child.getMeasuredHeight();
//            if (h > height) height = h;
//        }
//        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 1,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
