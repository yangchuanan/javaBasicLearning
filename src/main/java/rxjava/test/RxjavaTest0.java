package rxjava.test;

import io.reactivex.Observable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-01-30 21:12
 * @Descripe Rxjava 响应编程测试
 * @Version 0.0.1
 */
@RunWith(JUnit4.class)
public class RxjavaTest0 {

    @Test
    public void Test0() {
        Observable.just("Hello World!");
        Observable.create(observer -> {
            try {
                if (!observer.isDisposed()) {
                    for (int i = 1; i < 5; i++) {
                        observer.onNext(i);
                    }
                    observer.onComplete();
                }
            } catch (Exception e) {
                observer.onError(e);
            }
        }).subscribe(System.out::println, System.err::println, () -> System.out.println("sequence complete."));
    }

    @Test
    public void Test1(){

    }

}
