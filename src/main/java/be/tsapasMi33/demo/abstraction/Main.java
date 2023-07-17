package be.tsapasMi33.demo.abstraction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Wolf", "big", 50);
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals =new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepherd", "big", 75));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 40));
        animals.add(new Dog("Pug", "small", 10));

        animals.add(new Horse("Clydesdale", "large", 1000));

        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal) {
                currentMammal.shedHair();
            }
        }
    }

    private static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move("slow");
    }
}
