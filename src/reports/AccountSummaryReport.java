package reports;

import accounts.Account;
import core.BankSystem;

public class AccountSummaryReport implements Report {

    private BankSystem bankSystem;

    public AccountSummaryReport(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @Override
    public void generate() {
        System.out.println("=== Account Summary Report ===");
        for (Account acc : bankSystem.getAccounts()) {
            System.out.println(acc.getAccountId() + " -> " + acc.getBalance());
        }
    }
}
