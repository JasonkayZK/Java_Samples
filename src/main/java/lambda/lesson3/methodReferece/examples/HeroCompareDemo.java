package lambda.lesson3.methodReferece.examples;

import lambda.pojo.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * 使用静态方法引用完成英雄伤害比较
 *
 * 使用容器中对象的方法完成排序
 *
 */
public class HeroCompareDemo {

    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        System.out.println("按照伤害排序后的集合：");
        Collections.sort(heros, HeroCompareDemo::compareHero);
        System.out.println(heros);

        heros.clear();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);

        Collections.sort(heros, Hero::compareTo);
        System.out.println("按照伤害排序后的集合：");
        System.out.println(heros);
    }

    public static int compareHero(Hero h1, Hero h2) {
        return h1.damage - h2.damage;
    }

}
