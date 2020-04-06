package threads.learn.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 20:49
 * @Descripe Executors工具类
 * @Version 0.0.1
 */
public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorService executorService;

        executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 等待所有线程都执行完成
//        executorService.shutdown();
        // 相当于向所有线程发送interrupt()
        executorService.shutdownNow();
        System.out.println("Main run");

        // 向指定的线程发送中断
        Future<?> future = executorService.submit(() -> {
            // ..
        });
        future.cancel(true);

    }
}
