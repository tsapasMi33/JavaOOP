package be.tsapasMi33.exercises.LinkedListChallenge;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Traveller {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LinkedList<Town> placesToVisit = new LinkedList<>();

        String town;
        System.out.println("Enter places to visit or stop to stop ");
        do{
            System.out.print("Town : ");
            town = s.nextLine();
            System.out.print("Distance : ");
            int km = Integer.parseInt(s.nextLine());
            Town newTown = new Town(town, km);
            if (!town.equals("stop")  && !placesToVisit.contains(newTown)){
                placesToVisit.add(newTown);
            }
        } while (!town.equals("stop"));

        placesToVisit.sort(Comparator.comparingInt(Town::getDistance));

        System.out.print("Where do you start from? :");
        placesToVisit.addFirst(new Town(s.nextLine(), 0));

        var iterator = placesToVisit.listIterator(1);

        String action = "m";
        while (!action.equals("q")) {
            switch (action) {
                case "f" -> {
                    if (iterator.hasNext()) {
                        System.out.println("You go to " + iterator.next());
                    } else {
                        System.out.println("That is the last town!");
                    }
                }
                case "b" -> {
                    if (iterator.hasPrevious()) {
                        System.out.println("You go to " + iterator.previous());
                    } else {
                        System.out.println("That is the first town!");
                    }
                }
                case "l" -> System.out.println(placesToVisit);
                case "m" -> System.out.print("(F)orward\n" +
                        "(B)ackward\n" +
                        "(L)ist places\n" +
                        "(M)enu\n" +
                        "(Q)uit\n");
                default -> System.out.println("What the fuck was that?");

            }
            action = s.nextLine().toLowerCase();
        }
    }
}

class Town {
    private String town;
    private int distance;

    public Town(String town, int distance) {
        this.town = town;
        this.distance = distance;
    }

    public String getTown() {
        return town;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return town;
    }
}
