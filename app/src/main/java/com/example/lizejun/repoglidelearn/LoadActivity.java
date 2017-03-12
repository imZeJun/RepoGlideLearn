package com.example.lizejun.repoglidelearn;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class LoadActivity extends Activity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        mImageView = (ImageView) findViewById(R.id.iv_result);
    }

    //从byte[]中加载.
    public void loadByteArray(View view) {
        Bitmap sourceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.book_local);
        ByteArrayOutputStream bArrayOS = new ByteArrayOutputStream();
        sourceBitmap.compress(Bitmap.CompressFormat.PNG, 100, bArrayOS);
        sourceBitmap.recycle();
        byte[] byteArray = bArrayOS.toByteArray();
        try {
            bArrayOS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Glide.with(this)
                .load(byteArray)
                .into(mImageView);
    }
    //从File中加载.
    public void loadFile(View view) {
        String storePath = "mnt/sdcard/book_local.jpg";
        File file = new File(storePath);
        Glide.with(this)
                .load(file)
                .into(mImageView);
    }
    //从resourceId中加载.
    public void loadResourceId(View view) {
        Glide.with(this)
                .load(R.drawable.book_local)
                .into(mImageView);
    }
    //从普通url中加载.
    public void loadNormalUrl(View view) {
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .into(mImageView);
    }
    //从gif加载.
    public void loadGif(View view) {
        Glide.with(this)
                .load("http://s1.dwstatic.com/group1/M00/66/4D/d52ff9b0727dfd0133a52de627e39d2a.gif")
                .diskCacheStrategy(DiskCacheStrategy.SOURCE) //要加上这句，否则有可能会出现加载很慢，或者加载不出来的情况.
                .into(mImageView);
    }
    //从本地媒体视频中加载.
    public void loadMedia(View view) {
        String storePath = "mnt/sdcard/media.mp4";
        File file = new File(storePath);
        Glide.with(this)
                .load(Uri.fromFile(file))
                .into(mImageView);
    }

}
