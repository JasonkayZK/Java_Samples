package annotation.chapter3.attribute.defaultValue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DefaultValueDemo {

    public int id() default -1;

    public String msg() default "Hi";

}

@DefaultValueDemo
class Test {}