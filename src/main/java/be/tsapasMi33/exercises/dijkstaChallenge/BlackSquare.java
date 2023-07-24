package be.tsapasMi33.exercises.dijkstaChallenge;

public class BlackSquare extends Square{
    public BlackSquare(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        String s = Character.toString((char) 9724);
        return s;
    }
}
