package com.example.lizejun.repoglidelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class OverrideActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_override);
        mImageView = (ImageView) findViewById(R.id.iv_result);
    }

    public void loadOverride(View view) {
        Glide.with(this)
                .load(R.drawable.shader_pic)
                .override(20, 20)
                .into(mImageView);
    }

    public void loadOverrideCenterCrop(View view) {
        Glide.with(this)
                .load(R.drawable.shader_pic)
                .override(20, 20)
                .centerCrop()
                .into(mImageView);
    }

    public void loadOverrideFitCenter(View view) {
        Glide.with(this)
                .load(R.drawable.shader_pic)
                .override(20, 20)
                .fitCenter()
                .into(mImageView);
    }
}
