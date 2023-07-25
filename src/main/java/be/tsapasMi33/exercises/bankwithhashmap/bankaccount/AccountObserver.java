package be.tsapasMi33.exercises.bankwithhashmap.bankaccount;
@FunctionalInterface
public interface AccountObserver {
    void handleNotification(Account account);
}
