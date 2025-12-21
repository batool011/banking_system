package accounts;

public class ActivState implements AccountState {

    @Override
    public void deposit(AbstractAccount account, double amount) {
        account.addBalance(amount);
        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    @Override
    public void withdraw(AbstractAccount account, double amount) {
        account.reduceBalance(amount);
        System.out.println("Withdraw successful. New balance: " + account.getBalance());
    }
}
