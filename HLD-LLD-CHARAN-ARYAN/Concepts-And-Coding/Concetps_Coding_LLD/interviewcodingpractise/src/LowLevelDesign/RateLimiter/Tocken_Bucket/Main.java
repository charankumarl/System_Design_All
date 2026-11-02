package LowLevelDesign.RateLimiter.Tocken_Bucket;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        IRateLimiter tokenBucket = new TokenBucket(5); // 5 tokens per second, bucket size of 10

        String userId = "user123";
        String userId2 = "user456";

        // Simulating requests
        for (int i = 1; i <= 15; i++) {
            if (tokenBucket.isAllowed(userId, "login")) {
                System.out.println("login from " + userId + " allowed.");
            } else {
                System.out.println("login from from " + userId + " denied.");
                Thread.sleep(1000); // Wait for a second before next request
            }
        }
    }
}
