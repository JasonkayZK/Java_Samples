package reflection.chapter5.param;

import reflection.pojo.Hero;

import java.lang.reflect.Field;

public class GetAndModifyParamDemo {

    public static void main(String[] args) {
        Hero hero = new Hero();

        try {
            // 获取hero的叫做name字段的属性
            Field field = hero.getClass().getDeclaredField("name");
            // 修改属性
            field.set(hero, "teemo");

            System.out.println(hero);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}
