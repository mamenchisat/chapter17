package com.hspedu.threaduse;

/**
 * 项目名：    chapter17
 * 文件名：    Thread02
 * 创建时间：   2022/9/3 20:06
 *
 * @author crazy Chen
 * 描述：
 * 通过实现Runable接口来实现多线程
 * TODO
 */
public class Thread02 {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        //这里不能调用start
//        new Thread(dog).start();
//        //为什么thread.start()，能调用Dog的run()方法呢，因为使用了一种设计模式-代理模式

    }
}

class ThreadProxy implements Runnable {//可以把Proxy类当作ThreadProxy
    private Runnable target = null;
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    public void start() {
        start0();
    }
    private void start0(){
     run();
    }
}
class Dog implements Runnable {
    int num = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("小狗叫 "+(++num) +Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (num == 10) {
                break;
            }
        }
    }
}