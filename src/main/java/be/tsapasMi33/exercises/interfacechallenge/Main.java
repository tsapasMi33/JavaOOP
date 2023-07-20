package be.tsapasMi33.exercises.interfacechallenge;

import be.tsapasMi33.exercises.interfacechallenge.interfaces.Mappable;
import be.tsapasMi33.exercises.interfacechallenge.mapobjects.Building;
import be.tsapasMi33.exercises.interfacechallenge.mapobjects.UtilityLine;
import be.tsapasMi33.exercises.interfacechallenge.mapobjects.enums.UsageType;
import be.tsapasMi33.exercises.interfacechallenge.mapobjects.enums.UtilityType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mappable> mappables = new ArrayList<>();

        mappables.add(new Building("Sydney Town Hall", UsageType.GOVERNMENT));
        mappables.add(new Building("Sydney Opera House", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Stadium Australia", UsageType.SPORTS));

        mappables.add(new UtilityLine("College St", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Olympic Blvd", UtilityType.WATER));

        for (var m : mappables) {
            Mappable.mapIt(m);
        }
    }
}
