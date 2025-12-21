package reports;

public abstract class ReportDecorator implements Report {

    protected Report wrappedReport;

    public ReportDecorator(Report report) {
        this.wrappedReport = report;
    }

    @Override
    public void generate() {
        wrappedReport.generate();
    }
}
