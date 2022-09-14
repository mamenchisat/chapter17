package com.hspedu.threaduse;

/**
 * 项目名：    chapter17
 * 文件名：    ThreadUse01
 * 创建时间：   2022/9/3 16:28
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class ThreadUse01 {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        Cat cat = new Cat();
        cat.start();
        //说明，调用start()主线程不会阻塞，会继续向下执行，而如果调用run()主线程会阻塞
        while (true) {
            System.out.println(++i + Thread.currentThread().getName());
            Thread.sleep(1000);
            if (i == 80) {
                break;
        }
        }
    }
}

class Cat extends Thread {//当一个类继承了Thread，该类就可以当成一个线程
    int time = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("Cat run" + " " + (++time) + " 线程名称： " + Thread.currentThread().getName());
            //休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (time == 80) {
                break;
            }
        }
    }
}