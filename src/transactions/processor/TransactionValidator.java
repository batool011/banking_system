package transactions.processor;

import transactions.Transaction;

public class TransactionValidator {

    public static void validate(Transaction transaction) {

        if (transaction.getType() == null) {
            throw new IllegalArgumentException("Transaction type is required");
        }

        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        switch (transaction.getType()) {

            case DEPOSIT:
                if (transaction.getToAccount() == null) {
                    throw new IllegalStateException("Deposit requires target account");
                }
                break;

            case WITHDRAW:
                if (transaction.getFromAccount() == null) {
                    throw new IllegalStateException("Withdraw requires source account");
                }
                break;

            case TRANSFER:
                if (transaction.getFromAccount() == null ||
                        transaction.getToAccount() == null) {
                    throw new IllegalStateException("Transfer requires both accounts");
                }
                break;
        }
    }
}
