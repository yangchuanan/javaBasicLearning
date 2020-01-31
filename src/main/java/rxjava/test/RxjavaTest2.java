package rxjava.test;

import io.reactivex.Observable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.TimeUnit;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-01-31 15:47
 * @Descripe Compose
 * @Version 0.0.1
 */
@RunWith(JUnit4.class)
public class RxjavaTest2 {

    @Test
    public void Test0() {
        Observable a = Observable.interval(100, TimeUnit.MILLISECONDS).map(x -> "A" + x);
        Observable b = Observable.interval(160, TimeUnit.MILLISECONDS).map(x -> "B" + x);
        a.join(b, c -> Observable.timer(55, TimeUnit.MILLISECONDS),
                d -> Observable.timer(85, TimeUnit.MILLISECONDS),
                (x, y) -> x + "-" + y)
                .blockingForEach(System.out::println);
    }

    @Test
    public void Test1() {
        Observable a = Observable.interval(6, TimeUnit.MILLISECONDS);
        Observable b = Observable.interval(10, TimeUnit.MILLISECONDS);
        Observable.combineLatest(a, b, (x, y) -> x + "-" + y)
                .blockingForEach(System.out::println);
    }

    @Test
    public void Test2() {
        Observable.merge(Observable.range(1, 5).skip(3), Observable.range(1, 5).take(3))
                .subscribe(System.out::println);
    }

    @Test
    public void Test3() {
        Observable.zip(Observable.range(1, 5), Observable.range(10, 16), (x, y) -> x + "-" + y)
                .subscribe(System.out::println);
    }

    @Test
    public void Test4() {
        Observable.range(1, 5).flatMap(x -> Observable.defer(() -> {
            if (x != 3) {
                return Observable.just("A" + x);
            } else {
                throw new RuntimeException("Wrong Value!");
            }
        })).onErrorReturnItem("Default")
                .subscribe(System.out::println);
    }

    @Test
    public void Test5(){
        Observable.just("a")
                .doOnSubscribe(x->System.out.println("On Subscribe"))
                .doOnTerminate(()->System.out.println("On Terminated"))
                .doFinally(()->System.out.println("DoFinally"))
                .doOnComplete(()->System.out.println("doOnComplete"))
                .doOnError(x->System.out.println("doOnError"))
                .subscribe(System.out::println);
    }

    @Test
    public void Test6(){
        Observable.range(1,5)
                .map(x->(x+10)/(x-5))
                .retryWhen(e->e.zipWith(Observable.range(1,2),(x,y)->y)
                        .flatMap(r->Observable.timer(500*r,TimeUnit.MILLISECONDS)))
                .subscribe(System.out::println);
    }
}
