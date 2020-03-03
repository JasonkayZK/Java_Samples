package reflection.chapter4.constructObject;


import reflection.pojo.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SelectConstructor {

    /**
     *
     * 通过Class对象可以获取某个类中的: 构造方法, 成员变量, 成员方法;
     *
     * 并访问成员.
     *
     * 1.获取构造方法：
     * 		1).批量的方法：
     * 			public Constructor[] getConstructors()：所有"公有的"构造方法
     public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)

     * 		2).获取单个的方法，并调用：
     * 			public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
     * 			public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
     *
     * 2.创建对象
     * 		Constructor对象调用newInstance(Object... initargs)
     *
     */
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException {

        // 1. 获取Class对象
        Class clazz = Class.forName("reflection.pojo.Hero");

        // 2. 获取构造方法
        System.out.println("----公有构造方法----");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("----所有的构造方法(包括：私有、受保护、默认、公有)----");
        constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("----获取公有、无参的构造方法----");
        // 1> 因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型!!!!!
        // 2> 返回的是描述这个无参构造函数的类对象.
        var cons = clazz.getConstructor(null);
        System.out.println("consturctor = " + cons);
        // 调用方法
        Object object = cons.newInstance();
        System.out.println("Object: " + (Hero)object);


        System.out.println("----获取私有构造方法，并调用----");
        cons = clazz.getDeclaredConstructor(float.class);
        System.out.println("consturctor = " + cons);
        // 调用方法
        cons.setAccessible(true);
        object = cons.newInstance(100);
        System.out.println("Object: " + (Hero)object);

    }

}
