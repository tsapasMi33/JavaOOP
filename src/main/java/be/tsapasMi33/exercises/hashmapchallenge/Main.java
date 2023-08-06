package be.tsapasMi33.exercises.hashmapchallenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        AdventureGame game = new AdventureGame();
        game.play("road");
        while (true) {
            String direction = s.nextLine().trim().toUpperCase().substring(0,1);
            if (direction.equals("Q")) break;
            game.move(direction);
        }
    }
}
