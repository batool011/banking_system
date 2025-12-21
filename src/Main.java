package banking_system;

import accounts.*;
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

            System.out.println("1 - Saving | 2 - Checking");
            int type = scanner.nextInt();
            scanner.nextLine();

            Account acc =
                    (type == 1)
                            ? new SavingAccount(id, balance)
                            : new CheckingAccount(id, balance);

            bankSystem.addAccount(acc);
            System.out.println("✅ Account created");
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
