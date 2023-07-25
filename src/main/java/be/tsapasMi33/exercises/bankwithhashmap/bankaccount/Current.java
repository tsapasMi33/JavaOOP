package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

import be.tsapasMi33.exercises.bankwithhashmap.bankaccount.exceptions.InsufficientFundsException;

import java.util.ArrayList;
import java.util.List;

public class Current extends Account {
    private double line;
    private List<WentNegativeSubscriber> wentNegativeEvents;

    public Current(Person owner) {
        this(owner, 0.0);
    }

    public Current(Person owner, double initialAmount){
        this(owner, initialAmount,0.0);
    }

    public Current(Person owner, double initialAmount, double initialLine) {
        super(owner, initialAmount);
        line = initialLine;
        wentNegativeEvents = new ArrayList<>();
    }

    public double getLine() {
        return line;
    }



    public void setLine(double line) {
        if (line >= 0) {
            this.line = line;
        } else {
            throw new IllegalStateException("The line amount cannot be negative!");
        }
    }

    @Override
    protected double calculateInterestRate() {
        return this.getBalance() < 0 ? 0.0975 : 0.03;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= getBalance() + line) {
            super.withdraw(amount);
            if (this.getBalance() < 0) {
                raiseWentNegativeEvent();
            }
        } else {
            throw new InsufficientFundsException();
        }
    }

    @Override
    public void transfer(double amount, Account target) {
        if (amount <= getBalance() + line) {
            super.transfer(amount, target);
        }
    }

    @Override
    public String toString() {
        return owner + "'s " + this.getClass().getSimpleName() + "\n" + "-".repeat(10) + getIban() + "-".repeat(10) + "\nBalance: " + getBalance() +"\n\n";
    }

    public void addWentNegativeSubscriber(WentNegativeSubscriber toAdd){
        wentNegativeEvents.add(toAdd);
    }

    public void raiseWentNegativeEvent(){
        for (WentNegativeSubscriber s : wentNegativeEvents){
            s.WentNegative(this);
        }
    }
}
