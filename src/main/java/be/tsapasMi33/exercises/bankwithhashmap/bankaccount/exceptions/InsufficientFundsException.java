package be.tsapasMi33.exercises.bankwithhashmap.bankaccount.exceptions;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException() {
        super("Insufficient Funds!");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
