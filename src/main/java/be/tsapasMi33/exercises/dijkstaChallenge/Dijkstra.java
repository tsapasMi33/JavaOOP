package be.tsapasMi33.exercises.dijkstaChallenge;

import java.util.Random;

public class Dijkstra {
    public static void main(String[] args) {
        Random random = new Random();

        char[][] road = new char[10][10];

        for (int i = 0; i < road.length; i++){
            for (int j = 0; j< road[0].length; j++){
                if (random.nextBoolean()) {
                    road[i][j] = (char) 9633;
                } else {
                    road[i][j] = (char) 9632;
                }
            }
        }


        int x = random.nextInt(10);
        int y = random.nextInt(10);
        road[x][y] = (char) 9638;

        x = random.nextInt(10);
        y = random.nextInt(10);
        road[x][y] = (char) 9635;


        for (int i = 0; i < road.length; i++){
            for (int j = 0; j< road[0].length; j++){
                System.out.printf("%3c",road[i][j]);
            }
            System.out.println();
        }
    }



}

