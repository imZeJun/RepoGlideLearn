package com.example.lizejun.repoglidelearn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public abstract class BaseActivity extends Activity {


    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        View textView = findViewById(R.id.tv_load);
        mImageView = (ImageView) findViewById(R.id.iv_result);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoadButtonClick();
            }
        });
    }

    protected void onLoadButtonClick() {}

    protected ImageView getImageView() {
        return mImageView;
    }
}
