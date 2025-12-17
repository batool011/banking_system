package accounts;

public interface AccountState {
    void deposit(AbstractAccount account, double amount);
    void withdraw(AbstractAccount account, double amount);
}
