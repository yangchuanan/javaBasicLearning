package threads.learn.test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 20:54
 * @Descripe 线程中断demo
 * @Version 0.0.1
 */
public class InterruptExample {

    private static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
               System.out.println("thread 2 running");
            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread();
        // 启动线程，线程阻塞
        thread1.start();
        // 中断线程，使线程提前结束
        thread1.interrupt();
        System.out.println("Main run");

        Thread thread2 = new MyThread2();
        thread2.start();
        Thread.sleep(1000);
        // 给线程2发送中断信号
        thread2.interrupt();
    }
}
