package com.hspedu.threaduse;

import java.util.Scanner;

/**
 * 项目名：    chapter17
 * 文件名：    HomeWork01
 * 创建时间：   2022/9/4 9:41
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class HomeWork01 {
    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        new Thread(myThread01).start();
        new Thread(new MyThread02(myThread01)).start();
    }
}

class MyThread01 implements Runnable {
    boolean flag = true;


    @Override
    public void run() {
        while (flag) {
            System.out.println( (int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThread02 extends MyThread01 implements Runnable {
    public MyThread02(MyThread01 myThread01) {
        this.myThread01 = myThread01;
    }

    private MyThread01 myThread01;

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入Q暂停输出");
            String a = scanner.next();
            if (a.toUpperCase().charAt(0) == 'Q') {
                myThread01.flag = false;
                break;
            }
        }
    }
}