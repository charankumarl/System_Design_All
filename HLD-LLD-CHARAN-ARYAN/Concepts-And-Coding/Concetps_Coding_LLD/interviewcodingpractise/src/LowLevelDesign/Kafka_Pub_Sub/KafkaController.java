package LowLevelDesign.Kafka_Pub_Sub;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KafkaController {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    private final Map<String, Topic> topics;

    // Map of topic IDs to their list of TopicSubscriber associations.
    private final Map<String, List<SimpleSubscriber>> topicSubscribers;

    public KafkaController() {
        topics = new ConcurrentHashMap<>();
        topicSubscribers = new ConcurrentHashMap<>();
    }

    public Topic createTopic(String topicName, String topicId) {
        Topic topic = new Topic(topicName, topicId);
        topics.put(topicId, topic);
        topicSubscribers.put(topicId, new CopyOnWriteArrayList<>());
        System.out.println("Created topic: " + topicName + " with id: " + topicId);
        return topic;
    }

    public void subscribe(SimpleSubscriber subscriber, String topicId) {
        Topic topic = topics.get(topicId);
        if (topic == null) {
            System.err.println("Topic with id " + topicId + " does not exist");
            return;
        }
        topicSubscribers.get(topicId).add(subscriber);

        executorService.submit(() -> {
            consume(subscriber, topicId);
        });

        System.out.println("Subscriber " + subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
    }

    public void publish(SimplePublisher publisher, String topicId, Message message) {
        Topic topic = topics.get(topicId);
        if (topic == null) {
            throw new IllegalArgumentException("Topic with id " + topicId + " does not exist");
        }
        topic.addMessage(message);

        System.out.println("Message \"" + message.getMessage() + "\" published to topic: " + topic.getTopicName());
    }

    public void consume(SimpleSubscriber subscriber, String topicId) {
        Topic topic = topics.get(topicId);
        if (topic == null) {
            System.err.println("Topic with id " + topicId + " does not exist");
            return;
        }

        while (true) {
            List<Message> messages = topic.getMessages(); // Get latest messages

            // Consume new messages only
            while (subscriber.offset < messages.size()) {
                Message message = messages.get(subscriber.offset);
                try {
                    subscriber.consume(message);
                } catch (InterruptedException e) {
                    System.out.println("Consumer interrupted. Exiting...");
                    return;
                }
                subscriber.offset++;
            }

            try {
                Thread.sleep(500); // Wait for 500ms before next check
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted during sleep. Exiting...");
                return;
            }
        }
    }
}
