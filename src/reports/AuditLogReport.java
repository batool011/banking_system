package reports;

import core.BankSystem;
import transactions.Transaction;

public class AuditLogReport implements Report {

    private BankSystem bankSystem;

    public AuditLogReport(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @Override
    public void generate() {
        System.out.println("=== AUDIT LOG REPORT ===");

        for (Transaction t : bankSystem.getTransactions()) {
            System.out.println(
                    "Transaction: " + t.getType() +
                            " | Amount: " + t.getAmount()
            );
        }
    }
}
