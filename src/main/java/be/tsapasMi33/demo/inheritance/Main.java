package be.tsapasMi33.demo.inheritance;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.move();

        Car c  = new Car();
        c.setMake("Fiat");
        c.setModel("500");

        Boat b = new Boat();
        b.setMake("Sailfish");
        b.setModel("5000");

        Airplane a = new Airplane();
        a.setMake("Boeing");
        a.setModel("737 Max");

        Vehicle v1 = new Airplane();

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(a);
        vehicles.add(b);
        vehicles.add(c);

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
            vehicle.move();
        }
    }
}
