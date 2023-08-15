package be.tsapasMi33.exercises.gameconsole.pirate;

public final class Soldier extends Combatant {
    public Soldier(String name, Weapon weapon) {
        super(name);
        setCurrentWeapon(weapon);
    }
}
