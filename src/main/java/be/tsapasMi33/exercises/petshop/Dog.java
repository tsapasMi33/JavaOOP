package be.tsapasMi33.exercises.petshop;

import java.util.Scanner;

public class Dog extends Animal {
    private String collarColor;
    private boolean isTrained;
    private String race;

    public Dog() {
        super(7, 0.01);
        Scanner s = new Scanner(System.in);
        System.out.print("Collar Color: ");
        collarColor = s.nextLine();
        System.out.print("Is it trained? [y/n]: ");
        String answer = s.nextLine();
        isTrained = answer.charAt(0) == 'y';
        System.out.print("Race: ");
        race = s.nextLine();
    }

    @Override
    public void speak() {
        System.out.println("Barf Barf");
    }
}
