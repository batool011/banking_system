package transactions;

public class ManagerApprovalHandler extends ApprovalHandler {

    @Override
    public void approve(Transaction transaction) {
        if (transaction.amount > 1000) {
            System.out.println("Transaction approved by manager");
        }
    }
}
