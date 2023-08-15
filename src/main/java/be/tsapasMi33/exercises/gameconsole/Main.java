package be.tsapasMi33.exercises.gameconsole;

import be.tsapasMi33.exercises.gameconsole.pirate.PirateGame;

public class Main {
    public static void main(String[] args) {
//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}
