package admin;

public class DashboardFacade {

    private SystemMonitor monitor = new SystemMonitor();

    public void showDashboard() {
        System.out.println("Active Accounts: " + monitor.activeAccounts());
        System.out.println("Today's Transactions: " + monitor.todayTransactions());
    }
}
