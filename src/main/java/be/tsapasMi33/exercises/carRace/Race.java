package be.tsapasMi33.exercises.carRace;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Race {
    private final Circuit circuit;
    private final ArrayList<Time> results = new ArrayList<>();


    public Race() {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter distance of circuit in km: ");
        int km = Integer.parseInt(s.nextLine());
        System.out.print("Enter number of rounds: ");
        int rounds = Integer.parseInt(s.nextLine());
        this.circuit= new Circuit(rounds,km);
        System.out.print("Enter number of cars: ");
        int nbCars = Integer.parseInt(s.nextLine());
        Car[] cars = new Car[nbCars];
        for (int i = 0; i < nbCars; i++) {
            System.out.println("Car #" + (i+1));
            System.out.print("Enter brand: ");
            String brand = s.nextLine();
            System.out.print("Enter model: ");
            String model = s.nextLine();
            System.out.print("Enter min speed: ");
            int vMin = Integer.parseInt(s.nextLine());
            System.out.print("Enter max speed: ");
            int vMax = Integer.parseInt(s.nextLine());
            cars[i] = new Car(brand,model,vMin,vMax);
        }
        System.out.print("Press enter to start the race");
        s.nextLine();
        startRace(cars);
        results.sort(Comparator.comparingDouble(Time::getTotalTime));
        System.out.println("\n\n");
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Place #" + (i+1));
            System.out.println(results.get(i).toString());
        }
    }

    public void startRace(Car[] cars) {
        Random r = new Random();
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].toString());
            double totalTime =0;
            for (int j = 1; j <= circuit.getRounds(); j++) {
                System.out.print("Round #" + j + "-");
                double lapTime = (double) r.nextInt(cars[i].getVMin(),cars[i].getVMax()) / circuit.getDistance() ;
                System.out.println(lapTime);
                totalTime += lapTime;
            }
            results.add(new Time(cars[i], totalTime));
        }
    }

}

class Time {
    private final Car car;
    private final double totalTime;

    public Time(Car car, double totalTime) {
        this.car = car;
        this.totalTime = totalTime;
    }

    public double getTotalTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        return car +
                "\ntotal time=" + totalTime + " minutes";
    }
}
