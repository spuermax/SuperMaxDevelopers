package com.developers.supermax;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.supermax.base.QsApplication;
import com.supermax.base.common.http.HttpBuilder;

/**
 * @Author yinzh
 * @Date 2019/3/5 15:39
 * @Description
 */
public class SupperApplication extends QsApplication{

    private RefWatcher refWatcher = null;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }

        refWatcher = LeakCanary.install(this);
    }


    /**
     * 每次打正式包，必须把  true改为false
     * true开启日志
     * false关闭日志
     */
    @Override
    public boolean isLogOpen() {
        return true;
    }

    @Override
    public void initHttpAdapter(HttpBuilder builder) throws Exception {

    }


}
