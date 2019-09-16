package lambda.lesson3.methodReferece.collection;

import lambda.pojo.Hero;
import lambda.service.HeroChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LambdaInCollection {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        System.out.println("Lambda表达式：");
        filter(heros, h -> h.hp>100 && h.damage<50);

        System.out.println("Lambda表达式中调用容器中的对象的matched方法：");
        filter(heros, h -> h.matched());

        System.out.println("引用容器中对象的方法 之过滤结果：");
        filter(heros, Hero::matched);



    }

    public static void filter(List<Hero> heroes, HeroChecker checker) {
        for (Hero h : heroes) {
            if (checker.test(h)) {
                System.out.println(h);
            }
        }
    }
}
