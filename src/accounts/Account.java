package accounts;

public interface Account {
    String getAccountId();
    double getBalance();

    void deposit(double amount);
    void withdraw(double amount);

    void setState(AccountState state);
    AccountState getState();
}
