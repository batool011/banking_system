package reports;

import core.BankSystem;

public class AuditLogReport implements Report {

    private BankSystem bankSystem;

    public AuditLogReport(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @Override
    public void generate() {
        System.out.println("=== Audit Log Report ===");
        System.out.println("Total transactions: " +
                bankSystem.getTransactions().size());
    }
}
