package accounts.interest;

import accounts.AbstractAccount;
import interest.InterestPolicy;

public class InvestmentProfitPolicy implements InterestPolicy {

    @Override
    public void apply(AbstractAccount account) {
        // مثال بسيط (ربح ثابت)
        account.addBalance(500);
    }
}
