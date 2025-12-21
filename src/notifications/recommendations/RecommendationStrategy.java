package recommendations;

import transactions.Transaction;
import java.util.List;

public interface RecommendationStrategy {
    String recommend(List<Transaction> transactions);
}
