package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

import be.tsapasMi33.exercises.bankwithhashmap.bankaccount.exceptions.InsufficientFundsException;

public abstract class Account {
    protected static long ibanCounter = 283033000000000L;
    private final String iban;
    protected final Person owner;
    private double balance;

    public Account(Person owner, double initialAmount) {
        this.owner = owner;
        this.iban = "BE" + ibanCounter++;
        balance = initialAmount;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public String getIban() {
        return iban;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        balance -= amount;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void transfer(double amount, Account target) {
        target.deposit(amount);
        balance -= amount;
    }

    protected abstract double calculateInterestRate();

    public final void applyInterest(){
        this.balance += this.balance * calculateInterestRate();
    }
}
