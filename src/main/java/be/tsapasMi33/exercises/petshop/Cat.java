package be.tsapasMi33.exercises.petshop;

import java.util.Scanner;

public class Cat extends Animal{
    private String character;
    private boolean areNailsCut;
    private boolean isLongHair;

    public Cat() {
        super(5, 0.005);
        Scanner s = new Scanner(System.in);
        System.out.print("Character: ");
        character = s.nextLine();
        System.out.println("Nails cut?[y/n]");
        String answer = s.nextLine();
        areNailsCut = answer.charAt(0) == 'y';
        System.out.println("Long hair?[y/n]");
        answer = s.nextLine();
        isLongHair = answer.charAt(0) == 'y';
    }

    @Override
    public void speak() {
        System.out.println("Meow Meow");
    }
}
