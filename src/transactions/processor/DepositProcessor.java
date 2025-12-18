package transactions.processor;

import transactions.Transaction;

public class DepositProcessor implements TransactionProcessor{
    public void execute(Transaction t) {
        t.getToAccount().deposit(t.getAmount());
    }
}
