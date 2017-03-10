package com.example.lizejun.repoglidelearn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bumptech.glide.Glide;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class AdvancedLoadingActivity extends BaseActivity {

    @Override
    protected void onLoadButtonClick() {
        //loadFromByteArray();
        //loadFromFile();
        //loadFromResourceId();
        //loadPlaceHolder();
        //loadError();
        loadPlaceHolderCrossFade();
    }

    private byte[] getByteArray() {
        Bitmap sourceBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream bArrayOS = new ByteArrayOutputStream();
        sourceBitmap.compress(Bitmap.CompressFormat.PNG, 100, bArrayOS);
        sourceBitmap.recycle();
        byte[] result = bArrayOS.toByteArray();
        try {
            bArrayOS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private void loadFromByteArray() {
        Glide.with(this).load(getByteArray()).into(getImageView());
    }

    private File getFile() {
        String storePath = "mnt/sdcard/ic_files.png";
        return new File(storePath);
    }

    private void loadFromFile() {
        Glide.with(this).load(getFile()).into(getImageView());
    }

    private String getUrl() {
        return "http://i.imgur.com/DvpvklR.png";
    }

    private void loadFromResourceId() {
        Glide.with(this).load(R.mipmap.ic_launcher).into(getImageView());
    }

    private void loadPlaceHolder() {
        Glide.with(this).load(getUrl()).placeholder(R.drawable.bg_tab_red).into(getImageView());
    }

    private void loadError() {
        Glide.with(this).load(getUrl()).placeholder(R.drawable.bg_tab_red).error(R.drawable.ic_sb_window_num_on).into(getImageView());
    }

    private void loadPlaceHolderCrossFade() {
        Glide.with(this).load(getUrl()).placeholder(R.drawable.bg_tab_red).crossFade(1000).into(getImageView());
    }

    private void loadPlaceHolderDontCrossFade() {
        Glide.with(this).load(getUrl()).placeholder(R.drawable.bg_tab_red).dontAnimate().into(getImageView());
    }

}
