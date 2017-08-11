package cn.evun.sdlirtext;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt1:
                LeftBackActivity.start(this);
                break;
            case R.id.bt2:
                Intent intent = new Intent(this,TopBackActivity.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                ActivityCompat.startActivity(this,intent,bundle);
                break;
            case R.id.bt3:
                intent=new Intent(this,SlidrActivity.class);
                startActivity(intent);
                break;
        }
    }
}
