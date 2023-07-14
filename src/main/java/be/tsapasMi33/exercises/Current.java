package be.tsapasMi33.exercises;

public class Current {
    static long ibanCounter = 283033000000000L;

    private String iban;
    private double balance;
    private double line;
    private Person owner;

    public Current(Person owner) {
        this.iban = "BE" + String.valueOf(ibanCounter++);
        this.owner = owner;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }

    public double getLine() {
        return line;
    }

    public Person getOwner() {
        return owner;
    }

    public void setLine(double line) {
        if (line >= 0) {
            this.line = line;
        }
    }

    public void withdraw(double amount) {
        if(amount <= balance + line) {
            balance -= amount;
            System.out.println("Withdraw Successful.");
            System.out.println("New Balance = " + balance);
        } else {
            System.out.println("Insufficient Funds");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void transfer(double amount, Current target) {
        if(amount <= balance + line) {
            balance -= amount;
            target.deposit(amount);
            System.out.println("Transfer Successful.");
            System.out.println("New Balance = " + balance);
        } else {
            System.out.println("Insufficient Funds");
            System.out.println("Transfer Cancelled");
        }
    }

    @Override
    public String toString() {
        return "Current{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                ", line=" + line +
                "\nowner=" + owner.toString() +
                '}';
    }
}
