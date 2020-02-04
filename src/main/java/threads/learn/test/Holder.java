package threads.learn.test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-02-01 10:32
 * @Descripe
 * @Version 0.0.1
 */
public class Holder {
    private int n;
    public Holder(int n){
        this.n=n;
    }

    public void assertSanity(){
        if(n!=n){
            throw new AssertionError("This statement is false!");
        }
    }
}
