package reports;

public class TimestampDecorator extends ReportDecorator {

    public TimestampDecorator(Report report) {
        super(report);
    }

    @Override
    public void generate() {
        System.out.println("Generated at: " + java.time.LocalDateTime.now());
        super.generate();
    }
}
