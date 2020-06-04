package com.ivan.sje.thread;

import org.junit.Test;

public class WaitNotifyDemo {

    /**
     * 运行主程序
     * */
    @Test
    public void test() throws Exception{
        Object o=new Object();
        new WaitThread(o).start();
        new NotifyThread(o).start();
        Thread.sleep(1000*1000);
    }

    /**
     * 通知线程
     * */
    public  class NotifyThread extends Thread{

        private Object o;//锁对象

        public NotifyThread(Object o){
            super();
            this.o=o;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(20*1000);
                System.out.println("thread 2 start to tonify all");
                System.out.println(this);
                synchronized (o){//注意，如果注释掉了synchronized 方法，运行notify方法并不会唤醒wait的线程
                    o.notify();
                }

            }catch (Exception e){

            }finally {
                System.out.println("thread 2 finish notify");
            }

        }
    }

    /**运行线程，调用wait等待*/
    public  class WaitThread extends Thread{

        private Object o;

        public WaitThread(Object o){
            super();
            this.o=o;
        }

        @Override
        public void run() {
            int i=0;
            while (true){
                i++;
                if(i==10){
                    try {
                        synchronized (o){//如果注释掉synchronzed ，调用wait后线程依然会执行
                            System.out.println("start to wait");
                            System.out.println(this);
                            o.wait();
                        }

                    }catch (Exception e){

                    }finally {
                        System.out.println("wait end-===========");
                    }

                }
                System.out.println("thread 1 is running:"+i);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){

                }

            }

        }
    }
}
