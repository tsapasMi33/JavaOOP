package be.tsapasMi33.exercises.gameconsole;

import java.util.function.Predicate;

public record GameAction(char key, String prompt, Predicate<Integer> action) {
}
