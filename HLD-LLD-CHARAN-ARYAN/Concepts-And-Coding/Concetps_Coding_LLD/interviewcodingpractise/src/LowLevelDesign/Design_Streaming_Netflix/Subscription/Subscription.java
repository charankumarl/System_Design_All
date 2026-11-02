package LowLevelDesign.Design_Streaming_Netflix.Subscription;

public abstract class Subscription {

    SubScriptionType subscriptionType;
    int id;
    static int idCounter = 0;  // common for all instances / objects

    public Subscription(SubScriptionType subscriptionType) {
        this.id = idCounter++;
        this.subscriptionType = subscriptionType;
    }

    public abstract void buySubscription();
}
