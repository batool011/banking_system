package notifications.support;

import java.util.ArrayList;
import java.util.List;

public class SupportService {

    private List<SupportTicket> tickets = new ArrayList<>();

    public void createTicket(SupportTicket ticket) {
        tickets.add(ticket);
    }

    public List<SupportTicket> getAllTickets() {
        return tickets;
    }
}
