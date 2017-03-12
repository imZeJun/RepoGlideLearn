package com.example.lizejun.repoglidelearn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

public class TransformActivity extends Activity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transform);
        mImageView = (ImageView) findViewById(R.id.iv_result);
    }

    public void loadTransform(View view) {
        MyBitmapTransformation myBitmapTransformation = new MyBitmapTransformation(this);
        Glide.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .transform(myBitmapTransformation)
                .into(mImageView);
    }

    private class MyBitmapTransformation extends BitmapTransformation {

        public MyBitmapTransformation(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            Canvas canvas = new Canvas(toTransform);
            BitmapShader bitmapShader = new BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            int min = Math.min(toTransform.getWidth(), toTransform.getHeight());
            int radius = min / 2;
            RadialGradient radialGradient = new RadialGradient(toTransform.getWidth() / 2 , toTransform.getHeight() / 2, radius, Color.TRANSPARENT, Color.WHITE, Shader.TileMode.CLAMP);
            ComposeShader composeShader = new ComposeShader(bitmapShader, radialGradient, PorterDuff.Mode.SRC_OVER);
            Paint paint = new Paint();
            paint.setShader(composeShader);
            canvas.drawRect(0, 0, toTransform.getWidth(), toTransform.getHeight(), paint);
            return toTransform;
        }

        @Override
        public String getId() {
            return "MyBitmapTransformation";
        }
    }
}
