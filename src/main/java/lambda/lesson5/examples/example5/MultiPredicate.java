package lambda.lesson5.examples.example5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MultiPredicate {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        Predicate<String> startWithJ = n -> n.startsWith("J");
        Predicate<String> fourLetterLonger = n -> n.length() >= 4;

        languages.stream()
                .filter(startWithJ.and(fourLetterLonger))
                .forEach(System.out::println);
    }
}
