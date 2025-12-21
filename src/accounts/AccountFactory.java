package accounts;

public class AccountFactory {

    public static Account create(AccountType type,
                                 String id,
                                 double balance) {

        switch (type) {

            case SAVING:
                return new SavingAccount(id, balance, 1000, 0.03);

            case CHECKING:
                return new CheckingAccount(id, balance, 2000);

            case LOAN:
                return new LoanAccount(id, balance, 0.05);

            case INVESTMENT:
                return new InvestmentAccount(id, balance, 0.02);

            default:
                throw new IllegalArgumentException("Unknown account type");
        }
    }
}
