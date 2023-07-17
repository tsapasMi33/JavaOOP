package be.tsapasMi33.exercises.petshop;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, Animal> animals= new HashMap<>();
        boolean newAnimal = true;
        System.out.println("Please add all the animals");
        while (newAnimal){
            var object = createEntry();
            if (object != null){
                animals.put(object.getName(), object);
            }
            System.out.print("Add new animal?[y/n]: ");
            newAnimal = s.nextLine().charAt(0) == 'y';
        }
        boolean quit = false;
        while (!quit) {
            System.out.println("""
                    1. Add Animal
                    2. Animal Sold
                    3. Show all animals
                    4. Show animal counts
                    5. Next day
                    6. Quit
                    """);
            int i = Integer.parseInt(s.nextLine());
            switch (i){
                case 1 -> {
                    var object = createEntry();
                    if (object != null){
                        animals.put(object.getName(), object);
                    }
                }
                case 2 -> {
                    System.out.print("Enter name of animal: ");
                    animals.remove(s.nextLine());
                }
                case 3 -> printAnimals(animals);
                case 4 -> countAnimals(animals);
                case 5 -> nextDay(animals);
                case 6 -> quit = true;
            }
        }
    }

    public static Animal createEntry(){
        Scanner s = new Scanner(System.in);
        System.out.print("(D)og\n(C)at\n(B)ird\nChoose option:");
        var object = (switch (s.nextLine().toUpperCase().charAt(0)) {
            case 'D' -> new Dog();
            case 'C' -> new Cat();
            case 'B' -> new Bird();
            default -> {
                System.out.println("Unknown species!");
                yield null;
            }
        });
        return object;
    }

    public static void printAnimals(HashMap<String, Animal> animals) {
        for (Animal animal : animals.values()) {
            System.out.println(animal);
            System.out.println(animal.getName() + " says :");
            animal.speak();
            System.out.println("-".repeat(30));
        }
    }

    public static void countAnimals(HashMap<String, Animal> animals) {
        int cats = 0, dogs = 0, birds = 0;
        for (Animal animal : animals.values()) {
            if(animal instanceof Dog) {
                dogs++;
            } else if (animal instanceof Cat) {
                cats++;
            } else {
                birds ++;
            }
        }
        System.out.println("Cats: " + cats + "\nDogs: " + dogs + "\nBirds: " + birds);
    }

    public static void nextDay(HashMap<String,Animal> animals) {
        Random r = new Random();
        for (Animal animal : animals.values()) {
            double dice = r.nextDouble(1);
            if (dice < animal.getDeathProbability()) {
                animals.remove(animal.getName());
                System.out.println(animal.getName() + " unfortunately died at the age of " + animal.getAge());
            }
        }
    }
}
