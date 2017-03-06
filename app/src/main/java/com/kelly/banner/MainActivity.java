package com.kelly.banner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kelly.banner.recyclerbanner.RecyclerBannerActivity;
import com.kelly.banner.vpbanner1.VpBanner1Activity;
import com.kelly.banner.vpbanner2.VpBanner2Activity;
import com.kelly.banner.vpbanner3.VpBanner3Activity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtn1, mBtn2, mBtn3, mBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (Button) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
        mBtn4 = (Button) findViewById(R.id.btn4);
        mBtn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this, RecyclerBannerActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, VpBanner1Activity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this, VpBanner2Activity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(MainActivity.this, VpBanner3Activity.class));
                break;
        }
    }
}
