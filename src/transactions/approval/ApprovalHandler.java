package transactions.approval;

import transactions.Transaction;

public abstract class ApprovalHandler {

    protected ApprovalHandler next;

    public void setNext(ApprovalHandler next) {
        this.next = next;
    }

    public abstract boolean approve(Transaction transaction);
}
