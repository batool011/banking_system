package transactions.processor;

import transactions.Transaction;

public class WithdrawalProcessor implements TransactionProcessor{
    public void execute(Transaction t) {
        t.getFromAccount().withdraw(t.getAmount());
    }
}
