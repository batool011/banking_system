package accounts;

public class ClosedState implements AccountState {

    @Override
    public void deposit(SavingAccount account, double amount) {
        throw new IllegalStateException("Account is closed");

    }

    @Override
    public void withdraw(SavingAccount account, double amount) {
        throw new IllegalStateException("Account is closed");

    }
}
