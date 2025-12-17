package accounts;

public class ClosedState implements AccountState {

    @Override
    public void deposit(AbstractAccount account, double amount) {
        throw new IllegalStateException("Account is closed");
    }

    @Override
    public void withdraw(AbstractAccount account, double amount) {
        throw new IllegalStateException("Account is closed");
    }
}
