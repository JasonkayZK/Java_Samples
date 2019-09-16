package lambda.lesson4.polymerization.examples;

import lambda.pojo.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FindThirdHero {

    public static void main(String[] args) {
        Random random = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero-" + i, random.nextInt(1000), random.nextInt(100)));
        }
        System.out.println("源数据");
        System.out.println(heroes);

        System.out.println("传统方法hp第三高的英雄");
        Collections.sort(heroes, (h1, h2) -> h2.hp - h1.hp >= 0 ? 1: -1);
        System.out.println("第三高: " + heroes.get(2));

        System.out.println("Lambda表达式");
        Hero min = heroes.stream()
                .sorted((h1, h2) -> h2.hp - h1.hp >= 0 ? 1: -1)
                .skip(2)
                .findFirst()
                .get();
        System.out.println("第三高: " + min);

    }
}
