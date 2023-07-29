package be.tsapasMi33.exercises.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    private static Random random = new Random();
    public static void main(String[] args) {
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        printWords.accept("Let's split this up into an array");
        printWordsLambda.accept("Let's split this up into an array");

        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };

        printWordsForEach.accept("Let's split this up into an array");

        Consumer<String> printWordsConcise = sentence -> Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));

        printWordsConcise.accept("Let's split this up into an array");


        System.out.println("-".repeat(20));

        Function<String,String> everySecondCharFunction = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        UnaryOperator<String> everySecondCharUnary = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondCharUnary.apply("1234567890"));

        System.out.println(everySecondChar(everySecondCharUnary, "1234567890"));

        System.out.println("-".repeat(20));

        Supplier<String> iLoveJava = () -> "I love Java";

        String result = iLoveJava.get();
        System.out.println(result);

        System.out.println("-".repeat(20));


        String[] names = {"Anna", "Bob", "Carole", "David", "Ed", "Fred", "Gary"};

        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("--> Transform to uppercase");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'Z') + ".");
        System.out.println("--> Add random middle initial");
        System.out.println(Arrays.toString(names));

        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        System.out.println("--> Add reversed name as last name");
        Arrays.asList(names).forEach(s -> System.out.println(s));

        System.out.println("--> Remove names where first = last");

        List<String> newList = new ArrayList<>(List.of(names));
        newList.removeIf(s -> s.substring(0,s.indexOf(" ")).equals(s.substring(s.lastIndexOf(" ") + 1)));

        newList.forEach(s -> System.out.println(s));
    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String everySecondChar(UnaryOperator<String> lambda, String source) {
        return lambda.apply(source);
    }

    public static String everySecondChar(Function<String,String> lambda, String source) {
        return lambda.apply(source);
    }

    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    public static String getReversedName(String name) {
        return new StringBuilder(name).reverse().toString();
    }
}
