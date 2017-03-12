package com.example.lizejun.repoglidelearn;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomView extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;

    public CustomView(Context context) {
        super(context);
    }
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        mTextView = (TextView) findViewById(R.id.tv_custom_result);
        mImageView = (ImageView) findViewById(R.id.iv_custom_result);
    }

    public void setResult(Drawable drawable) {
        mTextView.setText("load success");
        mImageView.setImageDrawable(drawable);
    }

}
