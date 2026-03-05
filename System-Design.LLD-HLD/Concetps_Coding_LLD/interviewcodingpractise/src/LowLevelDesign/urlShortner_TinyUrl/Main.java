package LowLevelDesign.urlShortner_TinyUrl;

import LowLevelDesign.urlShortner_TinyUrl.controller.UrlShortenerController;
import LowLevelDesign.urlShortner_TinyUrl.keyGenerator.Base62;
import LowLevelDesign.urlShortner_TinyUrl.keyGenerator.KeyGenerator;
import LowLevelDesign.urlShortner_TinyUrl.repo.InMemoryUrlRepo;
import LowLevelDesign.urlShortner_TinyUrl.repo.UrlRepo;
import LowLevelDesign.urlShortner_TinyUrl.service.UrlShortenerService;

public class Main {

    public static void main(String[] args) {

        UrlRepo repository = new InMemoryUrlRepo();
        KeyGenerator keyGenerator = new Base62();
        UrlShortenerService service =
                new UrlShortenerService(repository, keyGenerator);

        UrlShortenerController controller =
                new UrlShortenerController(service);

        String shortUrl = controller.createShortUrl(
                "https://www.google.com/search?q=lld"
        );

        System.out.println("Short URL: " + shortUrl);

        String longUrl = controller.redirect(shortUrl);
        System.out.println("Redirect to: " + longUrl);
    }
}
