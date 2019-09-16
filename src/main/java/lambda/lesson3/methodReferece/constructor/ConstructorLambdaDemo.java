package lambda.lesson3.methodReferece.constructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ConstructorLambdaDemo {

    public static void main(String[] args) {
        // 1. 匿名内部类
        List list1 = getList(new Supplier<List>() {
            @Override
            public List get() {
                return new ArrayList();
            }
        });

        // 2. Lambda表达式
        List list2 = getList(() -> new ArrayList());

        // 3. 引用构造器
        List list3 = getList(ArrayList::new);

        System.out.println(list1 == list2);
        System.out.println(list2 == list3);
    }

    public static List getList(Supplier<List> s) {
        return s.get();
    }

}
