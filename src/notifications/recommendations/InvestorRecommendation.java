package notifications.recommendations;

import transactions.Transaction;
import java.util.List;

public class InvestorRecommendation implements RecommendationStrategy {

    @Override
    public String recommend(List<Transaction> transactions) {
        return "You may benefit from Investment Accounts.";
    }
}
