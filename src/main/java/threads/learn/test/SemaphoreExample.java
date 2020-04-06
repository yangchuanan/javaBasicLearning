package threads.learn.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 21:27
 * @Descripe demo
 * @Version 0.0.1
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;

        // 拥有3个信号
        Semaphore semaphore = new Semaphore(clientCount);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(()->{
                try {
                    // 获取一个值，获取到执行，否则等待
                    semaphore.acquire();
                    // 剩余几个可用，最多允许三个线程运行
                    System.out.print(semaphore.availablePermits() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 使用完释放
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
