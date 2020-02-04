package threads.learn.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-02-03 21:55
 * @Descripe 实现一个简单的闭锁
 * @Version 0.0.1
 */
public class OneShotLatch {
    private final Sync sync = new Sync();

    public void signal(){
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int ignored) {
            return (getState() == 1) ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int ignored) {
            setState(1);
            return true;
        }
    }

}
