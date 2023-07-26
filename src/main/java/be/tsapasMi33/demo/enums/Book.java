package be.tsapasMi33.demo.enums;

public class Book {
    private String ISBN;
    private String titre;
    private Genres genre;

    public Book(String ISBN, String titre, Genres genre) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.genre = genre;
    }
}
