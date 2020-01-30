package reflection.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author Chuanan YANG
 * @DateTime 2019-09-22 11:08
 * @Descripe reflection api learning
 * @Version 0.0.1
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException, NoSuchFieldException {

        // 生成一个User对象，一个Class对象
        User user = new User();

        // 获取class的三种方法
        Class<User> userClassOne = User.class;
        Class userClassTwo = user.getClass();
        Class userClassThree = Class.forName("reflection.test.User");
        System.out.println(userClassOne == userClassTwo);
        System.out.println("args = [" + userClassTwo == userClassThree + "]");

        // 判断user是否为User类的对象实例
        userClassOne.isInstance(user);

        // 通过反射生成对象有两种方式
        // 直接调用newInstance方法
        User userOne = userClassOne.newInstance();
        // 获取构造方法，通过构造方法构造实例
        Constructor<User> constructor = userClassOne.getConstructor(User.class);
        User userTwo = constructor.newInstance();

        // 通过反射获取构造方法并使用
        // 获取所有public的构造方法
        Constructor[] constructors = userClassOne.getConstructors();
        // 获取所有访问级别的构造方法
        Constructor[] constructors1 = userClassOne.getDeclaredConstructors();
        // 根据参数类型获取指定的构造方法
        Constructor constructor1 = userClassOne.getConstructor(String.class,String.class);
        Constructor constructor2 = userClassOne.getDeclaredConstructor(String.class,String.class);

        // 通过反射获取属性
        Field field = userClassOne.getField("name");
        field.setAccessible(true);
        field.getName();
        field.set(user,"Chuanan");
        Field field1 = userClassOne.getDeclaredField("name");
        Field[] fields = userClassOne.getFields();
        Field[] fields1 = userClassOne.getDeclaredFields();

        // 获取成员方法并调用
        Method[] methods = userClassOne.getMethods();
        Method[] methods1 = userClassOne.getDeclaredMethods();
        Method method = userClassOne.getMethod("showPrivate", String.class);
        Method method1 = userClassOne.getMethod("showPublic");
        method.invoke(user,"hello Chuanan");
        method1.invoke(user);

    }
}
