package be.tsapasMi33.exercises.rpggame.models;

public class Monster extends Entity {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void attack(Entity target) {
    }
}
