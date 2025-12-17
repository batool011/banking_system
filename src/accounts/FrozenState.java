package accounts;

public class FrozenState implements AccountState {

    @Override
    public void deposit(AbstractAccount account, double amount) {
        throw new IllegalStateException("Account is frozen");
    }

    @Override
    public void withdraw(AbstractAccount account, double amount) {
        throw new IllegalStateException("Account is frozen");
    }
}
