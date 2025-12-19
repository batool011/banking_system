package transactions.processor;

import transactions.Transaction;

public class TransferProcessor implements TransactionProcessor{
    public void execute(Transaction t) {
        t.getFromAccount().withdraw(t.getAmount());
        t.getToAccount().deposit(t.getAmount());
    }
}
