package accounts;

public abstract class AbstractAccount implements Account {

    protected String accountId;
    protected double balance;
    protected AccountState state;

    public AbstractAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.state = new ActivState(); // default
    }

    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        state.deposit(this, amount);
    }

    @Override
    public void withdraw(double amount) {
        state.withdraw(this, amount);
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void reduceBalance(double amount) {
        balance -= amount;
    }

    @Override
    public void setState(AccountState state) {
        this.state = state;
    }

    @Override
    public AccountState getState() {
        return state;
    }
}
