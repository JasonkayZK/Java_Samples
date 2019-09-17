package annotation.chapter2.metaAnnotation.inherited;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedDemo {
}

@InheritedDemo
class A {}

class B extends A {}
