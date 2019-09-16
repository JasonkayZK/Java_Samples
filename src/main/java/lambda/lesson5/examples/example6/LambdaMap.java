package lambda.lesson5.examples.example6;

import java.util.Arrays;
import java.util.List;

public class LambdaMap {

    public static void main(String[] args) {
        // 使用lambda表达式为每个订单加上12%的税
        List<Integer>  costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream()
                .map(cost -> cost + 0.12 * cost)
                .forEach(System.out::println);

    }

}
