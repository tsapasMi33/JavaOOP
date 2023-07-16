package be.tsapasMi33.exercises.carrace;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


record lapTime(Car car, double time){

    @Override
    public double time() {
        return time;
    }

    @Override
    public String toString() {
        return car +
                "\ntotal time=" + time + " minutes";
    }
}

public class Race {
    private final Circuit circuit;
    private final ArrayList<lapTime> results;


    public Race() {
        Scanner s = new Scanner(System.in);

        results = new ArrayList<>();
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
        results.sort(Comparator.comparingDouble(lapTime::time));
        System.out.println("\n\n");
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Place #" + (i+1));
            System.out.println(results.get(i).toString());
        }
    }

    public void startRace(Car[] cars) {
        Random r = new Random();
        double[] lapTimes = new double[cars.length];
        for (int i = 0; i < circuit.getRounds(); i++) {
            System.out.println("--> Lap #" + (i+1) + " <--");
            for (int j = 0; j < cars.length; j++) {
                double lapTime = (double) circuit.getDistance() / ((double) r.nextInt(cars[j].getVMin(), cars[j].getVMax()) / 60);
                lapTimes[j] += lapTime;
                System.out.println(cars[j] + " -> " + lapTime + " minutes");
            }
        }
        for (int i = 0; i < cars.length; i++) {
            results.add(new lapTime(cars[i], lapTimes[i]));
        }
    }

}
