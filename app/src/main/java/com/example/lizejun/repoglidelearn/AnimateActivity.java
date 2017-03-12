package com.example.lizejun.repoglidelearn;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.bumptech.glide.request.target.ViewTarget;

public class AnimateActivity extends Activity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        mImageView = (ImageView) findViewById(R.id.iv_result);
    }

    public void loadAnimate(View view) {
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .animate(R.anim.glide_animate)
                .into(mImageView);
    }

    public void loadAnimator(View view) {
        MyAnimator myAnimator = new MyAnimator();
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .animate(myAnimator)
                .into(mImageView);
    }

    private class MyAnimator implements ViewPropertyAnimation.Animator {

        @Override
        public void animate(View view) {
            final View finalView = view;
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value = (float) animation.getAnimatedValue();
                    finalView.setScaleX((float) (0.5 + 0.5 * value));
                    finalView.setScaleY((float) (0.5 + 0.5 * value));
                    finalView.setAlpha(value);
                }
            });
            valueAnimator.start();
        }
    }
}
