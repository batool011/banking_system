package interest;

public class SimpleInterestStrategy implements InterestStrategy {

    @Override
    public double calculateInterest(double balance) {
        return balance * 0.03;
    }
}
