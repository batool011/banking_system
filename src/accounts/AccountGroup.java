package accounts;

import java.util.ArrayList;
import java.util.List;

public class AccountGroup implements Account {

    private String groupId;
    private List<Account> accounts = new ArrayList<>();
    private AccountState state = new ActivState();

    public AccountGroup(String groupId) {
        this.groupId = groupId;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public String getAccountId() {
        return groupId;
    }

    @Override
    public double getBalance() {
        return accounts.stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    @Override
    public void deposit(double amount) {
        state.deposit(null, amount);
        accounts.forEach(a -> a.deposit(amount));
    }

    @Override
    public void withdraw(double amount) {
        state.withdraw(null, amount);
        accounts.forEach(a -> a.withdraw(amount));
    }

    @Override
    public void setState(AccountState state) {
        this.state = state;
        accounts.forEach(a -> a.setState(state));
    }

    @Override
    public AccountState getState() {
        return state;
    }
}
