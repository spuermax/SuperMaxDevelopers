package com.developers.supermax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.supermax.base.mvp.QsActivity;

import me.jessyan.autosize.internal.CustomAdapt;

public class MainActivity extends QsActivity implements CustomAdapt{


    /**
     * 是否按照宽度进行等比例适配 (为了保证在高宽比不同的屏幕上也能正常适配, 所以只能在宽度和高度之中选择一个作为基准进行适配)
     *
     * @return {@code true} 为按照宽度进行适配, {@code false} 为按照高度进行适配
     */
    @Override
    public boolean isBaseOnWidth() {
        return true;
    }


    /**
     * 这里使用 iPhone 的设计图, iPhone 的设计图尺寸为 750px * 1334px, 因为这个页面使用副单位进行布局
     * 所以可以直接以像素作为单位返回设计图的尺寸
     * <p>
     * 返回设计图上的设计尺寸
     * {@link #getSizeInDp} 须配合 {@link #isBaseOnWidth()} 使用, 规则如下:
     * 如果 {@link #isBaseOnWidth()} 返回 {@code true}, {@link #getSizeInDp} 则应该返回设计图的总宽度
     * 如果 {@link #isBaseOnWidth()} 返回 {@code false}, {@link #getSizeInDp} 则应该返回设计图的总高度
     * 如果您不需要自定义设计图上的设计尺寸, 想继续使用在 AndroidManifest 中填写的设计图尺寸, {@link #getSizeInDp} 则返回 {@code 0}
     *
     * @return 设计图上的设计尺寸
     */
    @Override
    public float getSizeInDp() {
        return 375;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }
}
