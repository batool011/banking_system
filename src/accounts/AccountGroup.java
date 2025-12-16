package accounts;

import java.util.ArrayList;
import java.util.List;

public class AccountGroup implements Account {

    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public double getBalance() {
        return accounts.stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    @Override
    public void deposit(double amount) {
        accounts.forEach(a -> a.deposit(amount));
    }

    @Override
    public void withdraw(double amount) {
        accounts.forEach(a -> a.withdraw(amount));
    }
}
