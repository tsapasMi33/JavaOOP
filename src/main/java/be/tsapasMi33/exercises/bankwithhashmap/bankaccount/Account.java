package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

import be.tsapasMi33.exercises.bankwithhashmap.bankaccount.exceptions.InsufficientFundsException;

public abstract class Account implements Customer, Banker {
    protected static long ibanCounter = 283033000000000L;
    private final String iban;
    protected final Person owner;
    private double balance;


    public Account(Person owner, double initialAmount) {
        this.owner = owner;
        this.iban = "BE" + ibanCounter++;
        balance = initialAmount;
    }

    @Override
    public Person getOwner() {
        return owner;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getIban() {
        return iban;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        balance -= amount;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void transfer(double amount, Account target) {
        target.deposit(amount);
        balance -= amount;
    }

    protected abstract double calculateInterestRate();

    @Override
    public final void applyInterest() {
        this.balance += this.balance * calculateInterestRate();
    }
}
