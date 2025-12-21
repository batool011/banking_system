package transactions.processor;

import transactions.Transaction;
import transactions.approval.ApprovalHandler;
import transactions.approval.AutoApprovalHandler;
import transactions.approval.ManagerApprovalHandler;
import  core.BankSystem;

public class TransactionProcessorFactory {

    private BankSystem bankSystem;
    private ApprovalHandler approvalChain;

    public TransactionProcessorFactory(BankSystem bankSystem) {
        this.bankSystem = bankSystem;

        ApprovalHandler auto = new AutoApprovalHandler();
        ApprovalHandler manager = new ManagerApprovalHandler();
        auto.setNext(manager);
        approvalChain = auto;
    }

    public void process(Transaction transaction) {

        TransactionValidator.validate(transaction); 

        approvalChain.approve(transaction);

        switch (transaction.getType()) {
            case DEPOSIT:
                transaction.getToAccount().deposit(transaction.getAmount());
                break;
            case WITHDRAW:
                transaction.getFromAccount().withdraw(transaction.getAmount());
                break;
            case TRANSFER:
                transaction.getFromAccount().withdraw(transaction.getAmount());
                transaction.getToAccount().deposit(transaction.getAmount());
                break;
        }

        bankSystem.addTransaction(transaction);
        System.out.println("Transaction recorded in system");
    }

}
