package reports;

import core.BankSystem;

public class DailyTransactionReport implements Report {

    private BankSystem bankSystem;

    public DailyTransactionReport(BankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    @Override
    public void generate() {
        System.out.println("Daily Transactions:");
        bankSystem.getTransactions()
                .forEach(t -> System.out.println(t.getType() + " - " + t.getAmount()));
    }
}
