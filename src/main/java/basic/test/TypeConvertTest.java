package basic.test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 18:48
 * @Descripe
 * @Version 0.0.1
 */
public class TypeConvertTest {

    public static void main(String[] args) {
//        float f=1.1;

        float f = 1.1f;

        short s1 = 1;

//        s1 = s1 + 1;

        // 这两个运算符可以实现向下转型
        s1 += 1;
        s1++;
    }
}
