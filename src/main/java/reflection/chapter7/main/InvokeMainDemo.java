package reflection.chapter7.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMainDemo {

    public static void main(String[] args) {
        try {
            // 1. 获取Class对象
            Class clazz = Class.forName("reflection.pojo.Hero");

            // 2. 获取main方法
            Method mainMethod = clazz.getMethod("main", String[].class);

            // 3. 调用main方法

            /*
                1. 错误调用
                mainMethod.invoke(null, new String[] {"a", "b", "c"});

                首先,
                    第一个参数: 对象类型, 当方法是静态方法时, 可以为null!
                    第二个参数: String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数

                上述方法会报错:
                    这里拆的时候会将 new String[]{"a","b","c"} 拆成3个对象!!!
                    所以需要将它强转!!!
             */


            mainMethod.invoke(null, (Object)new String[] {"a", "b", "c"}); // 方法一

            mainMethod.invoke(null, new Object[] {new String[] {"a", "b", "c"}}); // 方法二

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
