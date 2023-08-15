package be.tsapasMi33.exercises.gameconsole.pirate;

public final class Islander extends Combatant {
    public Islander(String name, Weapon weapon) {
        super(name);
        setCurrentWeapon(weapon);
    }
}
