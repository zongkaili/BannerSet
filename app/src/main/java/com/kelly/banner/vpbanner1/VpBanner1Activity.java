package com.kelly.banner.vpbanner1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.eicky.ViewPagerGallery;
import com.kelly.banner.R;

import java.util.ArrayList;
import java.util.List;

public class VpBanner1Activity extends AppCompatActivity {

    private ViewPagerGallery gallery;
    private RelativeLayout activitymain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp1);
        this.activitymain = (RelativeLayout) findViewById(R.id.activity_main);
        this.gallery = (ViewPagerGallery) findViewById(R.id.gallery);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            int id = getResources().getIdentifier("timg" + i, "mipmap", getPackageName());
            list.add(id);
        }
        gallery.setImgResources(list);
    }
}
