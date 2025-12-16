package banking_system;

import accounts.*;
import interest.*;
import notifications.*;
import transactions.*;

import java.util.ArrayList;
import java.util.List;

public class BankFacade {

    private InterestStrategy interestStrategy;
    private List<NotificationObserver> observers = new ArrayList<>();

    public void setInterestStrategy(InterestStrategy strategy) {
        this.interestStrategy = strategy;
    }

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void processTransaction(Transaction transaction) {

        ApprovalHandler auto = new AutoApprovalHandler();
        ApprovalHandler manager = new ManagerApprovalHandler();
        auto.setNext(manager);

        auto.approve(transaction);

        notifyObservers("Transaction processed: " + transaction.amount);
    }

    private void notifyObservers(String message) {
        observers.forEach(o -> o.update(message));
    }
}
