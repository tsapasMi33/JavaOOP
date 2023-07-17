package be.tsapasMi33.demo.inheritance;

public class Boat extends Vehicle {
    private int sails;

    public int getSails() {
        return sails;
    }

    public void setSails(int sails) {
        this.sails = sails;
    }

    @Override
    public void move() {
        System.out.println("I sail");
    }
}
