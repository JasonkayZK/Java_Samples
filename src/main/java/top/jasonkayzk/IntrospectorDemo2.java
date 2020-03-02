package top.jasonkayzk;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import top.jasonkayzk.entity.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过commons-beanutils操作
 *
 * @author zk
 */
public class IntrospectorDemo2 {

    public static void test1() throws Exception {
        Person p = new Person();
        BeanUtils.setProperty(p, "name", "jasonkay");
        // jasonkay
        System.out.println(p.getName());
    }

    public static void test2() throws Exception {
        Person p = new Person();
        // 模拟用户提交的表单
        String name = "jasonkay";
        String password = "123";
        String age = "23";
        String birthday = "1996-07-27";

        // 给BeanUtils注册一个日期转换器
        registDateConverter();

        // 封装到p对象中
        BeanUtils.setProperty(p, "name", name);
        BeanUtils.setProperty(p, "password", password);
        // 自动将数据转换为基本类型
        BeanUtils.setProperty(p, "age", age);
        // 通过自定义Converter转换
        BeanUtils.setProperty(p, "birthday", birthday);

        // jasonkay
        // 123
        // 23
        // Sat Jul 27 00:00:00 CST 1996
        System.out.println(p.getName());
        System.out.println(p.getPassword());
        System.out.println(p.getAge());
        System.out.println(p.getBirthday());
    }

    public static void test3() throws Exception {
        Map<String, String> map = new HashMap<>(16);
        map.put("name","jasonkay");
        map.put("password","123");
        map.put("age","23");
        map.put("birthday","1996-07-27");

        // 给BeanUtils注册一个日期转换器
        registDateConverter();

        Person bean = new Person();
        // 用map集合中的值填充bean的属性
        BeanUtils.populate(bean, map);

        // jasonkay
        // 123
        // 23
        // Sat Jul 27 00:00:00 CST 1996
        System.out.println(bean.getName());
        System.out.println(bean.getPassword());
        System.out.println(bean.getAge());
        System.out.println(bean.getBirthday());
    }

    private static void registDateConverter() {
        ConvertUtils.register(new Converter() {
            @Override
            public <T> T convert(Class<T> aClass, Object value) {
                if (value == null) {
                    return null;
                }
                if (!(value instanceof String)) {
                    throw new ConversionException("只支持String类型的转换！");
                }
                String str = (String) value;
                if ("".equals(str.trim())) {
                    return null;
                }

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return (T) df.parse(str);
                } catch (ParseException e) {
                    // 异常链不能断
                    throw new RuntimeException(e);
                }
            }
        }, Date.class);
    }

    public static void main(String[] args) throws Exception {
        test1();
        test2();
        test3();
    }

}
