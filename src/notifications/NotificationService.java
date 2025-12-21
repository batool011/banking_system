package notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void notifyAll(String message) {
        observers.forEach(o -> o.notify(message));
    }
}
