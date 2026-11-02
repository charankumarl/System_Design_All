package LowLevelDesign.Design_Streaming_Netflix.Subscription;

public class SubscriptionFactory {

    public static Subscription getSubscription(SubScriptionType subscriptionType) {
        switch (subscriptionType) {
            case ONE:
                return new OneMonth(subscriptionType);
            case SIX:
                return new SixMonth(subscriptionType);
            default:
                throw new IllegalArgumentException("Invalid subscription type");
        }
    }
}
