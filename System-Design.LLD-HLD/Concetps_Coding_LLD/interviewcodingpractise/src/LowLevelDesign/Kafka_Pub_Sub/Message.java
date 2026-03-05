package LowLevelDesign.Kafka_Pub_Sub;

public class Message {

    private final String message;
    private final String topicId;
    // int partition in future
    // int key

    public Message(String message, String topicId) {
        this.message = message;
        this.topicId = topicId;
    }
    public String getMessage() {
        return message;
    }
}
