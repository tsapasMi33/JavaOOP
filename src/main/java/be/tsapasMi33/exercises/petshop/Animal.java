package be.tsapasMi33.exercises.petshop;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Animal {
    private String name;
    private int weight;
    private String size;
    private String sex;
    private int age;
    private int humanAge;
    private double deathProbability;
    private LocalDate arrivalDate;

    public Animal(int multiplier, double deathProbability) {
        Scanner s = new Scanner(System.in);

        System.out.print("Name: ");
        name = s.nextLine();
        System.out.print("Weight: ");
        weight = Integer.parseInt(s.nextLine());
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

    public abstract void speak();
}
