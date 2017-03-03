//package com.kelly.banner.recyclerbanner;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import com.bumptech.glide.Glide;
//import com.kelly.banner.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by zongkaili on 2017/3/3.
// */
//
//public class RecyclerAdapter extends RecyclerView.Adapter {
//    private Context mContext;
//    private List<BannerEntity> datas = new ArrayList<>();
//    OnPagerClickListener onPagerClickListener;
//
//    public RecyclerAdapter(Context context , List datas){
//        mContext = context;
//        this.datas = datas;
//    }
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        ImageView img = new ImageView(parent.getContext());
//        RecyclerView.LayoutParams l = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        img.setLayoutParams(l);
//        img.setId(R.id.icon);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onPagerClickListener != null) {
//                    onPagerClickListener.onClick(datas.get(currentIndex % datas.size()));
//                }
//            }
//        });
//        return new RecyclerView.ViewHolder(img) {
//        };
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        ImageView img = (ImageView) holder.itemView.findViewById(R.id.icon);
//        Glide.with(img.getContext()).load(datas.get(position % datas.size()).getUrl()).placeholder(R.mipmap.ic_launcher).into(img);
//    }
//
//    @Override
//    public int getItemCount() {
//        return datas == null ? 0 : datas.size() < 2 ? datas.size() : Integer.MAX_VALUE;
//    }
//
//    public interface BannerEntity {
//        String getUrl();
//    }
//
//    public interface OnPagerClickListener {
//        void onClick(BannerEntity entity);
//    }
//
//    public void setOnPagerClickListener(OnPagerClickListener onPagerClickListener) {
//        this.onPagerClickListener = onPagerClickListener;
//    }
//
//}
