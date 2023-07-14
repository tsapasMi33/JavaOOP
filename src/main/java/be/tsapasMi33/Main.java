package be.tsapasMi33;

import be.tsapasMi33.exercises.Person;
import be.tsapasMi33.exercises.Current;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Michail", "Tsapas", LocalDate.of(1990,1,9));
        Person p2 = new Person("John", "Doe",LocalDate.of(1987,3,17));

        Current c1 = new Current(p1);
        Current c2 = new Current(p2);

        System.out.println(c1);
        System.out.println(c2);

        c1.deposit(500);
        System.out.println(c1);

        c1.withdraw(5000);
        System.out.println(c1);

        c1.setLine(5000);
        System.out.println(c1);

        c1.withdraw(500);
        System.out.println(c1);

        c1.transfer(1000, c2);
        System.out.println(c1);
        System.out.println(c2);
    }
}