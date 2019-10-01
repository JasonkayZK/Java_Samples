package string.memoryStructure;

public class StringCompare {

    public static void main(String[] args) {
        // 这里的abc是显式字符串常量，存在于常量池里
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        // 这里的abc是常量，存在于常量池，而new String（“abc”）是对象存在于堆中!!!
        String s3 = new String("abc");
        System.out.println(s1 == s3);
    }
}
