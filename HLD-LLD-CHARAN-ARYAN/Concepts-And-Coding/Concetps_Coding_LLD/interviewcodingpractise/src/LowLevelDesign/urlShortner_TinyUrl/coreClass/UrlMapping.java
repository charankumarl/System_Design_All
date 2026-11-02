package LowLevelDesign.urlShortner_TinyUrl.coreClass;

public class UrlMapping {

    private final String shortUrl;
    private final String longUrl;
    private final long createdAt;

    public UrlMapping(String shortUrl, String longUrl) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.createdAt = System.currentTimeMillis();
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }
}
