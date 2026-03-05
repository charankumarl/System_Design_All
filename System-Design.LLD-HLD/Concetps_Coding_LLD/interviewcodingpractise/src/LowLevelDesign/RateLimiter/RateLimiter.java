package LowLevelDesign.RateLimiter;

import java.util.*;

public class RateLimiter {

    private final int windowSize;  // Size of the sliding window (in seconds)
    private final int maxRequests; // Maximum requests allowed in the window
    private final Map<String, List<Pair>> requestMap;  // In-memory storage for rate limit data

    // A simple Pair class to store start time and count for each window
    static class Pair {
        long startTime;  // Start time of the window
        int count;       // Number of requests in the window

        Pair(long startTime, int count) {
            this.startTime = startTime;
            this.count = count;
        }
    }

    // Constructor
    public RateLimiter(int windowSize, int maxRequests) {
        this.windowSize = windowSize;   // e.g., 60 seconds
        this.maxRequests = maxRequests; // e.g., 3 requests per window
        this.requestMap = new HashMap<>();
    }

    // Calculate the start of the current time window (rounded down to nearest window size)
    private long getWindowStart(long currentTime) {
        return (currentTime / windowSize) * windowSize;
    }

    // Helper method to generate the unique key for a user and API combination
    private String getKey(String userId, String apiName) {
        return userId + ":" + apiName;
    }

    // Method to check if the request is allowed based on the sliding window
    public boolean isAllowed(String userId, String apiName) {
        long currentTime = System.currentTimeMillis() / 1000;  // Current time in seconds
        long windowStart = getWindowStart(currentTime);  // Start of the current window

        String key = getKey(userId, apiName);
        List<Pair> windows = requestMap.getOrDefault(key, new ArrayList<>());

        // Ensure the list has at least two entries (current and previous window data)
        if (windows.size() < 2) {
            // Add initial windows data if they don't exist
            windows.add(new Pair(windowStart, 0));  // Add initial "previous window" with count 0
            windows.add(new Pair(windowStart, 0));  // Add initial "current window" with count 0
        }

        // Slide the windows if the current window has shifted
        Pair previousWindow = windows.get(0);
        Pair currentWindow = windows.get(1);

        // If the current window has shifted (new window), move the current window to previous
        if (currentWindow.startTime < windowStart) {
            // Move the current window to the previous window
            windows.set(0, new Pair(windowStart, currentWindow.count)); // Set the previous window to current window's data
            windows.set(1, new Pair(windowStart, 0)); // Reset the current window
        }

        // Now check if the current window's request count + previous window's request count exceeds the limit
        if (currentWindow.count + previousWindow.count >= maxRequests) {
            return false;  // Reject the request if it exceeds the rate limit
        }

        // Allow the request and increment the current window's count
        currentWindow.count++;

        // Store the updated window data in the map
        requestMap.put(key, windows);

        return true;
    }

    public boolean isAllowed1(String userId, String apiName) {

//        long currentTime = System.currentTimeMillis() / 1000;  // Current time in seconds
//        long windowStart = currentTime - windowSize + 1;  // Start of the current time window
//
//        String key = userId + ":" + apiName;
//        List<Long> timestamps = requestMap.getOrDefault(key, new ArrayList<>());
//
//        // Clean up the outdated timestamps
//        for (int i = 0; i < timestamps.size(); i++) {
//            if (timestamps.get(i) < windowStart) {
//                timestamps.remove(i);
//                i--;  // Adjust index after removal
//            }
//        }
//
//        // Check if we have exceeded the max allowed requests
//        if (timestamps.size() >= maxRequests) {
//            return false;  // Reject the request
//        }
//
//        // Otherwise, allow the request and add the timestamp
//        timestamps.add(currentTime);
//        requestMap.put(key, timestamps);
//
        return true;  // Allow the request
    }


    /*
        Formula:
Let’s define:

W = total window size (e.g., 60 seconds)

T = current timestamp (in seconds)

W_start = start of the current window = T - (T % W)

W_prev_start = start of the previous window = W_start - W

count_current = number of requests in the current window

count_prev = number of requests in the previous window

We calculate the weight of the previous window based on how much overlap it has with the sliding window:

💡 Weighted Formula:

weight_current = (T - W_start) / W
weight_prev = 1 - weight_current

total_requests = (count_current * weight_current) + (count_prev * weight_prev)
✅ If total_requests < max_requests, allow the request.
❌ If total_requests >= max_requests, reject the request.

🔍 Example:
max_requests = 3

W = 60 seconds

Assume:

count_prev = 3 (3 requests in previous window)

count_current = 2 (2 requests in current window)

T = 75 → so:

W_start = 60 (current window: [60, 120))

weight_current = (75 - 60) / 60 = 0.25

weight_prev = 1 - 0.25 = 0.75

Now apply the formula:

total_requests = (2 * 0.25) + (3 * 0.75)
               = 0.5 + 2.25
               = 2.75
✅ Allowed — 2.75 < 3

If another request comes in (3rd in current window):

total_requests = (3 * 0.25) + (3 * 0.75) = 0.75 + 2.25 = 3.0
❌ Rejected — 3.0 == 3


     */
}

