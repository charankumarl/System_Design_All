import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runnable_Executor {

    // ===================== PART 1: plain submit, no waiting needed =====================

    // Some plain object we want to "carry" into the task
    static class Order {
        String name;
        Order(String name) { this.name = name; }
    }

    // A Runnable that wraps/holds an object and does work with it when run() is called
    static class OrderTask implements Runnable {

        private final Order order;   // <-- the object submitted along with the task

        OrderTask(Order order) {
            this.order = order;
        }

        @Override
        public void run() {
            // this is the "other side" - actually using the object
            System.out.println("Processing order: " + order.name
                    + " on thread: " + Thread.currentThread().getName());
        }
    }

    // ===================== PART 2: mini publish/subscribe (same pattern as KafkaController) =====================

    // Like model.Topic - just holds messages
    static class SimpleTopic {
        private final List<String> messages = new ArrayList<>();
    }

    // Like TopicSubscriberController - a Runnable that waits on itself until a message arrives
    static class SimpleSubscriber implements Runnable {
        private final String name;
        private final SimpleTopic topic;
        private int offset = 0; // how many messages this subscriber has already read

        SimpleSubscriber(String name, SimpleTopic topic) {
            this.name = name;
            this.topic = topic;
        }

        @Override
        public void run() {
            while (true) {
                String messageToProcess;
                synchronized (this) {
                    // wait while there's nothing new for this subscriber
                    while (offset >= topic.messages.size()) {
                        try {
                            System.out.println(name + " waiting...");
                            wait();   // sleeps here, releases lock, until publisher notifies
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    messageToProcess = topic.messages.get(offset);
                    offset++;
                }
                // process outside the lock
                System.out.println(name + " received: " + messageToProcess);
            }
        }
    }

    // Like KafkaController.publish() - adds message then notifies every subscriber
    static class SimplePublisher {
        private final SimpleTopic topic;
        private final List<SimpleSubscriber> subscribers;

        SimplePublisher(SimpleTopic topic, List<SimpleSubscriber> subscribers) {
            this.topic = topic;
            this.subscribers = subscribers;
        }

        void publish(String message) {
            topic.messages.add(message);
            System.out.println("[Publisher] published: " + message);
            for (SimpleSubscriber subscriber : subscribers) {
                synchronized (subscriber) {   // same object the subscriber waits on
                    subscriber.notify(); // notify the subscriber that there's a new message
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // ---------- PART 1 demo ----------
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Order order1 = new Order("Pizza");
        Runnable task1 = new OrderTask(order1);
        executor.submit(task1);   // runs immediately, no waiting involved

        Order order2 = new Order("Burger");
        Runnable task2 = new OrderTask(order2);
        executor.submit(task2);

        executor.shutdown();

        System.out.println("---------------------------------");

        // ---------- PART 2 demo ----------
        SimpleTopic topic = new SimpleTopic();

        SimpleSubscriber sub1 = new SimpleSubscriber("Subscriber-1", topic);
        SimpleSubscriber sub2 = new SimpleSubscriber("Subscriber-2", topic);

        List<SimpleSubscriber> subscribers = new ArrayList<>();
        subscribers.add(sub1);
        subscribers.add(sub2);

        // start subscribers first - they'll find topic empty and go into wait()
        Thread t1 = new Thread(sub1);
        Thread t2 = new Thread(sub2);
        t1.start();
        t2.start();

        Thread.sleep(500); // give subscribers time to actually reach wait()

        SimplePublisher publisher = new SimplePublisher(topic, subscribers);
        publisher.publish("Hello Subscribers!");

        Thread.sleep(500);
        publisher.publish("Second message");

        Thread.sleep(500);
        System.exit(0); // subscribers loop forever, so just stop the demo here
    }
}
