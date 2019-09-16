package lambda.lesson2.helloLambda.examples;

import lambda.pojo.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HeroCompareDemo {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用匿名类的方式, 按照伤害对英雄排序");

        Collections.sort(heros, (h1, h2) -> h1.damage - h2.damage);
        System.out.println("按照伤害排序后的集合");
        System.out.println(heros);
    }
}
