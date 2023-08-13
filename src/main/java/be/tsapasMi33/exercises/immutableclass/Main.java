package be.tsapasMi33.exercises.immutableclass;

import be.tsapasMi33.exercises.immutableclass.bank.Bank;
import be.tsapasMi33.exercises.immutableclass.bank.BankAccount;
import be.tsapasMi33.exercises.immutableclass.bank.BankCustomer;
import be.tsapasMi33.exercises.immutableclass.dto.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);
//
//        BankCustomer joe = new BankCustomer("Joe",500, 10000);
//        System.out.println(joe);

        Bank bank = new Bank(3214567);
        bank.addCustomer("Joe",500, 10000);
        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);

        if (bank.doTransaction(joe.getId(),BankAccount.AccountType.CHECKING, 35)){
            System.out.println(joe);
        }

        if (bank.doTransaction(joe.getId(),BankAccount.AccountType.CHECKING, -535)){
            System.out.println(joe);
        }

        BankAccount checking = joe.getAccount(BankAccount.AccountType.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k, v) -> System.out.println(k + ": " + v));

//        System.out.println("---------------------------");
//        for (var tx : transactions.values()) {
//            tx.setCustomerId(2);
//            tx.setTransactionAmount(10000);
//        }
//        transactions.forEach((k, v) -> System.out.println(k + ": " + v));

        joe.getAccount(BankAccount.AccountType.CHECKING).getTransactions().clear();
        System.out.println("---------------------------");
        joe.getAccount(BankAccount.AccountType.CHECKING).getTransactions().forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
