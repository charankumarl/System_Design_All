package LowLevelDesign.RateLimiter.Tocken_Bucket;

public interface IRateLimiter {

    boolean isAllowed(String userId, String apiKey);

    void updateConfig();

    //void removeRateLimit(String userId, String apiKey);
}
