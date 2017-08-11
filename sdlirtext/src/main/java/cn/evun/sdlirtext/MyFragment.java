package cn.evun.sdlirtext;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Shuai.Li13 on 2017/8/9.
 */

public class MyFragment extends Fragment{

    private static final String TAB_KEY = "TAB_KEY";
    private Bundle getBundle;
    private Context mContext;

    public static MyFragment newInstance(String type){

        MyFragment fragment=new MyFragment();
        Bundle bundle=new Bundle();
        bundle.putCharSequence(TAB_KEY,type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments!=null){
            this.getBundle=arguments;
        }
        mContext=getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment, container, false);
        TextView tv= (TextView) view.findViewById(R.id.tv);
        ArgbEvaluator evaluator = new ArgbEvaluator();
        Random random = new Random();
        float v = random.nextFloat();
        int evaluate = (int) evaluator.evaluate(v, Color.parseColor("#FF3366"), Color.GREEN);
       tv.setBackgroundColor(evaluate);
        tv.setText(getBundle.getCharSequence(TAB_KEY));
        tv.setTextColor(getResources().getColor(R.color.white));
        return view;
    }
}
