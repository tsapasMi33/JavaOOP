package be.tsapasMi33.exercises.petshop;

import be.tsapasMi33.exercises.petshop.Animal;

import java.time.format.DateTimeFormatter;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isLivesInCage() {
        return livesInCage;
    }

    public void setLivesInCage(boolean livesInCage) {
        this.livesInCage = livesInCage;
    }

    @Override
    public void speak() {
        System.out.println("Chirp Chirp");
    }

    @Override
    public String toString() {
        return String.format("""
                %s: %s
                    Sex: %s
                    Color: %s
                    Needs cage: %s
                    Size: %s
                    Weight: %f kg
                    Age: %d
                    Age in Human years: %d
                    Arrival date: %s
                """,this.getClass().getSimpleName(), getName(), getSex(), getColor(), isLivesInCage() ? "Yes" : "No", getSize(), getWeight(), getAge(), getHumanAge(), getArrivalDate().format(DateTimeFormatter.ofPattern("dd MMMM yy")));
    }
}
