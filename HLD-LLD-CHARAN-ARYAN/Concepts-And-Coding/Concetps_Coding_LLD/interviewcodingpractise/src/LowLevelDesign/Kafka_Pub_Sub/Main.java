package LowLevelDesign.Kafka_Pub_Sub;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        KafkaController kafkaController = new KafkaController();

        // Create topics.
        Topic topic1 = kafkaController.createTopic("Topic1", "1");
        Topic topic2 = kafkaController.createTopic("Topic2", "2");

        // Create subscribers.
        SimpleSubscriber subscriber1 = new SimpleSubscriber("Subscriber1", 0);
        SimpleSubscriber subscriber2 = new SimpleSubscriber("Subscriber2", 0);
        SimpleSubscriber subscriber3 = new SimpleSubscriber("Subscriber3", 0);

        // Subscribe: subscriber1 subscribes to both topics,
        // subscriber2 subscribes to topic1, and subscriber3 subscribes to topic2.
        kafkaController.subscribe(subscriber1, topic1.getTopicId());
        kafkaController.subscribe(subscriber1, topic2.getTopicId());
        kafkaController.subscribe(subscriber2, topic1.getTopicId());
        kafkaController.subscribe(subscriber3, topic2.getTopicId());

        SimplePublisher publisher1 = new SimplePublisher("Publisher1", kafkaController);
        SimplePublisher publisher2 = new SimplePublisher("Publisher2", kafkaController);

        Thread.sleep(1000); // Wait for subscribers to be ready

        // Publish some messages.
        publisher1.publish(topic1.getTopicId(), new Message(("Message m1"), topic1.getTopicId()));
        publisher1.publish(topic1.getTopicId(), new Message(("Message m2"),topic1.getTopicId()));
        publisher2.publish(topic2.getTopicId(), new Message(("Message m3"), topic1.getTopicId()));

        Thread.sleep(1000);

        publisher1.publish(topic1.getTopicId(), new Message(("Message m10"), topic1.getTopicId()));

    }
}
