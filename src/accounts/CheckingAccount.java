package accounts;

public class CheckingAccount extends AbstractAccount {

    private double overdraftLimit;

    public CheckingAccount(String accountId,
                           double balance,
                           double overdraftLimit) {
        super(accountId, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
