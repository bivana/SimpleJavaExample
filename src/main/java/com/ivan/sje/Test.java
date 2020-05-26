package com.ivan.sje;

import org.junit.Assert;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    @org.junit.Test
    public void test(){
        AtomicInteger au=new AtomicInteger();
        System.out.println(au.getAndIncrement());
        System.out.println(au.incrementAndGet());
        System.out.println(au.getAndIncrement());


    }

    public int gcd(int a,int b){
        int n=0;
        while (b!=0){
            n=a%b;
            a=b;
            b=n;
        }
        return a;
    }
}
