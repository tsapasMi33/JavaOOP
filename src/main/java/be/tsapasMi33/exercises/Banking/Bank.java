package be.tsapasMi33.exercises.Banking;

import java.util.ArrayList;

public class Bank {

    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
    }
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public boolean addBranch(String name) {
        if (findBranch(name) == null) {
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        if (findBranch(branchName) != null){
            for (Branch branch : branches) {
                if (branch.getName().equalsIgnoreCase(branchName)) {
                    return branch.newCustomer(customerName, initialTransaction);
                }
            }
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        if (findBranch(branchName) != null){
            for (Branch branch : branches) {
                if (branch.getName().equalsIgnoreCase(branchName)) {
                    return branch.addCustomerTransaction(customerName, transaction);
                }
            }
        }
        return false;
    }

    private Branch findBranch(String branchName){
        for (Branch branch : branches) {
            if (branch.getName().equalsIgnoreCase(branchName)){
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            int i = 1;
            if (printTransactions) {
                for (Customer customer : branch.getCustomers()) {
                    System.out.printf("Customer: %s[%d]%n", customer.getName(), i++);
                    System.out.println("Transactions");
                    int j = 1;
                    for (double transaction : customer.getTransactions()) {
                        System.out.printf("[%d]  Amount %.2f%n", j++, transaction);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
