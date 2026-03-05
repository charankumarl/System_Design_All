package LowLevelDesign.Kafka_Pub_Sub;

public class SimpleSubscriber {

    private final String id;
    public int offset;

    public SimpleSubscriber(String id, int offset) {
        this.id = id;
        this.offset = offset;
    }

    public String getId() {
        return id;
    }

    public void consume(Message message) throws InterruptedException {
        // Processing the received message.
        System.out.println("Subscriber " + id + " received: " + message.getMessage());
        // Simulate processing delay if desired
        Thread.sleep(500);
    }
}
