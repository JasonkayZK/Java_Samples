package lambda.lesson5.examples.example4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, s -> s.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, s -> s.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, s -> true);

        System.out.println("Print no language : ");
        filter(languages, s -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, s -> s.length() > 4);
    }

    public static void filter(List<String> names, Predicate<String> predicate) {
        names.stream()
                .filter(name -> predicate.test(name))
                .forEach(System.out::println);
    }
}
