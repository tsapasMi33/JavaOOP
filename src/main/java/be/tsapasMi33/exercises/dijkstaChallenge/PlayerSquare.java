package be.tsapasMi33.exercises.dijkstaChallenge;

public class PlayerSquare extends Square implements Walkable{
    public PlayerSquare(int x, int y) {
        super(x, y);
    }


    @Override
    public String toString() {
        String s = Character.toString((char) 9635);
        return s;
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }
}
