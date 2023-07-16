package be.tsapasMi33.exercises.traveller;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance) {

    @Override
    public String toString() {
        return String.format("%s (%s)", name, distance);
    }
}

public class TravellerAlternative {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        LinkedList<Place> placesToVisit = new LinkedList<>();

        addPlace(placesToVisit,new Place("Adelaide",1374));
        addPlace(placesToVisit,new Place("Brisbane",917));
        addPlace(placesToVisit,new Place("Perth",3923));
        addPlace(placesToVisit,new Place("Alice Springs",2771));
        addPlace(placesToVisit,new Place("Melbourne",877));
        addPlace(placesToVisit,new Place("Darwin",3972));

        placesToVisit.sort(Comparator.comparingInt(Place::distance));

        placesToVisit.addFirst(new Place("Sydney",0));

        var iterator = placesToVisit.listIterator();
        boolean quit = false;
        boolean forward = true;

        printMenu();
        while (!quit){
            if (!iterator.hasPrevious()) {
                System.out.println("Originating : " + iterator.next());
                forward = true;
            }
            if (!iterator.hasNext()) {
                System.out.println("Final : " + iterator.previous());
                forward = false;
            }
            System.out.println("Enter value: ");
            String menuItem = s.nextLine().toUpperCase().substring(0,1);
            switch (menuItem) {
                case "F" -> {
                    System.out.println("You want to go forward");
                    if (!forward) {
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                }
                case "B" -> {
                    System.out.println("You go backward");
                    if (forward) {
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                }
                case "M" -> printMenu();
                case "L" -> System.out.println(placesToVisit);
                default -> quit = true;
            }
        }

    }

    private static void addPlace(LinkedList<Place> list, Place place){
        if (list.contains(place)) {
            System.out.println("Found duplicate: " + place);
            return;
        }
        list.add(place);
    }

    private static void printMenu() {
        System.out.println(
                "(F)orward\n" +
                "(B)ackward\n" +
                "(L)ist places\n" +
                "(M)enu\n" +
                "(Q)uit\n");
    }
}
