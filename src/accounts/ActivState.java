package accounts;

public class ActivState implements AccountState {

    @Override
    public void deposit(AbstractAccount account, double amount) {
        account.addBalance(amount);
    }

    @Override
    public void withdraw(AbstractAccount account, double amount) {
        account.reduceBalance(amount);
    }
}
