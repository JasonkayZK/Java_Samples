package lambda.lesson4.polymerization.middle;

import lambda.pojo.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MiddleOptDemo {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        //制造一个重复数据
        heros.add(heros.get(0));
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);

        System.out.println("满足条件hp>100&&damage<50的数据");
        heros
                .stream()
                .filter(h -> h.hp > 100 && h.damage < 50)
                .forEach(h -> System.out.println(h));

        System.out.println("去除重复的数据，去除标准是看equals");
        heros
                .stream()
                .distinct()
                .forEach(h -> System.out.println(h));

        System.out.println("按照血量排序");
        heros
                .stream()
                .sorted((h1, h2) -> h1.hp - h2.hp >= 0 ? 1 : -1)
                .forEach(hero -> System.out.println(hero));

        System.out.println("保留3个");
        heros
                .stream()
                .limit(3)
                .forEach(h -> System.out.println(h));

        System.out.println("忽略前三个");
        heros
                .stream()
                .skip(3)
                .forEach(h -> System.out.println(h));

        System.out.println("转为double的Stream");
        heros
                .stream()
                .mapToDouble(Hero::getHp)
                .forEach(h -> System.out.println(h));

        System.out.println("转为任意类型的Stream");
        heros
                .stream()
                .map((h) -> h.name + " - " + h.hp + " - " + h.damage)
                .forEach(h -> System.out.println(h));

    }
}
