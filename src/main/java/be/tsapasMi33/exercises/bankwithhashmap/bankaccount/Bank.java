package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

import java.util.HashMap;

public class Bank implements WentNegativeSubscriber {
    private final String name;
    private HashMap<String, Account> accounts;

    public Bank(String name) {
        this.name = name;
        accounts = new HashMap<>();
    }

    public void addAccount(Account newAccount) {
        accounts.put(newAccount.getIban(), newAccount);
    }

    public boolean deleteAccount(String iban) {
        if (accounts.containsKey(iban)) {
            accounts.remove(iban);
            return true;
        }
        return false;
    }

    public HashMap<String, Account> getAccounts() {
        return (HashMap<String, Account>) accounts.clone();
    }

    public Account getAccount(String iban) {
        return accounts.get(iban);
    }

    public void printAccounts() {
        for (Account c : accounts.values()) {
            System.out.println(c);
        }
    }

    @Override
    public void WentNegative(Account account) {
        System.out.println("coucou");
    }
}
