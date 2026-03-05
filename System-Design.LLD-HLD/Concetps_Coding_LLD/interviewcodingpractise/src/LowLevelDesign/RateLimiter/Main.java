package LowLevelDesign.RateLimiter;

public class Main {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5, 3);  // 60-second window, 3 requests max

        String userId = "user123";
        String apiName = "getUser";

        // Simulate a few requests
        for (int i = 1; i <= 6; i++) {
            boolean allowed = rateLimiter.isAllowed(userId, apiName);
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Rejected"));
            try {
                Thread.sleep(1000);  // Sleep for 1 second between requests (simulate real-time requests)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 6; i++) {
            boolean allowed = rateLimiter.isAllowed(userId, apiName);
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Rejected"));
            try {
                Thread.sleep(1000);  // Sleep for 1 second between requests (simulate real-time requests)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
