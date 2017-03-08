# MyBannerDemoSet

关于项目中遇到的各种banner效果的实现方式的整合
方便以后学习和总结

其中包含了recyclerView实现的banner效果，还有viewPager实现的画廊banner效果，其中还包含了自动轮播banner的实现方式

<!--![screen](https://github.com/zongkaili/RecyclerviewBanner-master/blob/master/screenshots/device-2016-12-06-223440.png,width=300)-->
<!--![screen](https://github.com/zongkaili/RecyclerviewBanner-master/blob/master/screenshots/device-2016-12-06-223604.png)-->
<!--![screen](https://github.com/zongkaili/RecyclerviewBanner-master/blob/master/screenshots/device-2016-12-06-223630.png)-->
![image](https://github.com/zongkaili/BannerSet/blob/master/screenshots/bannerset_gif.gif)
![image](https://github.com/zongkaili/BannerSet/blob/master/screenshots/bannerset_gallery.gif)
![image](https://github.com/zongkaili/BannerSet/blob/master/screenshots/device-2017-03-08-100349.jpg)

##关键代码
 - gallery效果
```java
  private void init() {
        int pagerWidth = (int) (getContext().getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        mLayoutParams = mViewPager.getLayoutParams();
        if (mLayoutParams == null) {
            mLayoutParams = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            mLayoutParams.width = pagerWidth;
        }
        mViewPager.setLayoutParams(mLayoutParams);
        mViewPager.setPageMargin(-50);
        mViewPager.setPageTransformer(true, new GalleryTransformer());
        mViewPager.setClipChildren(false);
        ViewGroup view = (ViewGroup) mViewPager.getParent();
        if (view != null) {
            view.setClipChildren(false);
            view.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return dispatchTouchEvent(event);
                }
            });
        }
        if(mImageUrls != null){
            mViewPager.setOffscreenPageLimit(mImageUrls.size());
        }
    }
```
其中  mViewPager.setPageTransformer(true, new GalleryTransformer());是设置viewPager切换时的动画效果。
GalleryTransformer类实现了ViewPager.PageTransformer接口，并重写transformPage()方法,具体实现如下：]

```java
  @Override
    public void transformPage(View page, float position) {
        float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
        float rotate = 20 * Math.abs(position);
        if (position < -1) {

        } else if (position < 0) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(rotate);
        } else if (position >= 0 && position < 1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        } else if (position >= 1) {
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setRotationY(-rotate);
        }
    }
    
```

##加载图片
Glide和Picasso

##參考
https://github.com/FlyRecker/FlyBanner

