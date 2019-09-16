package lambda.lesson2.helloLambda.generateLambda;

import lambda.pojo.Hero;
import lambda.service.HeroChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateLambdaDemo {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用匿名类的方式，筛选出 hp>100 && damange<50的英雄");

        // 1. 匿名内部类正常写法
        HeroChecker c1 = new HeroChecker() {
            @Override
            public boolean test(Hero h) {
                return (h.hp > 100 && h.damage < 50);
            }
        };

        // 2. 把new HeroChcekcer，方法名，方法返回类型信息去掉
        // 只保留方法参数和方法体
        // 参数和方法体之间加上符号 ->
        HeroChecker c2 = (Hero h) -> {
            return (h.hp > 100 && h.damage < 50);
        };

        // 3. 把return和{}去掉
        HeroChecker c3 = (Hero h) -> h.hp > 100 && h.damage < 50;

        // 4. 把参数类型和圆括号去掉
        HeroChecker c4 = h -> h.hp > 100 && h.damage < 50;

        // 直接把表达式传递进去
        filter(heros, h -> h.hp > 100 && h.damage < 50);
    }

    private static void filter(List<Hero> heroes, HeroChecker checker) {
        for (Hero hero : heroes) {
            if (checker.test(hero)) {
                System.out.println(hero);
            }
        }
    }
}
