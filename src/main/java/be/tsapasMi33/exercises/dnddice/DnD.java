package be.tsapasMi33.exercises.dnddice;

import java.util.*;

public class DnD {
    private static final Random random = new Random();
    public static class Dice {
        public static int throwDice(){
            return throwDice(6);
        }
        public static int throwDice(int faces){
            return throwDice(faces, 1);
        }
        public static int throwDice(int faces, int times){
            return throwDice(faces, times, times);
        }
        public static int throwDice(int faces, int times, int retain){
            int[] dices = new int[times];
            for (int i = 0; i < times; i++){
                dices[i] = random.nextInt(1,faces + 1);
            }
            Arrays.sort(dices);
            int k = 0, j = times - 1;
            while (k<j) {
                int t = dices[k];
                dices[k] = dices[j];
                dices[j] = t;
                k++;
                j--;
            }
            int result = 0;
            for (int i = 0; i < retain; i++){
                result += dices[i];
            }
            return result;
        }

        public static int dndTerms(String term) {
            String[] expression = term.split("d");
            return throwDice(Integer.parseInt(expression[1]), Integer.parseInt(expression[0]));
        }
    }
}
