package basic.test;

/**
 * @Author Chuanan YANG
 * @DateTime 2020-04-06 18:39
 * @Descripe
 * @Version 0.0.1
 */
public class Dog {

    String name;

    Dog(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getObjectAddress() {
        return super.toString();
    }
}
