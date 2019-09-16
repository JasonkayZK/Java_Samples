package lambda.lesson0.functional;

import java.util.function.Function;

public class FunctionalDemo {

    public static void main(String[] args) {
        invokeSayHello(() -> System.out.println("Hello"));
    }

    private static void invokeSayHello(FunctionalService service) {
        service.sayHello();
    }

}
