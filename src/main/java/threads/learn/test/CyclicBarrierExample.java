package threads.learn.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 21:23
 * @Descripe demo
 * @Version 0.0.1
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        final int totalThread = 10;
        // 循环屏障，计数可被重置
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("before..");
                try {
                    // 计数-1并等待
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                // 屏障计数为0时才执行
                System.out.print("after..");
            });
        }
        executorService.shutdown();
    }
}
