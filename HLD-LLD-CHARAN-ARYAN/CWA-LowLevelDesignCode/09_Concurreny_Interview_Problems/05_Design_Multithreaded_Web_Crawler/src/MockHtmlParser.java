import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockHtmlParser implements HtmlParser {

    @Override
    public List<String> getUrls(String url) {
        // Mock implementation for testing
        System.out.println(Thread.currentThread().getName() + " fetching URLs from: " + url);
        switch (url) {
            case "http://news.yahoo.com/news/topics/" :
                    return Arrays.asList(
                    "http://news.yahoo.com/news/topics/sports",
                    "http://news.yahoo.com/news/topics/technology",
                    "http://news.yahoo.com/news",
                    "http://news.yahoo.com/news/topics/"
            );
            case "http://news.yahoo.com/news" :
                return Arrays.asList(
                    "http://news.yahoo.com/news/topics/",
                    "http://news.yahoo.com/news/politics"
            );
            case "http://news.yahoo.com/news/topics/sports" :
                return Arrays.asList(
                    "http://news.yahoo.com/news/topics/sports/football",
                    "http://news.yahoo.com/news/topics/sports/basketball"
            );
            default :
                return List.of();
        }
    }
}

