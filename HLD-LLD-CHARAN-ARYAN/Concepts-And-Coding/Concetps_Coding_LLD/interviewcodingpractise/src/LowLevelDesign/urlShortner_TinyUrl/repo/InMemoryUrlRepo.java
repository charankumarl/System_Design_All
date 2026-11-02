package LowLevelDesign.urlShortner_TinyUrl.repo;

import LowLevelDesign.urlShortner_TinyUrl.coreClass.UrlMapping;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUrlRepo implements UrlRepo {

    private final ConcurrentHashMap<String, UrlMapping> store = new ConcurrentHashMap<>();

    @Override
    public void save(UrlMapping mapping) {
        store.put(mapping.getShortUrl(), mapping);
    }

    @Override
    public UrlMapping findByShortUrl(String shortUrl) {
        return store.get(shortUrl);
    }
}
