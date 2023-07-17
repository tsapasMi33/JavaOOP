package be.tsapasMi33.demo.inheritance;

public class Vehicle {
    public String make;
    public String model;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void move() {
        System.out.println("I move");
    }

    @Override
    public String toString() {
        return "Make: " + make + "\n" + "Model: " + model;
    }
}
