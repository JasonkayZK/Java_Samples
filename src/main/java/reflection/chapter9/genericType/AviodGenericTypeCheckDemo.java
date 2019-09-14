package reflection.chapter9.genericType;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AviodGenericTypeCheckDemo {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("this");
        list.add("is");

        // List.add(5) 编译报错!

        /* 越过泛型检查! */

        // 获取ArrayList的Class对象, 反射调用add()
        Class listClazz = list.getClass();

        // 获取add()方法
        Method method = listClazz.getMethod("add", Object.class);

        method.invoke(list, 5);

        for (Object obj : list) {
            System.out.println(obj);
        }

    }
}
