package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

public interface Banker extends Customer {
    void applyInterest();
    Person getOwner();
    String getIban();
}
