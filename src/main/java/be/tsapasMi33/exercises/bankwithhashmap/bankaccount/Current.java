package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;

public class Current extends Account {
    private double line;

    public Current(Person owner) {
        super(owner);
    }


    public double getLine() {
        return line;
    }


    public void setLine(double line) {
        if (line >= 0) {
            this.line = line;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + line) {
            super.withdraw(amount);
        }
    }

    @Override
    public void transfer(double amount, Account target) {
        if (amount <= getBalance() + line) {
            super.transfer(amount, target);
        }
    }

    @Override
    public String toString() {
        return owner + "'s " + this.getClass().getSimpleName() + "\n" + "-".repeat(10) + getIban() + "-".repeat(10) + "\nBalance: " + getBalance() +"\n\n";
    }
}
