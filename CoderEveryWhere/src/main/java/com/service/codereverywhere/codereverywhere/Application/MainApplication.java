package com.service.codereverywhere.codereverywhere.Application;

import android.app.Application;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.tendcloud.tenddata.TCAgent;

/**
 * Created by uncle_charlie on 26/9/15.
 */
public class MainApplication extends Application {

    private static final String TAG = MainApplication.class.getName();

    private static MainApplication _instance;

    public static MainApplication getApplicationInstance(){
        if (_instance == null) {
            throw new IllegalStateException("Not initialized yet");
        }
        return _instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        _instance = this;   // application instance.

        initImageLoader();

        // init talking data analytics tool.
        TCAgent.init(this);
    }

    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .writeDebugLogs()
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .memoryCache(new LruMemoryCache(4 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .diskCacheSize(100 * 1024 * 1024)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .build();
        ImageLoader.getInstance().init(config);
    }
}
