package LowLevelDesign.Design_Streaming_Netflix.Subscription;

public class OneMonth extends Subscription{

    public OneMonth(SubScriptionType subscriptionType) {
        super(subscriptionType);
    }

    public void buySubscription() {
        System.out.println(subscriptionType + " subscription purchased.");
    }
}
