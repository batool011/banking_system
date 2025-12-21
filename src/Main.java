import accounts.*;
import admin.BankFacade;
import core.BankSystem;
import notifications.*;
import transactions.processor.TransactionProcessorFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankSystem bankSystem = new BankSystem();

        // Notifications
        NotificationService notificationService = new NotificationService();
        notificationService.addObserver(new SMSNotification());
        notificationService.addObserver(new EmailNotification());

        // Processor + Facade
        TransactionProcessorFactory processor =
                new TransactionProcessorFactory(bankSystem);

        BankFacade facade =
                new BankFacade(bankSystem, processor, notificationService);

        // =====================
        // CREATE ACCOUNTS
        // =====================
        System.out.println("How many accounts to create?");
        int accCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < accCount; i++) {

            System.out.println("\nCreate Account " + (i + 1));

            System.out.print("Account ID: ");
            String id = scanner.nextLine();

            System.out.print("Initial Balance: ");
            double balance = scanner.nextDouble();

            System.out.println("""
        Choose Account Type:
        1 - Saving
        2 - Checking
        3 - Loan
        4 - Investment
        """);

            int typeInput = scanner.nextInt();
            scanner.nextLine();

            AccountType type;

            switch (typeInput) {
                case 1 -> type = AccountType.SAVING;
                case 2 -> type = AccountType.CHECKING;
                case 3 -> type = AccountType.LOAN;
                case 4 -> type = AccountType.INVESTMENT;
                default -> throw new IllegalArgumentException("Invalid account type");
            }

            Account acc = AccountFactory.create(
                    type,
                    id,
                    balance
            );

            bankSystem.addAccount(acc);
            System.out.println("✅ Account created successfully");
        }


        // =====================
        // LOGIN
        // =====================
        System.out.println("\nLogin as:");
        System.out.println("1 - User");
        System.out.println("2 - Admin");
        int role = scanner.nextInt();
        scanner.nextLine();

        // =====================
        // USER MENU
        // =====================
        if (role == 1) {

            boolean running = true;

            while (running) {

                System.out.println("\nUSER MENU");
                System.out.println("1 - Deposit");
                System.out.println("2 - Withdraw");
                System.out.println("3 - Transfer");
                System.out.println("4 - View Balance");
                System.out.println("0 - Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Account ID: ");
                        facade.deposit(scanner.nextLine(), askAmount(scanner));
                        break;

                    case 2:
                        System.out.print("Account ID: ");
                        facade.withdraw(scanner.nextLine(), askAmount(scanner));
                        break;

                    case 3:
                        System.out.print("From Account: ");
                        String from = scanner.nextLine();
                        System.out.print("To Account: ");
                        String to = scanner.nextLine();
                        facade.transfer(from, to, askAmount(scanner));
                        break;

                    case 4:
                        System.out.print("Account ID: ");
                        System.out.println(
                                "Balance: " +
                                        facade.viewBalance(scanner.nextLine())
                        );
                        break;

                    case 0:
                        running = false;
                        break;
                }
            }
        }

        // =====================
        // ADMIN MENU
        // =====================
        else {

            System.out.println("\nADMIN DASHBOARD");
            System.out.println("Active Accounts: " + facade.getActiveAccounts());
            System.out.println("Total Transactions: " + facade.getTransactionsCount());
            System.out.println("ADMIN REPORTS");
            System.out.println("1 - Daily Transactions");
            System.out.println("2 - Account Summary");
            System.out.println("3 - Audit Logs");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    facade.showDailyTransactionsReport();
                    break;
                case 2:
                    facade.showAccountSummaryReport();
                    break;
                case 3:
                    facade.showAuditLogReport();
                    break;
            }

        }

        System.out.println("\n=== SYSTEM END ===");
    }

    private static double askAmount(Scanner scanner) {
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }


}
