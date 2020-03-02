package top.jasonkayzk;

import top.jasonkayzk.entity.Person;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * 直接使用JDK自带API操作Bean
 *
 * @author zk
 */
public class IntrospectorDemo1 {

    /**
     * 得到bean的所有属性
     */
    public static void getAllAttribute() throws Exception {
        // 不自省从父类继承的属性
        BeanInfo info = Introspector.getBeanInfo(Person.class, Object.class);
        // 取得属性描述器
        PropertyDescriptor[] pds = info.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            System.out.println(pd.getName());
        }
    }

    /**
     * 操纵bean的指定属性
     */
    public static void manipulateAttributeTest() throws Exception {
        Person p = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);

        // 得到属性的写方法，为属性赋值
        // setAge
        Method method = pd.getWriteMethod();
        method.invoke(p, 24);

        // 获取属性的值
        // getAge()
        method = pd.getReadMethod();
        System.out.println(method.invoke(p));
    }

    /**
     * 获取当前操作的属性的类型
     */
    public static void readAttributeTypeTest() throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        System.out.println(pd.getPropertyType());
    }

    public static void main(String[] args) throws Exception {
        // age
        // birthday
        // gender
        // name
        // password
        getAllAttribute();

        // 24
        manipulateAttributeTest();

        // int
        readAttributeTypeTest();
    }
}
