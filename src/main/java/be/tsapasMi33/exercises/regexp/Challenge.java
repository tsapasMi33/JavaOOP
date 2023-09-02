package be.tsapasMi33.exercises.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {
    public static void main(String[] args) {
        String[] emails = {
                "john.boy@valid.com",
                "jane.doe-smith@valid.co.uk",
                "jane.doe1976@valid.co.uk",
                "bob-1964@valid.net",
                "elaine@valid-test.com.au",
                "david@valid.io",
                "john.boy@invalid",
                "bob!@invalid.com",
                "elaineinvalid1983@.com",
                "david@invalid..com"
        };

        Pattern pattern = Pattern.compile("([\\w.-]+)@(([\\w-]+\\.)+[\\w-]{2,})");

        for (String email : emails) {
            Matcher emailMatcher = pattern.matcher(email);
            emailMatcher.results().forEach(matchResult -> {
                System.out.printf("[username = %s, domain=%s]%n",matchResult.group(1), matchResult.group(2));
            });
        }

    }
}
