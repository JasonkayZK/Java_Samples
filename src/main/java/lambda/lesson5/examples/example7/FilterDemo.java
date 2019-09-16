package lambda.lesson5.examples.example7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList(new String[] {
                "abc", "bcd", "", "defg", "jk"
        });

        List<String> filtered = strList.stream()
                .filter(x -> x.length() > 2)
                .collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);

    }
}
