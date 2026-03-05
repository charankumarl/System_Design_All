package LowLevelDesign.Design_Streaming_Netflix.Subscription;

public class SixMonth extends Subscription {

    public SixMonth(SubScriptionType subscriptionType) {
        super(subscriptionType);
    }

    public void buySubscription() {
        System.out.println(subscriptionType + " subscription purchased.");
    }
}
