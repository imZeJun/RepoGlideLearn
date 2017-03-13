package com.example.lizejun.repoglidelearn.module;

import android.content.Context;

import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;

import java.io.InputStream;

public class AutoSizeModelLoader extends BaseGlideUrlLoader<AutoSizeModel> {

    public static class Factory implements ModelLoaderFactory<AutoSizeModel, InputStream> {

        @Override
        public ModelLoader<AutoSizeModel, InputStream> build(Context context, GenericLoaderFactory factories) {
            return new AutoSizeModelLoader(context);
        }

        @Override
        public void teardown() {}
    }

    public AutoSizeModelLoader(Context context) {
        super(context);
    }

    @Override
    protected String getUrl(AutoSizeModel model, int width, int height) {
        return model.requestSizeUrl(width, height);
    }
}
