package transactions.processor;

import transactions.TransactionType;

public class TransactionProcessorFactory {
    public static TransactionProcessor getProcessor(TransactionType type) {
        return switch (type) {
            case DEPOSIT -> new DepositProcessor();
            case WITHDRAWAL -> new WithdrawalProcessor();
            case TRANSFER -> new TransferProcessor();
        };
    }
}
