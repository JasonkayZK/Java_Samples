package reflection.chapter4.constructObject;

import reflection.pojo.Hero;

import java.lang.reflect.Constructor;

public class DefaultConstructor {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("reflection.pojo.Hero");
            Constructor constructor = clazz.getConstructor();

            Hero hero = (Hero) constructor.newInstance();
            System.out.println(hero);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
