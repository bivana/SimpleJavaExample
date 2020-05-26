package com.ivan.jdk.classloader;

/**
 * 查看类加载器
 * */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader cl=ClassLoaderDemo.class.getClassLoader();
        System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
