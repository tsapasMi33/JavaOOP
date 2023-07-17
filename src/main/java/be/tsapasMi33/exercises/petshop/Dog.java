package be.tsapasMi33.exercises.petshop;

import java.time.format.DateTimeFormatter;
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

    public String getCollarColor() {
        return collarColor;
    }

    public void setCollarColor(String collarColor) {
        this.collarColor = collarColor;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public void speak() {
        System.out.println("Barf Barf");
    }

    @Override
    public String toString() {
        return String.format("""
                %s: %s
                    Sex: %s
                    Race: %s
                    Trained: %s
                    Collar: %s
                    Size: %s
                    Weight: %f kg
                    Age: %d
                    Age in Human years: %d
                    Arrival date: %s
                """,this.getClass().getSimpleName(), getName(), getSex(), getRace(), isTrained() ? "Yes" : "No", getCollarColor(), getSize(), getWeight(), getAge(), getHumanAge(), getArrivalDate().format(DateTimeFormatter.ofPattern("dd MMMM yy")));
    }
}
