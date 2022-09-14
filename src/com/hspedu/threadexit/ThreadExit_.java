package com.hspedu.threadexit;

/**
 * 项目名：    chapter17
 * 文件名：    ThreadExit_
 * 创建时间：   2022/9/3 21:14
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setName("一号线程");
        myThread.start();

        Thread.sleep(10000);
        myThread.setLoop(false);
    }
}

class MyThread extends Thread {
    //设置一个控制变量
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println("MyThread运行中"+Thread.currentThread().getName());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}