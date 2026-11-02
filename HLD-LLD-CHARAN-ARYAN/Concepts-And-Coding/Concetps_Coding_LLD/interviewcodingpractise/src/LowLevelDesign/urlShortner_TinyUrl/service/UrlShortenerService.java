package LowLevelDesign.urlShortner_TinyUrl.service;

import LowLevelDesign.urlShortner_TinyUrl.coreClass.UrlMapping;
import LowLevelDesign.urlShortner_TinyUrl.keyGenerator.KeyGenerator;
import LowLevelDesign.urlShortner_TinyUrl.repo.UrlRepo;

public class UrlShortenerService {

    private final UrlRepo repository;
    private final KeyGenerator keyGenerator;
    private final String domain = "https://sho.rt/";

    public UrlShortenerService(UrlRepo repository,
                               KeyGenerator keyGenerator) {
        this.repository = repository;
        this.keyGenerator = keyGenerator;
    }

    public String shortenUrl(String longUrl) {
        String key = keyGenerator.generateKey();
        String shortUrl = domain + key;

        UrlMapping mapping = new UrlMapping(shortUrl, longUrl);
        repository.save(mapping);

        return shortUrl;
    }

    ///  Optional, we focus on getting Shorten URL first

    public String getLongUrl(String shortUrl) {
        UrlMapping mapping = repository.findByShortUrl(shortUrl);
        if (mapping == null) {
            throw new RuntimeException("URL not found");
        }
        return mapping.getLongUrl();
    }
}
