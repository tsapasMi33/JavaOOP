package be.tsapasMi33.exercises.localechallenge;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.zone.ZoneRules;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private record Employee(String name, Locale locale, ZoneId zone) {

        public Employee(String name, String locale, String zone) {
            this(name,Locale.forLanguageTag(locale),ZoneId.of(zone));
        }
        public Employee(String name, Locale locale, String zone) {
            this(name,locale,ZoneId.of(zone));
        }

        String getDateInfo(ZonedDateTime zdt, DateTimeFormatter dtf) {
            return "%s [%s] : %s".formatted(name, zone,
                    zdt.format(dtf.localizedBy(locale)));
        }
    }
    public static void main(String[] args) {
        Employee jane = new Employee("Jane", "en-AU", "Australia/Eucla");
        Employee mike = new Employee("Mike", "fr_BE", "Europe/Brussels");

        ZoneRules mikesRules = mike.zone.getRules();
        ZoneRules janesRules = jane.zone.getRules();
        System.out.println(jane + " " + janesRules);
        System.out.println(mike + " " + mikesRules);

        ZonedDateTime janeNow = ZonedDateTime.now(jane.zone);
        ZonedDateTime mikeNow = ZonedDateTime.of(janeNow.toLocalDateTime(), mike.zone);
        long hoursBetween = Duration.between(mikeNow, janeNow).toHours();
        long minutesBetween = Duration.between(mikeNow,janeNow).toMinutesPart();

        System.out.println("Mike is " + Math.abs(hoursBetween) + " hours " +
                Math.abs(minutesBetween) + " minutes " + ((hoursBetween < 0) ? "behind" : "ahead"));

        System.out.println("Mike in daylight savings? " +
                mikesRules.isDaylightSavings(mikeNow.toInstant()) + " " +
                mikesRules.getDaylightSavings(mikeNow.toInstant()) + ": " +
                mikeNow.format(DateTimeFormatter.ofPattern("zzzz z")));

        System.out.println("Jane in daylight savings? " +
                janesRules.isDaylightSavings(janeNow.toInstant()) + " " +
                janesRules.getDaylightSavings(janeNow.toInstant()) + ": " +
                janeNow.format(DateTimeFormatter.ofPattern("zzzz z")));

        var map = schedule(mike, jane, 10);
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT);
        for (LocalDate ldt : map.keySet()) {
            System.out.println(ldt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
            for (ZonedDateTime zdt : map.get(ldt)) {
                System.out.println("\t + " +
                        jane.getDateInfo(zdt, dtf) + " <---> " +
                        mike.getDateInfo(zdt.withZoneSameInstant(mike.zone),dtf));
            }
        }
    }

    private static Map<LocalDate, List<ZonedDateTime>> schedule(Employee first, Employee second, int days) {
        Predicate<ZonedDateTime> rules = zdt -> zdt.getDayOfWeek() != DayOfWeek.SATURDAY
                &&zdt.getDayOfWeek() != DayOfWeek.SUNDAY
                && zdt.getHour() >= 9 && zdt.getHour() < 20;

        LocalDate startingDate = LocalDate.now().plusDays(1);

        return startingDate.datesUntil(startingDate.plusDays(days + 1))
                .map(dt -> dt.atStartOfDay(first.zone))
                .flatMap(dt -> IntStream.range(0,24).mapToObj(dt::withHour))
                .filter(rules)
                .map(dtz -> dtz.withZoneSameInstant(second.zone()))
                .filter(rules)
                .collect(Collectors.groupingBy(ZonedDateTime::toLocalDate,
                        TreeMap::new, Collectors.toList()));

    }
}
