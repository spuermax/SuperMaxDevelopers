package com.developers.supermax;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.supermax.base.QsApplication;
import com.supermax.base.common.http.HttpBuilder;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;

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


        configUnits();
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


    /**
     * 屏幕适配
     */
    private void configUnits(){

        AutoSizeConfig.getInstance().getUnitsManager()
                .setSupportDP(false)
                .setSupportSubunits(Subunits.MM);
    }


}
