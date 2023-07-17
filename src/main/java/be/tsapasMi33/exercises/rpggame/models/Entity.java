package be.tsapasMi33.exercises.rpggame.models;

public class Entity {
    private int hpMax;
    private int currentHp;
    private int strength;

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void attack(Entity target) {

    }
}
