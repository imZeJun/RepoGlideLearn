package com.example.lizejun.repoglidelearn;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ThumbnailsActivity extends Activity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thumbnails);
        mImageView = (ImageView) findViewById(R.id.iv_result);
    }

    public void loadScaleThumbnail(View view) {
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .thumbnail(0.1f)
                .into(mImageView);
    }

    public void loadRequestThumbnail(View view) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(this)
                .load("http://i.imgur.com/DvpvklR.png");
        Glide.with(this)
                .load("http://s1.dwstatic.com/group1/M00/66/4D/d52ff9b0727dfd0133a52de627e39d2a.gif")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .thumbnail(thumbnailRequest)
                .into(mImageView);
    }
}
