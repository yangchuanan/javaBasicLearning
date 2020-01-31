package rxjava.test;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-01-31 16:23
 * @Descripe Thread
 * @Version 0.0.1
 */
@RunWith(JUnit4.class)
public class RxjavaTest3 {

    @Test
    public void Test0(){
        Observable.range(1,5)
                .map(x->{
                    System.out.println("[Map] Thread"+Thread.currentThread().getName());
                    return x+10;
                })
                .observeOn(Schedulers.computation())
                .subscribe(y->System.out.println("[Subscribe] Thread"+Thread.currentThread().getName()+"-"+y));
    }

    @Test
    public void Test1(){
        Observable.range(1,5)
                .map(x->{
                    System.out.println("[Map] Thread"+Thread.currentThread().getName());
                    return x+10;
                })
                .subscribeOn(Schedulers.computation())
                .subscribe(y->System.out.println("[Subscribe] Thread"+Thread.currentThread().getName()+"-"+y));
    }
}
