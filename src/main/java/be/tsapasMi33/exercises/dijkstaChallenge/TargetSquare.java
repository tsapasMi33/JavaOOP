package be.tsapasMi33.exercises.dijkstaChallenge;

public class TargetSquare extends Square implements Walkable{
    public TargetSquare(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        String s = Character.toString((char) 9974);
        return s;
    }
}
