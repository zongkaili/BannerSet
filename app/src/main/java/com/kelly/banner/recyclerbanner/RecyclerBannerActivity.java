package com.kelly.banner.recyclerbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.kelly.banner.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author zongkaili
 */
public class RecyclerBannerActivity extends AppCompatActivity {

    RecyclerBanner pager;
    private List<RecyclerBanner.BannerEntity> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        pager = (RecyclerBanner) findViewById(R.id.r);
        pager.setOnPagerClickListener(new RecyclerBanner.OnPagerClickListener() {
            @Override
            public void onClick(RecyclerBanner.BannerEntity entity) {
                Toast.makeText(RecyclerBannerActivity.this, entity.getUrl(), Toast.LENGTH_SHORT).show();
            }
        });

        //test
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.findFirstVisibleItemPosition();
        lm.findFirstCompletelyVisibleItemPosition();
        lm.findLastVisibleItemPosition();
        lm.findLastCompletelyVisibleItemPosition();
    }

    int i;

    public void update(View v) {
        i++;
        urls.clear();
        if (i % 2 == 0) {
            urls.add(new Entity("http://pic33.nipic.com/20130925/13709042_115930506133_2.jpg"));
            urls.add(new Entity("http://img1.3lian.com/2015/a1/14/d/141.jpg"));
            urls.add(new Entity("http://img1.3lian.com/2015/a1/14/d/138.jpg"));
            urls.add(new Entity("http://img.tuku.cn/file_big/201502/130639fc62fd4d3fa28aec1f3f303df8.jpg"));
            urls.add(new Entity("http://tupian.enterdesk.com/2013/mxy/10/12/2/1.jpg"));
        }
        else {
            urls.add(new Entity("http://pic6.nipic.com/20100318/4405445_135811004869_2.jpg"));
            urls.add(new Entity("http://image52.360doc.com/DownloadImg/2012/07/0417/25291306_12.jpg"));
            urls.add(new Entity("http://pic72.nipic.com/file/20150715/20077197_152819081854_2.jpg"));
        }
        long t = System.currentTimeMillis();

        pager.setDatas(urls);
        Log.w("---", System.currentTimeMillis() - t + "");
    }


    private class Entity implements RecyclerBanner.BannerEntity {

        String url;

        public Entity(String url) {
            this.url = url;
        }

        @Override
        public String getUrl() {
            return url;
        }
    }
}