package basic.test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 18:38
 * @Descripe java 参数传递
 * @Version 0.0.1
 */
public class ParamsTest {

    //Java 的参数是以值传递的形式传入方法中，而不是引用传递。
    //以下代码中 Dog dog 的 dog 是一个指针，存储的是对象的地址。
    // 在将一个参数传入一个方法时，本质上是将对象的地址以值的方式传递到形参中。
    public static void main(String[] args) {
        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress());
        func(dog);
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }

    private static void func(Dog dog) {
        System.out.println(dog.getObjectAddress());
        dog = new Dog("B");
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }
}
