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
 * @DateTime 2020-01-30 21:58
 * @Descripe Rxjava
 * @Version 0.0.1
 */
@RunWith(JUnit4.class)
public class RxjavaTest1 {

    @Test
    public void Test0() {
        Observable<String> list = Observable
                .fromArray("aaa", "baa", "ac", "ccc", "ccs");
        list.groupBy(x -> x.substring(0, 1)).subscribe(x -> {
            System.out.println("---" + x.getKey() + "---");
            x.subscribe(System.out::println);;
        });
    }

    @Test
    public void Test1() {
        Observable.range(1, 5)
                .scan((x, sum) -> x + sum)
                .subscribe(System.out::println);
    }

    @Test
    public void Test2(){
        Observable.range(1,5)
                .window(2)
                .flatMap(x->x.scan((y,s)->y+s))
                .subscribe(System.out::println);
    }

    @Test
    public void Test3(){
        TestScheduler scheduler =new TestScheduler();
        Observable.range(1,5)
                .flatMap(x->Observable.just(x).delay(new Random().nextInt(200), TimeUnit.MILLISECONDS,scheduler))
                .debounce(100, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
        scheduler.advanceTimeBy(1,TimeUnit.MINUTES);
    }

    @Test
    public void Test4(){
        Observable<String> list = Observable.fromArray("aaa","baa","ac","ccc","aaa");
        list.distinct().subscribe(System.out::println);
        System.out.println("------------");
        list.distinctUntilChanged().subscribe(System.out::println);
        System.out.println("------------");
        list.elementAt(3).subscribe(System.out::println);
        System.out.println("------------");
        list.filter(x->x.startsWith("a")).subscribe(System.out::println);
        System.out.println("------------");
        list.skip(3).subscribe(System.out::println);
        System.out.println("-------------");
        list.skipLast(3).subscribe(System.out::println);
        System.out.println("------------");
        list.take(3).subscribe(System.out::println);
        System.out.println("------------");
        list.takeLast(3).subscribe(System.out::println);
    }

}
