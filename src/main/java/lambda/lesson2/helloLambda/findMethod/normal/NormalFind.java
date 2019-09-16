package lambda.lesson2.helloLambda.findMethod.normal;

import lambda.pojo.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NormalFind {

    public static void main(String[] args) {
        Random random = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero("Hero " + i, random.nextInt(1000), random.nextInt(100)));
        }
        System.out.println("初始化后的集合: ");
        System.out.println(heroes);

        System.out.println("筛选出 hp>100 && damange<50的英雄");
        filter(heroes);
    }

    private static void filter(List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero.hp > 100 && hero.damage < 50) {
                System.out.println(hero);
            }
        }
    }
}
