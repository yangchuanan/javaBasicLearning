package basic.test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-05 22:08
 * @Descripe 循环中进行debug，断点处可以修改条件
 * @Version 0.0.1
 */
public class DebugTest {

    public static void main(String[] args) {

        // 当sum值等于10时断点停住
        // 鼠标右键键入输入条件
        int sum=0;
        for (int i = 0; i < 1000; i++) {
            sum+=i;
        }
    }
}
