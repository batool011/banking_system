package accounts;

public class SuspendedState implements AccountState {

    @Override
    public void deposit(AbstractAccount account, double amount) {
        throw new IllegalStateException("Account is suspended");
    }

    @Override
    public void withdraw(AbstractAccount account, double amount) {
        throw new IllegalStateException("Account is suspended");
    }
}
