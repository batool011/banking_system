package interest;

import accounts.AbstractAccount;

public class LoanInterestPolicy implements InterestPolicy {

    private final double rate;

    public LoanInterestPolicy(double rate) {
        this.rate = rate;
    }

    @Override
    public void apply(AbstractAccount account) {
        double interest = Math.abs(account.getBalance()) * rate;
        account.reduceBalance(interest); // يزيد الدين
    }
}
