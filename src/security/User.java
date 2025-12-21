package security;


public class User {

    private String userId;
    private Role role;
    private AccessStrategy accessStrategy;

    public User(String id, Role role) {
        this.userId = id;
        this.role = role;
        this.accessStrategy = createStrategy(role);
    }

    private AccessStrategy createStrategy(Role role) {
        switch (role) {
            case CUSTOMER:
                return new CustumerAccess();
            case MANAGER:
                return new ManagerAccess();
//            case ADMIN:
//                return new AdminAccess();
            default:
                throw new IllegalStateException();
        }
    }

    public AccessStrategy getAccessStrategy() {
        return accessStrategy;
    }

    public Role getRole() {
        return role;
    }
}
