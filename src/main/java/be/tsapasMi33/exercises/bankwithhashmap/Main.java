package be.tsapasMi33.exercises.bankwithhashmap;

import be.tsapasMi33.exercises.bankwithhashmap.bankaccount.*;
import be.tsapasMi33.exercises.bankwithhashmap.bankaccount.exceptions.InsufficientFundsException;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("ING");

        Person p1 = new Person("Clark", "Kent");
        Person p2 = new Person("Tony", "Stark");


        bank.addAccount(new Current(p1));
        for (Account account : bank.getAccounts().values()) {
            System.out.println(account);
        }

        bank.addAccount(new Current(p2));
        bank.addAccount(new Savings(p2));
        for (Account account : bank.getAccounts().values()) {
            System.out.println(account);
        }

        Account c1 = bank.getAccount("BE283033000000000");
        Account c2 = bank.getAccount("BE283033000000002");

        try {
            c1.withdraw(1000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println(c1);
        }


        c1.deposit(2000);
        System.out.println(c1);
        c1.transfer(500, c2);
        System.out.println(c1);
        System.out.println(c2);
        if (c1 instanceof Current c) {
            c.setLine(2000);
        }
        try {
            c1.withdraw(2100.0);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(c1);
    }
}
