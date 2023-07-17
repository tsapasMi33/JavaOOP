package be.tsapasMi33.exercises.rpggame.models;

import be.tsapasMi33.exercises.petshop.Animal;

import java.util.Scanner;

public class Bird extends Animal {
    private String color;
    private boolean livesInCage;

    public Bird() {
        super(3, 0.03);
        Scanner s = new Scanner(System.in);
        System.out.print("Color: ");
        color = s.nextLine();
        System.out.print("Needs cage? [y/n]: ");
        String answer = s.nextLine();
        livesInCage = answer.charAt(0) == 'y';
    }


}
