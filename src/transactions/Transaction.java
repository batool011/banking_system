package transactions;

import accounts.Account;

public class Transaction {
    public double amount;
    private Account fromAccount;
    private Account toAccount;
    private TransactionType type;
    public Transaction(double amount) {
        this.amount = amount;
    }

    public Transaction(double amount, Account fromAccount,Account toAccount,TransactionType type) {
        this.amount=amount;
        this.fromAccount=fromAccount;
        this.toAccount=toAccount;
        this.type=type;
    }

    public Account getToAccount() {
        return this.toAccount;
    }
    public Account getFromAccount() {
        return this.fromAccount;
    }

    public TransactionType getType() {
        return this.type;
    }

    public double getAmount() {
        return amount;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
