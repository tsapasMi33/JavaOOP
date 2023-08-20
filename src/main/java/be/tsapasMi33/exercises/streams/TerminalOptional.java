package be.tsapasMi33.exercises.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOptional {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .toList();

        int minAge = 21;

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .findAny()
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n", s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("No student under " + minAge));

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .findFirst()
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n", s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("No student under " + minAge));

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .min(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n", s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("No student under " + minAge));

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .max(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n", s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("No student under " + minAge));

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .mapToInt(Student::getAge)
                .average()
                .ifPresentOrElse(s -> System.out.printf("Avg age under 21: %.2f%n", s),
                        () -> System.out.println("No student under " + minAge));

        students.stream()
                .filter(student -> student.getAge() <= minAge)
                .map(Student::getCountryCode)
                .distinct()
                .reduce((a, b) -> String.join(",",a , b))
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("None found"));

        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .map(l -> String.join(",", l))
                .filter(l -> l.contains("AU"))
                .findAny()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Missing AU"));


    }
}
