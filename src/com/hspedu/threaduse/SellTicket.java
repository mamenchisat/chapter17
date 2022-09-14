package com.hspedu.threaduse;

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

class TicketDemo implements Runnable {
    private static int ticketNumber = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNumber > 0) {
                System.out.println(Thread.currentThread().getName() + " 剩余票量：" + --ticketNumber);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else {
                System.out.println("售票结束~");
                break;
            }
        }
    }
}