package banking_system;

import interest.*;
import notifications.*;
import transactions.*;

public class Main {

    public static void main(String[] args) {

        BankFacade bank = new BankFacade();

        bank.setInterestStrategy(new SimpleInterestStrategy());

        bank.addObserver(new EmailNotifier());
        bank.addObserver(new SMSNotifier());

        bank.processTransaction(new Transaction(1500));
    }
}
