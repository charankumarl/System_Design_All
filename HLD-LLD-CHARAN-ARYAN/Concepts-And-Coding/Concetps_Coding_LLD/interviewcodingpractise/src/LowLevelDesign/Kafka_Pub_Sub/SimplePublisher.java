package LowLevelDesign.Kafka_Pub_Sub;

public class SimplePublisher {

    private final String id;
    private final KafkaController kafkaController;

    public SimplePublisher(String id, KafkaController kafkaController) {
        this.id = id;
        this.kafkaController = kafkaController;
    }

    public String getId() {
        return id;
    }

    public void publish(String topicId, Message message) throws IllegalArgumentException {
        kafkaController.publish(this, topicId, message);
        System.out.println("Publisher " + id + " published: " + message.getMessage() + " to topic " + topicId);
    }
}
