package reflection.chapter8.settings;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectSettingsDemo {

    public static void main(String[] args) {
        Properties properties;
        InputStream in = null;
        try {
            properties = new Properties();
            in = ReflectSettingsDemo.class.getClassLoader().getResourceAsStream("reflection.properties");
            properties.load(in);

            String className = properties.getProperty("class");
            String methodName = properties.getProperty("method");

            // 根据配置类名寻找类对象
            Class clazz = Class.forName(className);

            // 根据方法名, 寻找方法对象
            Method method = clazz.getMethod(methodName);

            // 获取默认无参构造器
            Constructor constructor = clazz.getConstructor();

            // 根据构造器, 实例化对象, 并调用指定方法!
            method.invoke(constructor.newInstance());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
