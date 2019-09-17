package annotation.chapter5.getAnnotation.getClassAnnotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotation {

    public int id() default 1;

    public String name() default "test";
}

@TestAnnotation
public class GetClassAnnotaionDemo {

    public static void main(String[] args) {
        // 1. isAnnotationPresent() 方法判断它是否应用了某个注解
        System.out.println(GetClassAnnotaionDemo.class.isAnnotationPresent(TestAnnotation.class));

        // 2. 通过 getAnnotation() 方法来获取 Annotation 对象
        TestAnnotation annotation = GetClassAnnotaionDemo.class.getAnnotation(TestAnnotation.class);
        System.out.println(annotation);

        // 3. 或者是 getAnnotations() 方法
        Annotation[] annotations = GetClassAnnotaionDemo.class.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        // 4. 调用注解的属性方法
        System.out.println("id: " + annotation.id());
        System.out.println("name: " + annotation.name());

    }

}
