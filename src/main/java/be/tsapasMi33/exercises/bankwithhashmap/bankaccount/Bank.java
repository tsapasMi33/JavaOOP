package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

import java.util.HashMap;

public class Bank implements AccountObserver {
    private final String name;
    private HashMap<String, Account> accounts;

    public Bank(String name) {
        this.name = name;
        accounts = new HashMap<>();
    }

    public void addAccount(Account newAccount) {
        accounts.put(newAccount.getIban(), newAccount);
        newAccount.addObserver(this);
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
    public void handleNotification(Account account) {
        onNegativeBalance(account);
    }

    private void onNegativeBalance(Account account){
        if (account instanceof Current && account.getBalance() < 0) {
            System.out.println("Account with IBAN " + account.getIban() + " has a negative balance!");
        }
    }
}