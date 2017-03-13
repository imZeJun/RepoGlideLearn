package com.example.lizejun.repoglidelearn.module;


import com.example.lizejun.repoglidelearn.module.AutoSizeModel;

public class AutoSizeModelImpl implements AutoSizeModel {

    String mUrl;

    public AutoSizeModelImpl(String url) {
        mUrl = url;
    }

    @Override
    public String requestSizeUrl(int width, int height) {
        return mUrl;
    }
}
