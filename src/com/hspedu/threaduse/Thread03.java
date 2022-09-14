package com.hspedu.threaduse;

/**
 * 项目名：    chapter17
 * 文件名：    Thread03
 * 创建时间：   2022/9/3 20:32
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class Thread03 {
    @SuppressWarnings({})
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
              while (true) {
                  System.out.println("我是线程1");
                  try {
                      Thread.sleep(1000);
                      i++;
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
                  if (i == 9) {
                      break;
                  }

              }
            }
        }).start();
    }
}
class MyThread1 implements Runnable {
    int i = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
            if (i == 4) {
                break;
            }
        }
    }
}
class MyThread2 implements Runnable {
    int i = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello,world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
            if (i == 9) {
                break;
            }
        }
    }
}