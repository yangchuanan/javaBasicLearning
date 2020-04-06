package threads.learn.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 21:19
 * @Descripe 控制多个线程
 * @Version 0.0.1
 */
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 启动10个线程执行任务
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run..");
                // 计数减去1
                countDownLatch.countDown();
            });
        }
        // 主线程在countDownLatch上等待，0时被唤醒
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
