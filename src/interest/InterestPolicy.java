package interest;

import accounts.AbstractAccount;

public interface InterestPolicy {
    void apply(AbstractAccount account);
}
