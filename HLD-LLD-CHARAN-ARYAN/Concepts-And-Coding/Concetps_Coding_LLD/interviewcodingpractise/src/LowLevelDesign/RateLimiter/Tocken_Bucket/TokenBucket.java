package LowLevelDesign.RateLimiter.Tocken_Bucket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class TokenBucket implements IRateLimiter{

    private final int refillRate;
    private final Map<String, Map<String, Bucket>> userBuckets;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public TokenBucket(int refillRate) {
        this.refillRate = refillRate;
        this.userBuckets = new ConcurrentHashMap<>();
        updateConfig(); // Start the token refill process
    }

    @Override
    public boolean isAllowed(String userId, String apiKey) {

        Bucket bucket = userBuckets.computeIfAbsent(userId, val -> new ConcurrentHashMap<>())
                .computeIfAbsent(apiKey, val -> new Bucket(5)); // Default capacity of 5 tokens

        /*
        Map<String, Bucket> apiBuckets = userBuckets.get(userId);

        if (apiBuckets == null) {
            apiBuckets = new ConcurrentHashMap<>();
            userBuckets.put(userId, apiBuckets);
        }

        Bucket bucket = apiBuckets.get(apiKey);

        if (bucket == null) {
            bucket = new Bucket(5); // default capacity 5
            apiBuckets.put(apiKey, bucket);
         */

        synchronized (bucket) {
            if (bucket.tokens < 1) {
                return false; // No tokens available
            }
            bucket.tokens -= 1; // Consume a token
            return true; // Request is allowed
        }
    }

    @Override
    public void updateConfig() {

        // refill tokens periodically every 1 min with scheduled task
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Refilling tokens for all buckets...");
            for (Map<String, Bucket> map : userBuckets.values()) {
                for (Bucket bucket : map.values()) {
                    synchronized (bucket) {
                        bucket.tokens = Math.min(bucket.capacity, bucket.tokens + refillRate);
                    }
                }
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    class Bucket{

        private int capacity;
        private double tokens;

        public Bucket(int capacity) {
            this.capacity = capacity;
            this.tokens = capacity; // Start with full capacity
        }
    }
}
