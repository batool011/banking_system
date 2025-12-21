package security;

public class CustumerAccess implements AccessStrategy {

    @Override
    public boolean canProcessTransaction() {
        return true;
    }

    @Override
    public boolean canViewReports() {
        return false;
    }
}
