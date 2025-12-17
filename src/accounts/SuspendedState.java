package accounts;

public class SuspendedState implements AccountState {

    @Override
    public void deposit(SavingAccount account, double amount) {
        throw new IllegalStateException("Account is suspended");

    }

    @Override
    public void withdraw(SavingAccount account, double amount) {
        throw new IllegalStateException("Account is suspended");

    }
}
