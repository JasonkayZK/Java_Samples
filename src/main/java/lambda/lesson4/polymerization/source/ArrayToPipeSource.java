package lambda.lesson4.polymerization.source;

import lambda.pojo.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayToPipeSource {

    public static void main(String[] args) {
        /* 管道源是集合 */
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }

        heros
                .stream()
                .forEach(h -> System.out.println(h.name));

        Hero hs[] = heros.toArray(new Hero[heros.size()]);
        Arrays.stream(hs)
                .forEach(h -> System.out.println(h.name));

    }
}
