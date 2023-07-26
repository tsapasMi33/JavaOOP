package be.tsapasMi33.demo.enums;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("1","Bla",Genres.ACTION);

        Genres genre = Genres.ACTION;

        String genre1 = genre.toString();
        int ordinal = genre.ordinal();

        Genres genreFromString = Genres.valueOf(genre1);

        Genres genreFromOrdinal = Genres.values()[2];

        for (Genres g : Genres.values()) {
            System.out.println(g);
        }

        Dice dice = Dice.D6;
        dice.roll();

        Dice.D20.rollManyKeepSome(5,2);
    }
}
