package annotation.chapter2.metaAnnotation.repeatable;

import java.lang.annotation.Repeatable;

public @interface Persons {
    Person[] value();
}

@Repeatable(Persons.class)
@interface Person {
    String role() default "";
}

@Person(role = "artist")
@Person(role = "coder")
@Person(role = "PM")
class SuperMan {}