package com.example.lizejun.repoglidelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBaseDemo(View view) {
        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);
    }

    public void clickPlaceHolderDemo(View view) {
        Intent intent = new Intent(this, PlaceHolderErrorActivity.class);
        startActivity(intent);
    }

    public void clickOverrideDemo(View view) {
        Intent intent = new Intent(this, OverrideActivity.class);
        startActivity(intent);
    }

    public void clickThumbnailDemo(View view) {
        Intent intent = new Intent(this, ThumbnailsActivity.class);
        startActivity(intent);
    }

    public void clickTargetDemo(View view) {
        Intent intent = new Intent(this, CustomTargetActivity.class);
        startActivity(intent);
    }

    public void clickTransformDemo(View view) {
        Intent intent = new Intent(this, TransformActivity.class);
        startActivity(intent);
    }

    public void clickAnimateDemo(View view) {
        Intent intent = new Intent(this, AnimateActivity.class);
        startActivity(intent);
    }

    public void clickCustomGlideDemo(View view) {
        Intent intent = new Intent(this, CustomGlideActivity.class);
        startActivity(intent);
    }
}
