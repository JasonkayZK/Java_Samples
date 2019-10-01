package string.intern;

public class InternDemo {

    public static void main(String[] args) {
        String s = new String("1") + new String("1");
        System.out.println(s == s.intern());
    }
}
