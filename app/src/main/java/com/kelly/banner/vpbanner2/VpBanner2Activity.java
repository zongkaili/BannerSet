package com.kelly.banner.vpbanner2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.kelly.banner.R;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

public class VpBanner2Activity extends AppCompatActivity {

    private FlyBanner mBannerLocal;//加载本地图片

    private FlyBanner mBannerNet;//加载网络图片

    private FlyBanner mGallery;

    private String[] mImagesUrl = {
            "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1487670814&di=68a37f51a0233a0ca396f8d661120e37&src=http://i.shangc.net/2017/0130/20170130053110183.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487680880654&di=8671166ebbd4e1c08c6d877a84c2ff65&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201702%2F08%2Fb9d736adf055b920d2cec2f53855137c.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487680880653&di=fcd2e7d22981cfd7fe1701bfcbf0c3f2&imgtype=0&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2F3c1f8fe0970d2621f3c0e0983687b2d6e15b8910.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487680880650&di=6808bc859011952ec93a76d22dec2b65&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201702%2F20%2F44bf2e8e808e0b55a370974b5d1c83aa.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487680880644&di=45b0ee6a60431a51e2995eaf19295fca&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201702%2F16%2Fa1121812ce1587f5da5322a27de6ae7d.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487680880632&di=38421df82f00634adc8129f601174acf&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201702%2F16%2F8a7dfefb3c6999a68782b3e2df9c10ba.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487681072596&di=f04860ad05511004eb4beb90e0ffe811&imgtype=0&src=http%3A%2F%2Fwww.southyule.com%2Fd%2Ffile%2FTV%2F4%2F2017-02-10%2Ffdc717553b7a0004ce5370b24c59bef9.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487680880651&di=ee2455c250aae093c569642ec74b4ed0&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2Fd%2Ffile%2F201702%2F16%2Fe5ce78f6c5c5124d4eac82edbc7df6eb.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp2);


        initLocalBanner();

        initNetBanner();
    }

    /**
     * 加载本地图片
     */
    private void initLocalBanner() {
        mBannerLocal = (FlyBanner) findViewById(R.id.banner_1);

        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.timg0);
        images.add(R.mipmap.timg1);
        images.add(R.mipmap.timg2);
        images.add(R.mipmap.timg3);
        images.add(R.mipmap.timg4);
        images.add(R.mipmap.timg6);
        mBannerLocal.setImages(images);
//        mBannerLocal.setPointsPosition(FlyBanner.RIGHT);

        mBannerLocal.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                toast("点击了第"+position+"张图片");
            }
        });
    }

    /**
     * 加载网页图片
     */
    private void initNetBanner() {
        mBannerNet = (FlyBanner) findViewById(R.id.banner_2);

        List<String> imgesUrl = new ArrayList<>();
        for (int i = 0; i < mImagesUrl.length; i++) {
            imgesUrl.add(mImagesUrl[i]);
        }
        mBannerNet.setImagesUrl(imgesUrl,false);

        mBannerNet.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                toast("点击了第" + position + "张图片");
            }
        });
    }

    private void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }


}
