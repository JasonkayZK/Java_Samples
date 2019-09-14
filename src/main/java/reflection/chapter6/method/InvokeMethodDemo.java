package reflection.chapter6.method;

import reflection.pojo.Hero;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMethodDemo {

    public static void main(String[] args) {
        Hero hero = new Hero();

        Hero heroSet = new Hero();

        try {
            // 获取方法
            Method method = hero.getClass().getMethod("setName", String.class);

            // 对heroSet调用反射方法!
            method.invoke(heroSet, "Garon");
            // 对hero调用常规方法
            hero.setName("Teemo");

            System.out.println("hero: " + hero);
            System.out.println("heroSet: " + heroSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
