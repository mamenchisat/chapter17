package com.hspedu.syn;

/**
 * 项目名：    chapter17
 * 文件名：    SellTicket
 * 创建时间：   2022/9/3 20:51
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class SellTicket {
    public static void main(String[] args) {
        TicketDemo ticketDemo = new TicketDemo();
        new Thread(ticketDemo).start();
        new Thread(ticketDemo).start();
        new Thread(ticketDemo).start();
    }
}
/**
 * 使用synchornized实现线程同步
 */

class TicketDemo implements Runnable {
    private static int ticketNumber = 100;
    private boolean flag = true;
    public synchronized void sell() {
        if (ticketNumber > 0) {
            System.out.println(Thread.currentThread().getName() + " 剩余票量：" + --ticketNumber);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("售票结束~");
            flag = false;
            return;
        }
    }

    @Override
    public void run() {
        while (flag) {
            sell();
        }
    }
}