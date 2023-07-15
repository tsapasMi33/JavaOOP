package be.tsapasMi33.demo.basicClass;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListsAndIterator {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0,"Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

        removeElements(placesToVisit);
        System.out.println(placesToVisit);

        gettingElements(placesToVisit);

        printItinerary(placesToVisit);

        testIterator(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Darwin");
        list.addLast("Hobart");

        // queue methods
        list.offer("Melbourne"); //add last
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");

        // stack methods
        list.push("Alice Springs"); // at head
    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove();
        System.out.println(s1 + " was removed");

        System.out.println(list);
        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");

        System.out.println(list);
        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");


        //Queue - Deque poll methods
        String p1 = list.poll();
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast();
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        list.push("Darwin");
        list.push("Toowoomba");
        list.push("Sydney");
        System.out.println(list);

        String p4 = list.pop();
        System.out.println(p4 + " was removed");

    }

    private static void gettingElements(LinkedList<String> list){
        System.out.println(list);
        System.out.println("Retrieved element = " + list.get(4));

        System.out.println("First = " + list.getFirst());

        System.out.println("Last = " + list.getLast());

        System.out.println("(first) Darwin at index : " + list.indexOf("Darwin"));
        System.out.println("(last) Melbourne at index : " + list.lastIndexOf("Melbourne"));

        //queue methods
        System.out.println("Element from element() : " + list.element()); // first

        //stack methods
        System.out.println("Element from peek() : " + list.peek()); // last
        System.out.println("Element from peekFirst() : " + list.peekFirst());
        System.out.println("Element from peekLast() : " + list.peekLast());
    }
    public static void printItinerary(LinkedList<String> list) {
        System.out.println("Start -> " + list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--> from <" + list.get(i-1) + "> to <" + list.get(i) + ">");
        }
        System.out.println("End -> " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list) {
        System.out.println("Start -> " + list.getFirst());
        String previous = list.getFirst();
        for (String town : list) {
            System.out.println("--> from <" + previous + "> to <" + town + ">");
            previous = town;
        }
        System.out.println("End -> " + list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list) {
        System.out.println("Start -> " + list.getFirst());
        String previous = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("--> from <" + previous + "> to <" + town + ">");
            previous = town;
        }
        System.out.println("End -> " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list) {
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            //System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static void testListIterator(LinkedList<String> list) {
        var iterator = list.listIterator();
        while (iterator.hasNext()) {
            //System.out.println(iterator.next());
            if (iterator.next().equals("Brisbane")) {
                //iterator.remove();
                //iterator.add("Lake Wivenhoe");
            }
        }

        //After going through the iterable we cannot start from the beginning simply
        //Either we create a new instance of the iterator or go backwards
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println(list);

        // initialize at a specific point
        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.next());
        System.out.println(iterator2.previous());
    }
}
