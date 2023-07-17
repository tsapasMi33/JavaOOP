package be.tsapasMi33.demo.inheritance;

public class Airplane extends Vehicle {
    private int motors;

    public int getMotors() {
        return motors;
    }

    public void setMotors(int motors) {
        this.motors = motors;
    }

    @Override
    public void move() {
        System.out.println("I fly");
    }
}
