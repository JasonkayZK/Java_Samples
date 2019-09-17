package annotation.chapter4.javaDefalut.deprecated;

public class DeprecatedDemo {

    @Deprecated(since = "s", forRemoval = true)
    public static void say() {
        System.out.println("Hello!");
    }

    public static void speak() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        DeprecatedDemo.say();
        DeprecatedDemo.speak();
    }
}
