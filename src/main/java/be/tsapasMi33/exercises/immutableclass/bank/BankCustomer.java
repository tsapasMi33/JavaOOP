package be.tsapasMi33.exercises.immutableclass.bank;

import be.tsapasMi33.exercises.immutableclass.bank.BankAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private static int lastCustomerId = 10000000;
    private final String name;
    private final int id;
    private final List<BankAccount> accounts = new ArrayList<>();

    public BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        this.id = lastCustomerId++;
        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAmount));
        accounts.add(new BankAccount(BankAccount.AccountType.SAVINGS, savingsAmount));
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public String toString() {
        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name,id,String.join("\n\t",accountStrings));
    }
}
