package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private final String lastName;
    private final String firstName;
    private final LocalDate birthday;


    public Person(String firstName, String lastName){
        this(firstName,lastName,LocalDate.of(1900,1,1));
    }

    public Person(String firstName, String lastName, LocalDate birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getLastName() {
        return lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getAge() {
        int age = Period.between(birthday,LocalDate.now()).getYears();
        if (age < 0) {
          return 0;
        }
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
