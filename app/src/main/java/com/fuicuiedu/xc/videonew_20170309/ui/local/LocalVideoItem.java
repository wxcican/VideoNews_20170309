package com.fuicuiedu.xc.videonew_20170309.ui.local;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuicuiedu.xc.videonew_20170309.R;
import com.fuicuiedu.xc.videoplayer.full.VideoViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/23 0023.
 */

public class LocalVideoItem extends FrameLayout{


    public LocalVideoItem(Context context) {
        this(context,null);
    }

    public LocalVideoItem(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LocalVideoItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @BindView(R.id.ivPreview)
    ImageView ivPreview;
    @BindView(R.id.tvVideoName)
    TextView tvVideoName;
    private String filePath;//文件路径


    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_local_video,this,true);
        ButterKnife.bind(this);
    }

    public void bind(Cursor cursor){
        //取出视频名称
        int index = cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME);
        String videoName = cursor.getString(index);
        tvVideoName.setText(videoName);
        //取出视频路径
        filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
    }

    //点击item，全屏播放
    @OnClick
    public void click(){
        VideoViewActivity.open(getContext(),filePath);
    }
}
