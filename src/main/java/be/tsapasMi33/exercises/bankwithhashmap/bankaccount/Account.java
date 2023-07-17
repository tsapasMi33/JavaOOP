package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

public abstract class Account {
    protected static long ibanCounter = 283033000000000L;
    private final String iban;
    protected final Person owner;
    private double balance;

    public Account(Person owner) {
        this.owner = owner;
        this.iban = "BE" + ibanCounter++;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public String getIban() {
        return iban;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void transfer(double amount, Account target) {
        target.deposit(amount);
        balance -= amount;
    }
}
