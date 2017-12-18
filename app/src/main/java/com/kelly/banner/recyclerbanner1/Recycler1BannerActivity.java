package com.kelly.banner.recyclerbanner1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kelly.banner.R;
import com.kelly.banner.scalebanner.CenterScrollListener;
import com.kelly.banner.scalebanner.ScaleLayoutManager;
import com.kelly.banner.scalebanner.ViewPagerLayoutManager;
import com.kelly.banner.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * author zongkaili
 */
public class Recycler1BannerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ScaleLayoutManager scaleLayoutManager;

    private List<Recycler1Banner.BannerEntity> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler1);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        scaleLayoutManager = new ScaleLayoutManager(CommonUtil.dp2px(this, 10));
        scaleLayoutManager.setItemSpace(30);
        scaleLayoutManager.setCenterScale(1.3f);
        scaleLayoutManager.setMoveSpeed(1.0f);
        scaleLayoutManager.setInfinite(true);
        scaleLayoutManager.setOrientation(ViewPagerLayoutManager.HORIZONTAL);
        recyclerView.addOnScrollListener(new CenterScrollListener());
        recyclerView.setAdapter(new DataAdapter());
        recyclerView.setLayoutManager(scaleLayoutManager);
        recyclerView.scrollToPosition(0);
    }
}