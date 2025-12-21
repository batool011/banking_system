package core;

import accounts.Account;
import accounts.ActivState;
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
    public Account getAccountById(String accountId) {
        for (Account acc : accounts) {
            if (acc.getAccountId().equals(accountId)) {
                return acc;
            }
        }
        return null;
    }
    public int getActiveAccountsCount() {
        int count = 0;
        for (Account acc : accounts) {
            if (acc.getState() instanceof ActivState) {
                count++;
            }
        }
        return count;
    }


}
