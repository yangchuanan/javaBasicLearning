package threads.learn.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 21:33
 * @Descripe demo
 * @Version 0.0.1
 */
public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // FutureTask--->RunableFuture--->Runnable,Future
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int result = 0;
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
                result += i;
            }
            return result;
        });

        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        // 运行其他线程
        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();

        // 获取结果
        System.out.println(futureTask.get());
    }
}
