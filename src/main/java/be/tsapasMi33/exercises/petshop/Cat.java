package be.tsapasMi33.exercises.petshop;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cat extends Animal{
    private String character;
    private boolean NailsCut;
    private boolean isLongHair;

    public Cat() {
        super(5, 0.005);
        Scanner s = new Scanner(System.in);
        System.out.print("Character: ");
        character = s.nextLine();
        System.out.println("Nails cut?[y/n]");
        String answer = s.nextLine();
        NailsCut = answer.charAt(0) == 'y';
        System.out.println("Long hair?[y/n]");
        answer = s.nextLine();
        isLongHair = answer.charAt(0) == 'y';
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public boolean isNailsCut() {
        return NailsCut;
    }

    public void setNailsCut(boolean nailsCut) {
        this.NailsCut = nailsCut;
    }

    public boolean isLongHair() {
        return isLongHair;
    }

    public void setLongHair(boolean longHair) {
        isLongHair = longHair;
    }

    @Override
    public void speak() {
        System.out.println("Meow Meow");
    }

    @Override
    public String toString() {
        return String.format("""
                %s: %s
                    Sex: %s
                    Character: %s
                    Long Hair: %s
                    Nails Cut: %s
                    Size: %s
                    Weight: %f kg
                    Age: %d
                    Age in Human years: %d
                    Arrival date: %s
                """,this.getClass().getSimpleName(), getName(), getSex(), getCharacter(), isLongHair() ? "Yes" : "No", isNailsCut() ? "Yes" : "No", getSize(), getWeight(), getAge(), getHumanAge(), getArrivalDate().format(DateTimeFormatter.ofPattern("dd MMMM yy")));
    }
}
