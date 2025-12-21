package accounts;


public class InvestmentAccount extends AbstractAccount {

    private double withdrawFeeRate; // مثال 2%

    public InvestmentAccount(String accountId,
                             double balance,
                             double withdrawFeeRate) {
        super(accountId, balance);
        this.withdrawFeeRate = withdrawFeeRate;
        this.state = new ActivState();
    }

    public double getWithdrawFeeRate() {
        return withdrawFeeRate;
    }

    public void applyProfit(double profitAmount) {
        addBalance(profitAmount);
    }
}
