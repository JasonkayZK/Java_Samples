package lambda.lesson5.examples.example10;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class MaxMinAveSumDemo {

    public static void main(String[] args) {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics statistics = primes.stream()
                .mapToInt(x -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + statistics.getMax());
        System.out.println("Lowest prime number in List : " + statistics.getMin());
        System.out.println("Sum of all prime numbers : " + statistics.getSum());
        System.out.println("Average of all prime numbers : " + statistics.getAverage());
    }
}
