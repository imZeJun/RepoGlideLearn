package com.example.lizejun.repoglidelearn.moduleloader;

import android.content.Context;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;

import java.io.InputStream;
import okhttp3.OkHttpClient;

public class OkHttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    private OkHttpClient mOkHttpClient;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        private static volatile OkHttpClient sOkHttpClient;
        private static OkHttpClient getOkHttpClient() {
            if (sOkHttpClient == null) {
                synchronized (Factory.class) {
                    if (sOkHttpClient == null) {
                        sOkHttpClient = new OkHttpClient();
                    }
                }
            }
            return sOkHttpClient;
        }

        public Factory() {}

        @Override
        public ModelLoader<GlideUrl, InputStream> build(Context context, GenericLoaderFactory factories) {
            return new OkHttpGlideUrlLoader(getOkHttpClient());
        }

        @Override
        public void teardown() {}
    }

    public OkHttpGlideUrlLoader(OkHttpClient okHttpClient) {
        mOkHttpClient = okHttpClient;
    }

    @Override
    public DataFetcher<InputStream> getResourceFetcher(GlideUrl model, int width, int height) {
        return new OkHttpGlideUrlFetcher(mOkHttpClient, model);
    }
}
