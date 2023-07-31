package be.tsapasMi33.demo.collections.deckofcards;

import be.tsapasMi33.demo.inheritance.Car;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray,aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards,aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts,"Aces of Hearts",1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs,"Kings of Clubs",1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck,"Shuffled deck",4);

        Collections.reverse(deck);
        Card.printDeck(deck,"Reversed Shuffled deck",4);

        Collections.sort(deck, Comparator.comparing(Card::rank).thenComparing(Card::suit));
        Card.printDeck(deck,"Standard Deck sorted by rank, suit", 13);

//        Collections.sort(deck, Comparator.comparing(Card::suit).thenComparing(Card::rank));
//        Card.printDeck(deck,"Standard Deck sorted by suit, rank", 4);

        Collections.reverse(deck);
        Card.printDeck(deck,"Standard Deck sorted by rank, suit reversed", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings,"Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16,20));
        Card.printDeck(tens,"Tens in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index of tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        Collections.shuffle(deck);
        subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index of tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("Disjoint = " + disjoint);
    }
}
