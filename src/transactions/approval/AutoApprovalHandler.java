package transactions.approval;

import transactions.Transaction;

public class AutoApprovalHandler extends ApprovalHandler {

    @Override
    public boolean approve(Transaction transaction) {
        if (transaction.amount <= 1000) {
            System.out.println("Transaction auto-approved");
            return true;
        } else if (next != null) {
            next.approve(transaction);
        }
        return false;
    }
}
