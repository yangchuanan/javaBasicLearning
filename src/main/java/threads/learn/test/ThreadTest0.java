package threads.learn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-01-31 21:17
 * @Descripe
 * @Version 0.0.1
 */
@RunWith(JUnit4.class)
public class ThreadTest0 {
    private final AtomicLong count = new AtomicLong(0);

    @Test
    public void test0() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> count.incrementAndGet()).start();
        }

        Thread.sleep(2000);
        System.out.println(count.get());
    }

    @Test
    public void test1() throws InterruptedException {
        new ThreadPoolExecutor.CallerRunsPolicy();
        ExecutorService exec = Executors.newCachedThreadPool();
        ((ThreadPoolExecutor)exec).setCorePoolSize(10);
        exec.invokeAll(null,10,null);

    }

}
