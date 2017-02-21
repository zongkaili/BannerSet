package com.kelly.banner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kelly.banner.recyclerbanner.RecyclerBannerActivity;
import com.kelly.banner.vpbanner1.VpBanner1Activity;
import com.kelly.banner.vpbanner2.VpBanner2Activity;

public class MainActivity extends Activity {


    private Button cityBtn, mainBtn, wangyiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {


        cityBtn = (Button) findViewById(R.id.btn1);
        cityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerBannerActivity.class));
            }
        });
        mainBtn = (Button) findViewById(R.id.btn2);
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VpBanner1Activity.class));
            }
        });
        wangyiBtn = (Button) findViewById(R.id.btn3);
        wangyiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VpBanner2Activity.class));
            }
        });

    }
}
