package rxjava.test;


import io.reactivex.Observable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
            x.subscribe(System.out::println);
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

}
