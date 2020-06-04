package com.ivan.jdk.system;

import org.junit.Test;

public class NanoTime {
    @Test
    public void test() throws Exception{
        long a=System.nanoTime();
        System.out.println(a);
        Thread.sleep(1000);
        System.out.println(System.nanoTime());

        System.out.println(">>current");
        System.out.println(System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis());
    }
}
