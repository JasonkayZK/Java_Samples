package annotation.chapter5.getAnnotation.getOtherAnnotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodTest {
    String msg() default "hello";

    int id() default 0;
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ParamTest {
    String value() default "";
}


public class GetOtherAnnotationDemo {

    @ParamTest(value = "2")
    private int a;

    @MethodTest
    @SuppressWarnings("deprecated")
    public void test1() {}

    public static void main(String[] args) {
        try {
            // 1. 获取成员变量上的注解
            Field a = GetOtherAnnotationDemo.class.getDeclaredField("a");
            ParamTest paramTest = a.getAnnotation(ParamTest.class);
            if (paramTest != null) {
                System.out.println("Param value: " + paramTest.value());
            }

            // 2. 获取方法上的注解
            Method method = GetOtherAnnotationDemo.class.getDeclaredMethod("test1");
            if (method != null) {
                // 获取方法中的注解
                Annotation[] ans = method.getAnnotations();
                for (Annotation an : ans) {
                    System.out.println("method test1 annotation:" + an.annotationType().getSimpleName());
                }
            }

        } catch (NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
