package lambda.lesson4.polymerization.end;

import lambda.pojo.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EndingOptDemo {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }

        System.out.println("遍历集合中的每个数据");
        heros.stream()
                .forEach(h -> System.out.println(h));

        System.out.println("返回一个数组");
        Object[] bs = heros.stream().toArray();
        System.out.println(Arrays.toString(bs));

        System.out.println("返回伤害最高的那个英雄");
        Hero min = heros.stream()
                .max((h1, h2) -> h1.damage - h2.damage)
                .get();
        System.out.println(min);

        System.out.println("返回伤害最低的那个英雄");
        Hero max = heros.stream()
                .min((h1, h2) -> h1.damage - h2.damage)
                .get();
        System.out.println(max);

        System.out.println("流中数据的总数");
        long count = heros.stream()
                .count();
        System.out.println(count);

        System.out.println("第一个英雄");
        Hero first = heros.stream()
                .findFirst()
                .get();
        System.out.println(first);

    }
}
