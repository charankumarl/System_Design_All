package Controller;

import model.Topic;
import model.TopicSubscriber;
import Subscriber.ISubscriber;
import Publisher.IPublisher;
import model.Message;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class KafkaController {
    // Map of topic IDs to Topic objects.
    private final Map<String, Topic> topics;
    // Map of topic IDs to their list of TopicSubscriber associations.
    private final Map<String, List<TopicSubscriber>> topicSubscribers;
    // ExecutorService to run subscriber tasks concurrently.
    private final ExecutorService subscriberExecutor;
    private final AtomicInteger topicIdCounter;

    public KafkaController() {
        topics = new ConcurrentHashMap<>();
        topicSubscribers = new ConcurrentHashMap<>();
        // Using a cached thread pool to dynamically manage threads.
        subscriberExecutor = Executors.newCachedThreadPool();
        // Executors.newFixedThreadPool(10)   // this is fixed thread pool.
        topicIdCounter = new AtomicInteger(0);
    }

    public Topic createTopic(String topicName) {
        String topicId = String.valueOf(topicIdCounter.incrementAndGet());
        Topic topic = new Topic(topicName, topicId);
        topics.put(topicId, topic);
        topicSubscribers.put(topicId, new CopyOnWriteArrayList<>());
        System.out.println("Created topic: " + topicName + " with id: " + topicId);
        return topic;
    }

    public void subscribe(ISubscriber subscriber, String topicId) {
        Topic topic = topics.get(topicId);
        if (topic == null) {
            System.err.println("Topic with id " + topicId + " does not exist");
            return;
        }
        TopicSubscriber ts = new TopicSubscriber(topic, subscriber);
        topicSubscribers.get(topicId).add(ts);
        // Submit the subscriber task to the executor.
        subscriberExecutor.submit(new TopicSubscriberController(ts));
            ///  Executor picks a thread from its pool. Calls the below run() method. And it will be in waiting state
            /// new TopicSubscriberController(ts).run();

            ///  new subscriber will be in waiting state in controller. There we used the Syncronized(subscriber) and wait() method.

        System.out.println("Subscriber " + subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
    }

    public void publish(String topicId, Message message) {
        Topic topic = topics.get(topicId);
        if (topic == null) {
            throw new IllegalArgumentException("Topic with id " + topicId + " does not exist");
        }
        topic.addMessage(message);
        // wake up each subscriber on its own monitor
        List<TopicSubscriber> subs = topicSubscribers.get(topicId);
        for (TopicSubscriber topicSubscriber : subs) {
            synchronized (topicSubscriber) {      /// there we used same object, so here also we need to use the same object to notify.
                topicSubscriber.notify();   /// this will notify the subscriber, which is in waiting state from above.
            }
        }
        System.out.println("Message \"" + message.getMessage() + "\" published to topic: " + topic.getTopicName());
    }

    /**
     *So the way to "know" what to put inside synchronized(...) is: go find where .wait() was called, and copy that same object reference.
     *
     * // subscriber side (somewhere else in code):
     * synchronized (topicSubscriber) {
     *     topicSubscriber.wait();   // <-- waiting ON topicSubscriber
     * }
     *
     * // publisher side (your code):
     * synchronized (topicSubscriber) {   // <-- must match: same object
     *     topicSubscriber.notify();
     *
     * 2. What happens without synchronized?
     *
     * topicSubscriber.notify();   // no synchronized wrapper
     *
     * This throws IllegalMonitorStateException immediately at runtime.
     */

    // Resets the offset for the given subscriber on the specified topic.
    public void resetOffset(String topicId, ISubscriber subscriber, int newOffset) {
        List<TopicSubscriber> subscribers = topicSubscribers.get(topicId);
        if (subscribers == null) {
            System.err.println("Topic with id " + topicId + " does not exist");
            return;
        }
        for (TopicSubscriber ts : subscribers) {
            if (ts.getSubscriber().getId().equals(subscriber.getId())) {
                ts.getOffset().set(newOffset);
                // Notify in case the subscriber thread is waiting.
                synchronized (ts) {  ///  use same object to notify. There in controller we used the same object to wait.
                    ts.notify();
                }
                System.out.println("Offset for subscriber " + subscriber.getId() + " on topic " +
                        ts.getTopic().getTopicName() + " reset to " + newOffset);
                break;
            }
        }
    }

    // Shutdown the ExecutorService gracefully.
    public void shutdown() {
        subscriberExecutor.shutdown();
        try {
            if (!subscriberExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                subscriberExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            subscriberExecutor.shutdownNow();
        }
    }
}
