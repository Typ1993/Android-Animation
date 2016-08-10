package com.example.dell.textapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;


/**
 * ScreenUtils
 */
public class ScreenUtils {
    private static int screenW;
    private static int screenH;
    private static float screenDensity;
    private static Context context1;
    public static void initScreen(Context context){
        DisplayMetrics metric = context.getResources().getDisplayMetrics();
        screenW = metric.widthPixels;
        screenH = metric.heightPixels;
        screenDensity = metric.density;
        context1 = context;
    }

    public static int getScreenW(){
        if (screenW == 0){
            initScreen(context1.getApplicationContext());
        }
        return screenW;
    }

    public static int getScreenH(){
        if (screenH == 0){
            initScreen(context1.getApplicationContext());
        }
        return screenH;
    }

    public static float getScreenDensity(){
        return screenDensity;
    }

    /** 根据手机的分辨率从 dp 的单位 转成为 px(像素) */
    public static int dp2px(float dpValue) {
        return (int) (dpValue * getScreenDensity() + 0.5f);
    }

    /** 根据手机的分辨率从 px(像素) 的单位 转成为 dp */
    public static int px2dp(float pxValue) {
        return (int) (pxValue / getScreenDensity() + 0.5f);
    }

    /**
     * 控件没有显示时，使用此方法测绘控件的宽度
     *
     * @param view 还未显示的控件
     * @return 控件宽度
     */
    public static int measureContentWidth(@NonNull View view) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(widthMeasureSpec, heightMeasureSpec);
        return view.getMeasuredWidth();
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
