package transactions;

public class AutoApprovalHandler extends ApprovalHandler {

    @Override
    public void approve(Transaction transaction) {
        if (transaction.amount <= 1000) {
            System.out.println("Transaction auto-approved");
        } else if (next != null) {
            next.approve(transaction);
        }
    }
}
