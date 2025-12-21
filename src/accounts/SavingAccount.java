package accounts;

public class SavingAccount extends AbstractAccount {

    private double interestRate;
    private double withdrawLimit;

    public SavingAccount(String accountId,
                         double balance,
                         double interestRate,
                         double withdrawLimit) {
        super(accountId, balance);
        this.interestRate = interestRate;
        this.withdrawLimit = withdrawLimit;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        addBalance(interest);
    }
}
