package com.example.lizejun.repoglidelearn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.lizejun.repoglidelearn.module.AutoSizeModelImpl;
import com.example.lizejun.repoglidelearn.module.AutoSizeModelLoader;

public class CustomGlideActivity extends Activity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_glide);
        mImageView = (ImageView) findViewById(R.id.iv_result);
    }

    public void loadCustomGlide(View view) {
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(mImageView);
    }

    public void loadCustomModule(View view) {
        AutoSizeModelImpl autoSizeModel = new AutoSizeModelImpl("http://i.imgur.com/DvpvklR.png");
        Glide.with(this)
                .load(autoSizeModel)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(mImageView);
    }

    public void loadDynamicModule(View view) {
        AutoSizeModelImpl autoSizeModel = new AutoSizeModelImpl("http://i.imgur.com/DvpvklR.png");
        AutoSizeModelLoader autoSizeModelLoader = new AutoSizeModelLoader(this);
        Glide.with(this)
                .using(autoSizeModelLoader)
                .load(autoSizeModel)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(mImageView);
    }
}
