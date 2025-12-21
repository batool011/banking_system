package transactions.processor;

import transactions.Transaction;

public class DepositProcessor implements TransactionProcessorj {
    public void execute(Transaction t) {
        t.getToAccount().deposit(t.getAmount());
    }
}
