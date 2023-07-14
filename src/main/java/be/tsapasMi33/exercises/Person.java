package be.tsapasMi33.exercises;

import java.time.LocalDate;

public class Person {

    private String lastName;
    private String firstName;
    private LocalDate birthday;


    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, LocalDate birthday){
        this(firstName, lastName);
        this.birthday = birthday;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.trim().equals("")) {
            return;
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.trim().equals("")) {
            return;
        }
        this.firstName = firstName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now())){
            return;
        }
        this.birthday = birthday;
    }

    public int getAge() {
        int age = LocalDate.now().getYear() - birthday.getYear();
        if (age < 0) {
          return 0;
        }
        return age;
    }

    @Override
    public String toString() {
        if (birthday == null)
            return "name : " + getFirstName() + "\nlastname: " + getLastName();
        return "name : " + getFirstName() + "\nlastname: " + getLastName() + "\nage: " + getAge();
    }

}
