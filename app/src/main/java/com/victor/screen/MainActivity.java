package com.victor.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.victor.screen.app.App;

public class MainActivity extends AppCompatActivity {

    private TextView mTvMatchData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize () {
        mTvMatchData = (TextView) findViewById(R.id.tv_match_data);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int smallestWidth = Math.min(dm.widthPixels,dm.heightPixels);

        StringBuffer sb = new StringBuffer();
        sb.append("当前手机： "+ DeviceUtils.getDeviceBrand()+"--->"+DeviceUtils.getPhoneModel()+ " \n");
        sb.append("当前系统： "+ DeviceUtils.getSystemVersion()+ " "+ "\n");
        sb.append("widthPixels : "+ dm.widthPixels + "\n");
        sb.append("heightPixels : "+ dm.heightPixels + "\n");
        sb.append("smallest width pixels : "+ smallestWidth + "\n");
        sb.append("densityDpi : "+ dm.densityDpi + "\n");
        sb.append("scaledDensity : "+ dm.scaledDensity + "\n");

        sb.append("计算smallestWidth公式 : smallestWidth/(densityDpi/160.0)"+  "\n");
        sb.append("计算出来的smallestWidth : " + smallestWidth + "/(" + dm.densityDpi + "/160.0) = "
                + smallestWidth/(dm.densityDpi/160.0) +"dp" + "\n");

        sb.append("实际使用的smallestWidth :  "+ ResUtils.getStringRes(R.string.base_dpi) + "\n");


        mTvMatchData.setText(sb.toString());
    }
}
