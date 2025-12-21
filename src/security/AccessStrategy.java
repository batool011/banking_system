package security;

public interface AccessStrategy {
    boolean canProcessTransaction();
    boolean canViewReports();
}
