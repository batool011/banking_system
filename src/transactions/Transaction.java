package transactions;

import accounts.Account;

public class Transaction {
    public double amount;
    private String id;
    private Account fromAccount;
    private Account toAccount;
    private TransactionType type;
    public Transaction(double amount) {
        this.amount = amount;
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
