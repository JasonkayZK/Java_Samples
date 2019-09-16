package lambda.lesson5.examples.example9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

        List<Integer> distinct = numbers.stream()
                .map(i -> i*i)
                .distinct()
                .collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
}
