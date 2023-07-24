package be.tsapasMi33.exercises.dnddice;

import be.tsapasMi33.demo.basicClass.DemoCollections;
import be.tsapasMi33.exercises.dnddice.DnD.Dice;

public class Main {
    public static void main(String[] args) {
        System.out.println(Dice.throwDice(100,5,3));

        System.out.println(Dice.dndTerms("4d6"));
    }
}
