

import accounts.Account;
import transactions.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {

    private List<Account> accounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
