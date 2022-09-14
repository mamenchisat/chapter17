package com.hspedu.threaduse;

/**
 * 项目名：    chapter17
 * 文件名：    ThreadState_
 * 创建时间：   2022/9/3 22:09
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + " 状态 " + t.getState());
        t.start();
        while (t.getState() != Thread.State.TERMINATED) {
            System.out.println(t.getName() + " 状态 " + t.getState());
            Thread.sleep(500);
        }
        System.out.println(t.getName() + " 状态 " + t.getState());
    }
}

class T extends Thread {
    int i = 0;
    @Override
    public void run() {
        while (true) {

            System.out.println("hi " + ++i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 10) {
                break;
            }

        }
    }
}