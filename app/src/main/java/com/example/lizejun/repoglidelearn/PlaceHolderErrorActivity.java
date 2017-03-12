package com.example.lizejun.repoglidelearn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class PlaceHolderErrorActivity extends Activity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_holder_error);
        mImageView = (ImageView) findViewById(R.id.iv_result);
    }

    public void loadHolder(View view) {
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .placeholder(R.drawable.book_placeholder)
                .into(mImageView);
    }

    public void loadHolderError(View view) {
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .asGif()
                .placeholder(R.drawable.book_placeholder)
                .error(R.drawable.book_error)
                .into(mImageView);
    }

    public void loadCustomCrossFade(View view) {
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .placeholder(R.drawable.book_placeholder)
                .crossFade(5000)
                .into(mImageView);
    }

    public void loadNoCrossFade(View view) {
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .placeholder(R.drawable.book_placeholder)
                .dontAnimate()
                .into(mImageView);
    }
}
