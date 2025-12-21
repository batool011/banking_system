package notifications;

public class EmailNotification implements NotificationObserver {

    @Override
    public void notify(String message) {
        System.out.println("Email sent: " + message);
    }
}
