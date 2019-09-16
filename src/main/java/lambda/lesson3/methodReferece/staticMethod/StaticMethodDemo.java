package lambda.lesson3.methodReferece.staticMethod;

import lambda.pojo.Hero;
import lambda.service.HeroChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaticMethodDemo {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        System.out.println("在Lambda表达式中使用静态方法");
        filter(heros, h -> h.hp>100 && h.damage<50);

        System.out.println("直接引用静态方法");
        filter(heros, StaticMethodDemo::testHero);
    }

    public static boolean testHero(Hero h) {
        return h.hp>100 && h.damage<50;
    }

    public static void filter(List<Hero> heroes, HeroChecker checker) {
        for (Hero hero : heroes) {
            if (checker.test(hero)) {
                System.out.println(hero);
            }
        }
    }

}
