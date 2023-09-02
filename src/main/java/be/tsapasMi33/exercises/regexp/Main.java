package be.tsapasMi33.exercises.regexp;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String testString = "Hello, World!";
        boolean matches = testString.matches("Hello, World!"); // matches 100%
        System.out.println(matches + testString);

        System.out.println("-".repeat(50));


        String regExp = "^[A-Z].*\\."; //starts with capital letter, ends with period
        System.out.println(regExp);

        for (String s : List.of("The bike is red.",
                "I am a new student.",
                "hello world.",
                "How are you?")) {
            boolean matched = s.matches(regExp);
            System.out.println(matched + ": " + s);
        }
        System.out.println("-".repeat(50));

        regExp = "^[A-Z].*\\p{Punct}$"; //starts with capital letter, ends with any punctuation mark
        System.out.println(regExp);

        for (String s : List.of("The bike is red, and has flat tires.",
                "I love being a new L.P.A. student!",
                "Hello, friends and family: Welcome!",
                "How are you, Mary?")) {
            boolean matched = s.matches(regExp);
            System.out.println(matched + ": " + s);
        }

        System.out.println("-".repeat(50));

        testString = "I like B.M.W. motorcycles.";
        Pattern first = Pattern.compile("[A-Z].*?[.]");
        Matcher matcher = first.matcher(testString);
        System.out.println(matcher.matches() + ": " + testString); // tests the whole string


        System.out.println("string length: " + testString.length());
        System.out.println("Matched ending index: " + matcher.end());


        System.out.println(matcher.lookingAt() + ": " + testString); // stops when result is found
        System.out.println("Matched ending index: " + matcher.end());
        System.out.println("Matched on : " + testString.substring(0, matcher.end()));


        System.out.println("-".repeat(50));


        matcher.reset(); // otherwise continues where last call left off
        System.out.println(matcher.find() + ": " + testString); // stops when result is found
        System.out.println("Matched ending index: " + matcher.end());
        System.out.println("Matched on : " + testString.substring(matcher.start(), matcher.end()));

        System.out.println("Matched on : " + matcher.group()); // returns the result of the previous match

        System.out.println("-".repeat(50));

        String htmlSnippet = """
                <H1>My heading</H1>
                <h2>Sub-heading</h2>
                <p>This is a paragraph about something.</p>
                <p>This is another paragraph about something</p>
                <h3>Summary</h3>
                """;

        Pattern htmlPattern = Pattern.compile("<[Hh]\\d>.*</[hH]\\d>");
        Matcher htmlMatcher = htmlPattern.matcher(htmlSnippet);

        while (htmlMatcher.find()) {
            System.out.println("group: " + htmlMatcher.group());
        }

        System.out.println("-".repeat(50));

        htmlPattern = Pattern.compile("<[Hh]\\d>(.*)</[hH]\\d>"); // () to capture
        htmlMatcher = htmlPattern.matcher(htmlSnippet);

        while (htmlMatcher.find()) {
//            System.out.println("group: " + htmlMatcher.group());
//            System.out.println("group0: " + htmlMatcher.group(0)); // returns whole match
            System.out.println("group1: " + htmlMatcher.group(1)); // returns only captured group
        }

        System.out.println("-".repeat(50));

        htmlPattern = Pattern.compile("<[Hh](\\d)>(.*)</[hH]\\d>"); // () to capture
        htmlMatcher = htmlPattern.matcher(htmlSnippet);

        while (htmlMatcher.find()) {
            System.out.println("group1: " + htmlMatcher.group(1));
            System.out.println("group2: " + htmlMatcher.group(2));
        }

        System.out.println("-".repeat(50));

        htmlPattern = Pattern.compile("<[Hh](?<level>\\d)>(?<content>.*)</[hH]\\d>"); // () to capture
        htmlMatcher = htmlPattern.matcher(htmlSnippet);

        while (htmlMatcher.find()) {
            System.out.println("level: " + htmlMatcher.group("level"));
            System.out.println("content: " + htmlMatcher.group("content"));
        }

//        System.out.println("-".repeat(50));
//
//        htmlMatcher.reset();
//        htmlMatcher.results().forEach(matchResult -> System.out.println(matchResult.group(1) + " " + matchResult.group(2)));
//
//        System.out.println("-".repeat(50));
//
//        htmlMatcher.reset();
//        String updatedSnippet = htmlMatcher.replaceFirst("First Header");
//
//        System.out.println(updatedSnippet);
//        System.out.println(htmlMatcher.start() + " : " + htmlMatcher.end());
//        System.out.println(htmlMatcher.group(2));

        System.out.println("-".repeat(50));

        htmlMatcher.reset();
        htmlMatcher.results().forEach(matchResult -> System.out.println(matchResult.group(1) + " " + matchResult.group(2)));

        System.out.println("-".repeat(50));

        htmlMatcher.reset();
        String updatedSnippet = htmlMatcher.replaceFirst(mr -> "<em>" + mr.group(2) + "</em>");

        System.out.println(updatedSnippet);
        System.out.println(htmlMatcher.start() + " : " + htmlMatcher.end());
        System.out.println(htmlMatcher.group(2));

        System.out.println("-".repeat(50));

        htmlMatcher.usePattern(Pattern.compile("<([hH]\\d)>(.*)</\\1>")); // \\1 back reference to first group in regexp

        htmlMatcher.reset();
        System.out.println("Using Back Reference: \n" + htmlMatcher.replaceFirst("<em>$2</em>"));

        System.out.println("-".repeat(50));

        String replacedHtml = htmlMatcher.replaceAll(mr -> "<em>" + mr.group(2) + "</em>");
        System.out.println(replacedHtml);

    }
}
