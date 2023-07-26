package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

import java.util.HashMap;

public class Bank {
    private final String name;
    private HashMap<String, Account> accounts;

    public Bank(String name) {
        this.name = name;
        accounts = new HashMap<>();
    }

    public void addAccount(Account newAccount) {
        newAccount.addOnNegativeEvent(c -> this.onNegativeBalanceAction(c));
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

    private void onNegativeBalanceAction(Account account){
        System.out.println("Account with IBAN " + account.getIban() + " has a negative balance!");
    }
}