package reports;

public class LoggingDecorator extends ReportDecorator {

    public LoggingDecorator(Report report) {
        super(report);
    }

    @Override
    public void generate() {
        System.out.println("LOG: Report generation started");
        super.generate();
        System.out.println("LOG: Report generation finished");
    }
}
