package be.tsapasMi33.demo.genericsextra;

import be.tsapasMi33.demo.genericsextra.model.LPAStudent;
import be.tsapasMi33.demo.genericsextra.model.LPAStudentComparator;
import be.tsapasMi33.demo.genericsextra.model.Student;
import be.tsapasMi33.demo.genericsextra.staticandmultiupperbounds.QueryItem;
import be.tsapasMi33.demo.genericsextra.staticandmultiupperbounds.QueryList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i =0; i < studentCount; i++) {
            students.add(new Student());
        }

        printMoreLists(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i =0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }

        printMoreLists(lpaStudents);

        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printMoreLists(matches);

        var students2021 = QueryList.getMatches(students, "yearstarted", "2021");
        printMoreLists(students2021);

//        queryList<Employee> employeeList = new QueryList<>();

        QueryList<LPAStudent> queryList0 = new QueryList<>();
        for (int i= 0; i < 25; i++) {
            queryList0.add(new LPAStudent());
        }
        System.out.println("Ordered");
        queryList0.sort(Comparator.naturalOrder());
        printList(queryList0);

        System.out.println("Matches");
        var matches0 = queryList0.getMatches("percentcomplete", "50").getMatches("course", "python");
        matches0.sort(new LPAStudentComparator());
        printList(matches0);

        System.out.println("Ordered");
        matches0.sort(null);
        printList(matches0);
    }

//    public static <T extends Student> void printList(List<T> students) {
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }

    public static void printMoreLists(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

//    public static void testList(List<String> list) {
//        for (var element : list) {
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list) {
//        for (var element : list) {
//            System.out.println("Integer: " + element.floatValue());
//        }
//    }

    public static void  testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

    public static void printList(List<?> students) {
        for (var student : students) {
            System.out.println(student);
        }
    }
}
