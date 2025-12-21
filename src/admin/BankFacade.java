package banking_system;

import accounts.*;
import core.BankSystem;
import notifications.NotificationService;
import reports.*;
import transactions.*;
import transactions.processor.TransactionProcessorFactory;

public class BankFacade {

    private BankSystem bankSystem;
    private TransactionProcessorFactory processor;
    private NotificationService notificationService;

    public BankFacade(BankSystem bankSystem,
                      TransactionProcessorFactory processor,
                      NotificationService notificationService) {
        this.bankSystem = bankSystem;
        this.processor = processor;
        this.notificationService = notificationService;
    }

    // =====================
    // ACCOUNT CREATION
    // =====================
    public void createAccount(String id, double balance, int type) {

        Account acc;

        switch (type) {
            case 1:
                acc = new SavingAccount(id, balance);
                break;
            case 2:
                acc = new CheckingAccount(id, balance);
                break;
            default:
                throw new IllegalArgumentException("Invalid account type");
        }

        bankSystem.addAccount(acc);
        System.out.println("✅ Account created successfully");
    }

    // =====================
    // USER OPERATIONS
    // =====================
    public void deposit(String accountId, double amount) {

        Account to = bankSystem.getAccountById(accountId);

        Transaction t = new Transaction(
                amount,
                null,
                to,
                TransactionType.DEPOSIT
        );

        processor.process(t);
        notificationService.notifyAll(
                "Deposit completed to account " + accountId
        );
    }

    public void withdraw(String accountId, double amount) {

        Account from = bankSystem.getAccountById(accountId);

        Transaction t = new Transaction(
                amount,
                from,
                null,
                TransactionType.WITHDRAW
        );

        processor.process(t);
        notificationService.notifyAll(
                "Withdraw completed from account " + accountId
        );
    }

    public void transfer(String fromId, String toId, double amount) {

        Account from = bankSystem.getAccountById(fromId);
        Account to = bankSystem.getAccountById(toId);

        Transaction t = new Transaction(
                amount,
                from,
                to,
                TransactionType.TRANSFER
        );

        processor.process(t);
        notificationService.notifyAll(
                "Transfer completed from " + fromId + " to " + toId
        );
    }

    public double viewBalance(String accountId) {
        return bankSystem.getAccountById(accountId).getBalance();
    }

    // =====================
    // ADMIN OPERATIONS
    // =====================
    public int getActiveAccounts() {
        return bankSystem.getActiveAccountsCount();
    }

    public int getTransactionsCount() {
        return bankSystem.getTransactions().size();
    }
    private Report buildDailyReport() {
        Report report = new DailyTransactionReport(bankSystem);
        report = new TimestampDecorator(report);
        report = new LoggingDecorator(report);
        return report;
    }

    private Report buildAccountReport() {
        Report report = new AccountSummaryReport(bankSystem);
        report = new TimestampDecorator(report);
        return report;
    }

    private Report buildAuditReport() {
        Report report = new AuditLogReport(bankSystem);
        report = new LoggingDecorator(report);
        return report;
    }
    public void showDailyTransactionsReport() {
        buildDailyReport().generate();
    }

    public void showAccountSummaryReport() {
        buildAccountReport().generate();
    }

    public void showAuditLogReport() {
        buildAuditReport().generate();
    }


}
