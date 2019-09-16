package lambda.lesson4.polymerization;

import lambda.pojo.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TraverseDemo {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        System.out.println("查询条件：hp>100 && damage<50");
        System.out.println("通过传统操作方式找出满足条件的数据：");
        for(Hero hero : heros) {
            if (hero.hp > 100 && hero.damage < 50) {
                System.out.println(hero.name);
            }
        }

        System.out.println("通过聚合操作方式找出满足条件的数据：");
        heros
                .stream()
                .filter(h -> h.hp > 100 && h.damage < 50)
                .forEach(h -> System.out.println(h.name));


    }

}
