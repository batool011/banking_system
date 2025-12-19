package transactions.processor;

import transactions.Transaction;

public interface TransactionProcessor {
    void execute(Transaction transaction);
}
