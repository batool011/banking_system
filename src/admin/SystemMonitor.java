package admin;
import accounts.Account;
import accounts.ActivState;
import core.BankSystem;

public class SystemMonitor {

    private BankSystem bankSystem;

    public SystemMonitor(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }


    public int activeAccounts() {
        int count = 0;
        for (Account acc : bankSystem.getAccounts()) {
            if (acc.getState() instanceof ActivState) {
                count++;
            }
        }
        return count;
    }

    public int todayTransactions() {
        return bankSystem.getTransactions().size();
    }
}
