package LowLevelDesign.urlShortner_TinyUrl.controller;

import LowLevelDesign.urlShortner_TinyUrl.service.UrlShortenerService;

public class UrlShortenerController {

    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }

    public String createShortUrl(String longUrl) {
        return service.shortenUrl(longUrl);
    }

    public String redirect(String shortUrl) {
        return service.getLongUrl(shortUrl);
    }
}
