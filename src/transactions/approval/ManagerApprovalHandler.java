package transactions.approval;

import transactions.Transaction;

public class ManagerApprovalHandler extends ApprovalHandler {

    @Override
    public boolean approve(Transaction transaction) {
        if (transaction.amount > 1000) {
            System.out.println("Transaction approved by manager");
            return true;
        }
        return false;
    }
}
