package be.tsapasMi33.exercises.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .toList();

        Set<Student> belgianStudents = students.stream()
                .filter(s -> s.getCountryCode().equals("BE"))
                .collect(Collectors.toSet());

        System.out.println("# of Belgian students = " + belgianStudents.size());

        Set<Student> underThirty = students.stream()
                .filter(s -> s.getAge() < 30)
                .collect(Collectors.toSet());

        System.out.println("# of students under 30 = " + underThirty.size());

        Set<Student> belgiansStudentsUnderThirty = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        belgiansStudentsUnderThirty.addAll(belgianStudents);
        belgiansStudentsUnderThirty.retainAll(underThirty);

        System.out.println("# of belgian students under 30 = " + belgiansStudentsUnderThirty.size());
        belgiansStudentsUnderThirty.forEach(student -> System.out.print(student.getStudentId() + ", "));
        System.out.println();

        Set<Student> youngBelgianStudents = students.stream()
                .filter(s -> s.getCountryCode().equals("BE"))
                .filter(s -> s.getAge() < 30)
                .collect(() -> new TreeSet<>(Comparator.comparing(
                        Student::getStudentId)), TreeSet::add, TreeSet::addAll);
        System.out.println("# of belgian students under 30 v2");
        youngBelgianStudents.forEach(student -> System.out.print(student.getStudentId() + ", "));
        System.out.println();

        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("Countries: ", (r, v) -> r + ", " + v);

        System.out.println(countryList);
    }
}
