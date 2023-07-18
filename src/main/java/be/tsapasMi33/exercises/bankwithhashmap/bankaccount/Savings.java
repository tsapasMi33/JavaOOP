package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

import java.time.LocalDate;

public class Savings extends Account{
    private LocalDate lastWithdraw;

    public Savings(Person owner) {
        this(owner, 0.0);
    }

    public Savings(Person owner, double initialAmount){
        super(owner, 0.0);
    }

    public LocalDate getLastWithdraw() {
        return lastWithdraw;
    }

    private void setLastWithdraw(LocalDate lastWithdraw) {
        this.lastWithdraw = lastWithdraw;
    }

    @Override
    protected double calculateInterestRate() {
        return 0.045;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            super.withdraw(amount);
            setLastWithdraw(LocalDate.now());
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public void transfer(double amount, Account target) {
        if (amount <= getBalance()) {
            super.transfer(amount, target);
        }
    }

    @Override
    public String toString() {
        return owner + "'s " + this.getClass().getSimpleName() + "\n" + "-".repeat(10) + getIban() + "-".repeat(10) + "\nBalance: " + getBalance() +"\n\n";
    }
}
