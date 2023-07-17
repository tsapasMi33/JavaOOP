package be.tsapasMi33.demo.inheritance;

public class Car extends Vehicle {
    private int wheels;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public void move() {
        System.out.println("I drive");
    }


}
