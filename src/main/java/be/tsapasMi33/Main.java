package be.tsapasMi33;

import be.tsapasMi33.demo.basicClass.DayOfTheWeek;
import be.tsapasMi33.demo.basicClass.Topping;
import be.tsapasMi33.exercises.carrace.Race;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        DayOfTheWeek weekday = DayOfTheWeek.TUES;
        System.out.println(weekday);

        for (int i = 0; i < 10; i++) {
            weekday = getRandomDay();/*
            System.out.printf("Name is %s, Ordinal Value = %d%n", weekday.name(), weekday.ordinal());

            if (weekday == DayOfTheWeek.FRI) {
                System.out.println("Found a Friday!");
            }*/

            switchDay(weekday);
        }

        for (Topping topping : Topping.values()) {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }
    }

    public static DayOfTheWeek getRandomDay() {
        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();

        return allDays[randomInteger];
    }

    public static void switchDay(DayOfTheWeek weekday){
        int weekDayInteger = weekday.ordinal() + 1;
        switch (weekday) {
            case WED -> System.out.println("Wednesday is Day " + weekDayInteger);
            case SAT -> System.out.println("Saturday is Day " + weekDayInteger);
            default -> System.out.println(weekday.name().charAt(0) + weekday.name().substring(1).toLowerCase() + "day is Day " + weekDayInteger);
        }
    }
}
