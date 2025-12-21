package reports;

public class AccountSummaryReport implements ReportStrategy {

    @Override
    public void generate() {
        System.out.println("Account Summary Report Generated");
    }
}
