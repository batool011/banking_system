package transactions.processor;

import transactions.Transaction;

public class TransferProcessor implements TransactionProcessorj {
    public void execute(Transaction t) {
        t.getFromAccount().withdraw(t.getAmount());
        t.getToAccount().deposit(t.getAmount());
    }
}
//package transactions;
//
//import accounts.Account;
//import transactions.approval.*;
//
//public class TransactionProcessor {
//
//    private ApprovalHandler approvalChain;
//
//    public TransactionProcessor() {
//        ApprovalHandler auto = new AutoApprovalHandler();
//        ApprovalHandler manager = new ManagerApprovalHandler();
//        auto.setNext(manager);
//        this.approvalChain = auto;
//    }
//
//    public void process(Transaction transaction) {
//
//        approvalChain.approve(transaction);
//
//        Account source = transaction.getSourceAccount();
//        Account target = transaction.getTargetAccount();
//
//        switch (transaction.getType()) {
//            case DEPOSIT:
//                target.deposit(transaction.getAmount());
//                break;
//            case WITHDRAW:
//                source.withdraw(transaction.getAmount());
//                break;
//            case TRANSFER:
//                source.withdraw(transaction.getAmount());
//                target.deposit(transaction.getAmount());
//                break;
//        }
//
//        System.out.println("Transaction processed");
//    }
//}
//////////////////////////
//Account a1 = new SavingsAccount("A1", 2000);
//Account a2 = new CheckingAccount("A2", 1000);
//
//Transaction t = new Transaction(
//        "T1",
//        TransactionType.TRANSFER,
//        a1,
//        a2,
//        1500
//);
//
//TransactionProcessor processor = new TransactionProcessor();
//processor.process(t);
/////////
//if (transaction.getAmount() > 5000) {
//        notificationService.notifyAll("Large transaction detected!");
//}
