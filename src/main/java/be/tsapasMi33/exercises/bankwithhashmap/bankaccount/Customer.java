package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

import be.tsapasMi33.exercises.bankwithhashmap.bankaccount.exceptions.InsufficientFundsException;

public interface Customer {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    void transfer(double amount, Account target);
    double getBalance();
}
