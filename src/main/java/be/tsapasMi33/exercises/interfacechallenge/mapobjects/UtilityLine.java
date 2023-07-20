package be.tsapasMi33.exercises.interfacechallenge.mapobjects;

import be.tsapasMi33.exercises.interfacechallenge.enums.Color;
import be.tsapasMi33.exercises.interfacechallenge.enums.LineMarker;
import be.tsapasMi33.exercises.interfacechallenge.interfaces.Mappable;
import be.tsapasMi33.exercises.interfacechallenge.interfaces.enums.Geometry;
import be.tsapasMi33.exercises.interfacechallenge.mapobjects.enums.UtilityType;

public class UtilityLine implements Mappable {
    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return switch (type){
            case ELECTRICAL -> Color.RED + " " + LineMarker.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMarker.DOTTED;
            case GAS -> Color.ORANGE + " " + LineMarker.SOLID;
            case WATER -> Color.BLUE + " " + LineMarker.SOLID;
            default -> Color.BLACK + " " + LineMarker.SOLID;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                ,"name": "%s", "usage": "%s" """.formatted(name, type);
    }
}
