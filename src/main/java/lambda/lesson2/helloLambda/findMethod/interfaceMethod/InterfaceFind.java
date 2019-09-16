package lambda.lesson2.helloLambda.findMethod.interfaceMethod;

import lambda.pojo.Hero;
import lambda.service.HeroChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterfaceFind {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用匿名类的方式，筛选出 hp>100 && damange<50的英雄");

        filter(heros, new HeroChecker() {
            @Override
            public boolean test(Hero hero) {
                return (hero.hp > 100 && hero.damage < 50);
            }
        });
    }

    private static void filter(List<Hero> heros, HeroChecker heroChecker) {
        for (Hero hero : heros) {
            if (heroChecker.test(hero)) {
                System.out.println(hero);
            }
        }
    }


}
