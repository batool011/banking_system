package reports;

import core.BankSystem;
import transactions.Transaction;

public class DailyTransactionReport implements Report {

    private BankSystem bankSystem;

    public DailyTransactionReport(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @Override
    public void generate() {
        System.out.println("=== Daily Transactions Report ===");
        for (Transaction t : bankSystem.getTransactions()) {
            System.out.println(t.getType() + " : " + t.getAmount());
        }
    }
}
