package threads.learn.test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 21:46
 * @Descripe demo
 * @Version 0.0.1
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        /** 定义线程本地变量*/
        ThreadLocal threadLocal = new ThreadLocal();

        Thread thread1 = new Thread(() -> {
            /** 线程1设置 为1 */
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /** 获取值，线程1独有，不受线程2影响*/
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            // 线程2设置为2
            threadLocal.set(2);
            threadLocal.remove();
        });

        thread1.start();
        thread2.start();
    }
}
