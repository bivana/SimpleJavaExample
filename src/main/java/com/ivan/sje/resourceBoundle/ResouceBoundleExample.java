package com.ivan.sje.resourceBoundle;


import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * {@link ResourceBundle}
 * 使用说明
 */

public class ResouceBoundleExample {

    public static void main(String[] args){
        String packageName=ResouceBoundleExample.class.getPackage().getName();
        Locale zhLocal = new Locale("zh", "CN");
//        ResourceBundle zhRb = ResourceBundle.getBundle("com.ivan.sje.resourceBoundle.resource.test", zhLocal);
        ResourceBundle zhRb = ResourceBundle.getBundle(packageName+".resource.test", zhLocal);
        System.out.println(zhRb.getString("test1"));
        System.out.println(zhRb.getString("test2"));

        Locale usLocal = new Locale("en", "US");
        ResourceBundle usRb = ResourceBundle.getBundle(packageName+".resource.test", usLocal);
        System.out.println(usRb.getString("test1"));
        System.out.println(usRb.getString("test2"));

        ResourceBundle deRb = ResourceBundle.getBundle(packageName+".resource.test", Locale.getDefault());
        System.out.println(deRb.getString("test1"));
        System.out.println(deRb.getString("test1"));

    }
}
