package accounts;

public class LoanAccount extends AbstractAccount {

    private double interestRate;

    public LoanAccount(String accountId,
                       double loanAmount,
                       double interestRate) {
        super(accountId, -loanAmount); // دين
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = Math.abs(balance) * interestRate;
        reduceBalance(interest); // يزيد الدين
    }
}
