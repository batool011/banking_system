package accounts.interest;

import accounts.AbstractAccount;
import interest.InterestPolicy;

public class SavingInterestPolicy implements InterestPolicy {

    private final double rate;

    public SavingInterestPolicy(double rate) {
        this.rate = rate;
    }

    @Override
    public void apply(AbstractAccount account) {
        double interest = account.getBalance() * rate;
        account.addBalance(interest);
    }
}
