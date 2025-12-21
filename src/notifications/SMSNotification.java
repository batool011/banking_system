package notifications;

public class SMSNotification implements NotificationObserver {

    @Override
    public void notify(String message) {
        System.out.println("SMS sent: " + message);
    }
}
