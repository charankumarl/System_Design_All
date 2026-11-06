package fine;

import fine.concrete.FlatRateFineStrategy;
import fine.concrete.WeekendFreeFineStrategy;

public class FineStrategyFactory {
    public static FineStrategy getStrategy(FineStrategyType type) {
        switch (type) {
            case FLAT_RATE:
                return new FlatRateFineStrategy();
            case WEEKEND_FREE:
                return new WeekendFreeFineStrategy();
            default:
                throw new IllegalArgumentException("Unknown strategy: " + type);
        }
    }
}
