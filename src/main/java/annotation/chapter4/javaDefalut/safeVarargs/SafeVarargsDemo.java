package annotation.chapter4.javaDefalut.safeVarargs;

import java.util.Arrays;
import java.util.List;

public class SafeVarargsDemo {

    @SafeVarargs
    public static void notSafe(List<String>... stringLists) {
        Object[] arr = stringLists;
        List<Integer> tempList = Arrays.asList(42);
        arr[0] = tempList; // Semantically invalid, but compiles without warnings
        String s= stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

    public static void main(String[] args) {
        SafeVarargsDemo.notSafe(Arrays.asList(args));
    }
}
