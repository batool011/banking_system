package interest;

public class CompoundInterestStrategy implements InterestStrategy {

    @Override
    public double calculateInterest(double balance) {
        return balance * 0.05;
    }
}
