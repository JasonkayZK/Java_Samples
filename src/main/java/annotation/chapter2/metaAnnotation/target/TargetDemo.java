package annotation.chapter2.metaAnnotation.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
public @interface TargetDemo {
}
