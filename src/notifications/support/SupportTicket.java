package notifications.support;

public class SupportTicket {

    private String ticketId;
    private String customerId;
    private String message;
    private TicketStatus status;

    public SupportTicket(String id, String customerId, String message) {
        this.ticketId = id;
        this.customerId = customerId;
        this.message = message;
        this.status = TicketStatus.OPEN;
    }

    public void updateStatus(TicketStatus status) {
        this.status = status;
    }
}
