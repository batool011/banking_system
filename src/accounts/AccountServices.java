package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountServices {

    private Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(Account account) {
        accounts.put(account.getAccountId(), account);
        System.out.println("account");
        System.out.println(account);
        return account;
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void closeAccount(String accountId) {
        Account account = accounts.get(accountId);
        account.setState(new ClosedState());
    }
}
