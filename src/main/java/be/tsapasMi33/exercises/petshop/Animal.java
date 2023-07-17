package be.tsapasMi33.exercises.petshop;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Animal {
    private String name;//
    private double weight;//
    private String size;//
    private String sex;//
    private int age;//
    private int humanAge;//
    private double deathProbability;
    private LocalDate arrivalDate;

    public Animal(int multiplier, double deathProbability) {
        Scanner s = new Scanner(System.in);

        System.out.print("Name: ");
        name = s.nextLine();
        System.out.print("Weight: ");
        weight = Double.parseDouble(s.nextLine());
        System.out.print("Size [XXS,XS,S,M,L,XL,XXL]: ");
        size = s.nextLine().toUpperCase();
        System.out.print("Sex [M/F]: ");
        sex = s.nextLine();
        System.out.print("Age: ");
        age = Integer.parseInt(s.nextLine());
        humanAge = age * multiplier;
        this.deathProbability = deathProbability;
        arrivalDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHumanAge() {
        return humanAge;
    }

    public void setHumanAge(int humanAge) {
        this.humanAge = humanAge;
    }

    public double getDeathProbability() {
        return deathProbability;
    }

    public void setDeathProbability(double deathProbability) {
        this.deathProbability = deathProbability;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public abstract void speak();
}
