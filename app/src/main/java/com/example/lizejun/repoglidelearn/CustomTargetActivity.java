package com.example.lizejun.repoglidelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.lizejun.repoglidelearn.view.CustomView;

public class CustomTargetActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_target);
        mImageView = (ImageView) findViewById(R.id.iv_result);
    }

    public void loadSimpleTarget(View view) {
        MySimpleTarget mySimpleTarget = new MySimpleTarget(50, 50);
        Glide.with(this)
                .load(R.drawable.book_url)
                .into(mySimpleTarget);
    }

    private class MySimpleTarget extends SimpleTarget<GlideDrawable> {

        public MySimpleTarget(int width, int height) {
            super(width, height);
        }

        @Override
        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
            mImageView.setImageDrawable(resource.getCurrent());
        }
    }

    public void loadViewTarget(View view) {
        CustomView customView = (CustomView) findViewById(R.id.cv_result);
        MyViewTarget myViewTarget = new MyViewTarget(customView);
        Glide.with(this)
                .load(R.drawable.book_url)
                .into(myViewTarget);
    }

    private class MyViewTarget extends ViewTarget<CustomView, GlideDrawable> {

        public MyViewTarget(CustomView customView) {
            super(customView);
        }

        @Override
        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
            view.setResult(resource.getCurrent());
        }
    }
}
