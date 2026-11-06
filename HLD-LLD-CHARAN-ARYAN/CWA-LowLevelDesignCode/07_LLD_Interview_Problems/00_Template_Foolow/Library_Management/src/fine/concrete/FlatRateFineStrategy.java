package fine.concrete;

import fine.FineStrategy;

public class FlatRateFineStrategy implements FineStrategy {
    private static final double RATE_PER_DAY = 5.0;

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * RATE_PER_DAY;
    }
}
