package reflection.chapter3.getClass;

import reflection.pojo.Hero;

public class GetClassDemo {

    public static void main(String[] args) {
        String className = "reflection.pojo.Hero";

        try {
            Class clazz1 = Class.forName(className);
            Class clazz2 = Hero.class;
            Class clazz3 = new Hero().getClass();

            System.out.println(clazz1 == clazz2);
            System.out.println(clazz2 == clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
