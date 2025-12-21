package security;

public class ManagerAccess implements AccessStrategy {

    @Override
    public boolean canProcessTransaction() {
        return true;
    }

    @Override
    public boolean canViewReports() {
        return true;
    }
}
