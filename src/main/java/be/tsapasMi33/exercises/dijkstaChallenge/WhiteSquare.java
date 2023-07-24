package be.tsapasMi33.exercises.dijkstaChallenge;

public class WhiteSquare extends Square implements Walkable{
    public WhiteSquare(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        String s = Character.toString((char) 9723);
        return s;
    }
}
