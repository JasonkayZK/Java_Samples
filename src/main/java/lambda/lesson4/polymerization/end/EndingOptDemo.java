package lambda.lesson4.polymerization.end;

import lambda.pojo.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EndingOptDemo {

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
                .s





    }
}
