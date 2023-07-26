package be.tsapasMi33.demo.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Dice {
    D4(4), D6(6), D10(10), D20(20), D100(100) ;

    private int value;
    Dice(int value) {
        this.value = value;
    }

    int roll() {
        Random r = new Random();
        return r.nextInt(this.value) + 1;
    }

    int rollMany(int times){
        int result = 0;
        for (int i = 0; i < times; i++) {
            result += roll();
        }
        return result;
    }

    int rollManyKeepSome(int times, int keep) {
        List<Integer> result = new ArrayList<>(times);
        for (int i = 0; i < times; i++) {
            result.add(roll());
        }
        return result.stream().sorted(Integer::compareTo).limit(keep).mapToInt(i -> i).sum();
    }
}
