package security;

public class User {

    private String userId;
    private Role role;

    public User(String id, Role role) {
        this.userId = id;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
