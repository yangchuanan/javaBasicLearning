package basic.test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 18:24
 * @Descripe String StringBuilder StringBuffer
 * @Version 0.0.1
 */
public class StringTest {
    public static void main(String[] args) {
        // 不可变对象 字面量会被放入常量池中
        String hello = "hello";
        // 线程安全，使用synchronized实现
        StringBuffer buffer = new StringBuffer();
        // 线程不安全
        StringBuilder builder = new StringBuilder();

        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);

        //当一个字符串调用 intern() 方法时，
        // 如果 String Pool 中已经存在一个字符串和该字符串值相等
        // （使用 equals() 方法进行确定），
        // 那么就会返回 String Pool 中字符串的引用；
        // 否则，就会在 String Pool 中添加一个新的字符串，
        // 并返回这个新字符串的引用。
        String s3 = s1.intern();
        String s4 = "aaa";
        String s5 = s1.intern();
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);

        // java 7之后常量池在堆中

        // 指向同一个value数组
        String s6 = new String(s3);
    }
}
