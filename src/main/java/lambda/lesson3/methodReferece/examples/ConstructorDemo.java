package lambda.lesson3.methodReferece.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * 通过Lambda表达式引用构造器方法创建LinkedList, 与ArrayList
 *
 * 并比较头插入性能
 *
 */
public class ConstructorDemo {

    public static void main(String[] args) {

        initList(ArrayList::new, "ArrayList");
        initList(LinkedList::new, "LinkedList");
    }

    private static void initList(Supplier<List> s , String type) {
        List l = s.get();
        int total = 1000 * 100;
        final int number = 5;
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            l.add(0, number);
        }
        long end = System.currentTimeMillis();

        System.out.printf("在%s 最前面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
    }

}
