package be.tsapasMi33.exercises.carrace;

public class Circuit {

    private final int rounds;
    private final int distance;

    public Circuit(int rounds, int distance) {
        this.rounds = rounds;
        this.distance = distance;
    }

    public int getRounds() {
        return rounds;
    }

    public int getDistance() {
        return distance;
    }
}
