package accounts;

public class LoanAccount extends AbstractAccount {

    public LoanAccount(String id, double loanAmount) {
        super(id, -loanAmount);
    }

    @Override
    public void deposit(double amount) {
        state.deposit(this, amount); // يسدّد القرض
    }

    @Override
    public void withdraw(double amount) {
        state.withdraw(this, amount); // قرض جديد
    }
}
