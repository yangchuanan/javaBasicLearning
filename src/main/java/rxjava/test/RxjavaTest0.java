package rxjava.test;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    public void Test1() {
        Observable<Integer> a = Observable.defer(() ->
                Observable.just(123)
        );
        System.out.println("Hello defer()!");
        a.subscribe(System.out::println);

        // 创建空的
        Observable empty = Observable.empty();
        // 创建不发送任何数据
        Observable empty1 = Observable.never();
    }

    @Test
    public void Test2() {
        Observable<String> abc = Observable.fromArray("a", "b", "c");
        abc.subscribe(System.out::println);
    }

    @Test
    public void Test3() {
        Integer x = 5;
        Observable.just("a").repeatUntil(() -> x > 4).subscribe(System.out::println);
    }

    @Test
    public void Test4() {
        Observable.range(0, 10).buffer(6).subscribe(System.out::println);
    }

    @Test
    public void Test5(){
        TestScheduler scheduler = new TestScheduler();
        Observable<String> abc=Observable.fromArray("a","b","c");
        abc.concatMap(x-> Observable.just(x+"c"))
                .delay(new Random().nextInt(5), TimeUnit.SECONDS,scheduler)
                .toList()
                .subscribe(System.out::println,System.out::println);

        scheduler.advanceTimeBy(30,TimeUnit.SECONDS);
    }

    @Test
    public void Test6(){
        TestScheduler scheduler = new TestScheduler();
        Observable<String> abc=Observable.fromArray("a","b","c");
        abc.flatMap(x-> Observable.just(x+"f"))
                .delay(new Random().nextInt(5), TimeUnit.SECONDS,scheduler)
                .toList()
                .subscribe(System.out::println,System.out::println);
        scheduler.advanceTimeBy(30,TimeUnit.SECONDS);
    }

    @Test
    public void Test7(){
        TestScheduler scheduler = new TestScheduler();
        Observable<String> abc=Observable.fromArray("a","b","c");
        abc.switchMap(x-> Observable.just(x+"s"))
                .delay(new Random().nextInt(5), TimeUnit.SECONDS,scheduler)
                .toList()
                .subscribe(System.out::println,System.out::println);
        scheduler.advanceTimeBy(30,TimeUnit.SECONDS);
    }

}
