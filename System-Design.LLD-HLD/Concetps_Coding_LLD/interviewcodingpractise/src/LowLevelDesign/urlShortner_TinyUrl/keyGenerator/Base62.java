package LowLevelDesign.urlShortner_TinyUrl.keyGenerator;

import java.util.concurrent.atomic.AtomicLong;

public class Base62 implements KeyGenerator {

    private static final String BASE62 =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final AtomicLong counter = new AtomicLong(1);

    @Override
    public String generateKey() {
        long value = counter.getAndIncrement();
        return encodeBase62(value);
    }

    private String encodeBase62(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {

            int currVal = (int) (num % 62);
            sb.append(BASE62.charAt(currVal));
            num /= 62;
        }
        return sb.reverse().toString();
    }
}
