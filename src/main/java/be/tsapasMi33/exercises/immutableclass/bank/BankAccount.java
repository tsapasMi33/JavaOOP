package be.tsapasMi33.exercises.immutableclass.bank;

import be.tsapasMi33.exercises.immutableclass.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    public enum AccountType {CHECKING, SAVINGS}
    private final AccountType type;
    private double balance;
    private final Map<Long, Transaction> transactions;


    BankAccount(AccountType type, double balance) {
        this.type = type;
        this.balance = balance;
        transactions = new LinkedHashMap<>();
    }

    public AccountType getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public Map<Long, String> getTransactions() {
        Map<Long, String> txMap = new LinkedHashMap<>();
        for (var tx : transactions.entrySet()) {
            txMap.put(tx.getKey(), tx.getValue().toString());
        }
        return txMap;
    }

    void commitTransaction(int routingNumber, long transactionId, String customerId, double amount){
        balance += amount;
        transactions.put(transactionId, new Transaction(routingNumber, Integer.parseInt(customerId), transactionId, amount));
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(type, balance);
    }
}
