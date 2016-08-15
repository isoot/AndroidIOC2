package com.androidioc.tianhongliang.androidioc.ioc;

import android.app.Activity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by tianhongliang on 2016/8/13.
 */
public class ViewInJect {

    public static void viewInject(Activity activity){
        contentView(activity);
        findView(activity);
    }
    private static void contentView(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        ContentViewInJect annotation = aClass.getAnnotation(ContentViewInJect.class);
        if (annotation != null) {
            try {
                int layoutID = annotation.value();
                Method method = aClass.getMethod("setContentView", int.class);
                method.setAccessible(true);
                method.invoke(activity, layoutID);
            } catch (Exception e) {
            }
        }
    }

    private static void findView(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            FinaViewInject annotation = field.getAnnotation(FinaViewInject.class);
            if (annotation != null) {
                try {
                    int findID = annotation.value();
                    if(findID!=-1) {
                        Method method = aClass.getMethod("findViewById", int.class);
                        Object object = method.invoke(activity, findID);
                        field.setAccessible(true);
                        field.set(activity, object);
                    }
                } catch (Exception e) {
                }

            }
        }
    }
}
