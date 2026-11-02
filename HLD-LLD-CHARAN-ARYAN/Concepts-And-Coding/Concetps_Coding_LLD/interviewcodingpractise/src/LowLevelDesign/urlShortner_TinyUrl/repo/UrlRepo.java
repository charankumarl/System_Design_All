package LowLevelDesign.urlShortner_TinyUrl.repo;

import LowLevelDesign.urlShortner_TinyUrl.coreClass.UrlMapping;

public interface UrlRepo {

    void save(UrlMapping mapping);
    UrlMapping findByShortUrl(String shortUrl);
}
