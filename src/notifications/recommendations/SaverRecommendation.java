package notifications.recommendations;

import transactions.Transaction;
import java.util.List;

public class SaverRecommendation implements RecommendationStrategy {

    @Override
    public String recommend(List<Transaction> transactions) {
        return "We recommend opening a Savings Account with higher interest.";
    }
}
