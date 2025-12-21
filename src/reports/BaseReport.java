package reports;

import core.BankSystem;

public class BaseReport implements Report {

    protected BankSystem bankSystem;

    public BaseReport(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @Override
    public void generate() {
       System.out.println("=== BANK REPORT ===\n");
    }
}
