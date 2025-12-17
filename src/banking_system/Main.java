package banking_system;

import accounts.*;
import interest.*;
import notifications.*;
import transactions.*;

public class Main {

    public static void main(String[] args) {

//        BankFacade bank = new BankFacade();
//
//        bank.setInterestStrategy(new SimpleInterestStrategy());
//
//        bank.addObserver(new EmailNotifier());
//        bank.addObserver(new SMSNotifier());
//
//        bank.processTransaction(new Transaction(1500));
       AccountServices service = new AccountServices();

        Account acc1 = new SavingAccount("A1", 1000);
        Account acc2 = new CheckingAccount("A2", 2000);

        AccountGroup family = new AccountGroup("FAM1");
        family.addAccount(acc1);
        family.addAccount(acc2);

        service.createAccount(acc1);
        service.createAccount(acc2);

        acc1.withdraw(200);
        acc1.setState(new FrozenState());
// acc1.deposit(100); ❌ exception

    }
}
