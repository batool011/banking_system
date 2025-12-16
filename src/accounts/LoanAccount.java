package accounts;

public class LoanAccount implements Account {

    private double loanAmount;

    public LoanAccount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public double getBalance() {
        return -loanAmount;
    }

    @Override
    public void deposit(double amount) {
        loanAmount -= amount; // تسديد
    }

    @Override
    public void withdraw(double amount) {
        loanAmount += amount; // قرض جديد
    }
}
