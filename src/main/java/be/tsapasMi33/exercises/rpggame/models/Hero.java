package be.tsapasMi33.exercises.rpggame.models;

import java.util.Random;

public class Hero extends Entity{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void loot(Monster target) {
        System.out.println(this.name + " loots the monster");
    }

    @Override
    public void attack(Entity target) {
        Random rng = new Random();
        int dmg = this.getStrength() + rng.nextInt(10);
        System.out.println("Die monster!");

    }
}
