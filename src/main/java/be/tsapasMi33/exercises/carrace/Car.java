package be.tsapasMi33.exercises.carrace;

public class Car {
    private final String brand;
    private final String model;
    private final int vMin;
    private final int vMax;

    public Car(String brand, String model, int vMin, int vMax) {
        this.brand = brand;
        this.model = model;
        this.vMin = vMin;
        this.vMax = vMax;
    }

    public int getVMin() {
        return vMin;
    }

    public int getVMax() {
        return vMax;
    }

    @Override
    public String toString() {
        return "Car: " + brand + " " + model;
    }
}
