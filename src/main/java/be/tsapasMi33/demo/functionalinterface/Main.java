package be.tsapasMi33.demo.functionalinterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        CarWash carWash = new CarWash();
        Car c1 = new Car("1");

        System.out.println("Prepare?");
        if (s.nextBoolean()){
            carWash.addService(c -> System.out.println("Preparing car #" + c.getNumber()));
        }
        System.out.println("Wash?");
        if (s.nextBoolean()){
            carWash.addService(c -> System.out.println("Washing car #" + c.getNumber()));
        }
        System.out.println("Finish?");
        if (s.nextBoolean()){
            carWash.addService(c -> System.out.println("Finishing car #" + c.getNumber()));
        }

        carWash.startTreatment(c1);
    }
}
