package annotation.chapter3.attribute.singleAttr;

public @interface SingleAttrDemo {
    String value();
}

@SingleAttrDemo("Hi")
class Test {}
