package LowLevelDesign.Design_Streaming_Netflix.Content;

import java.util.List;

public class Tv_Shows extends Content{

    int totalSeasons;
    int totalEpisodes;

    public Tv_Shows(String contentId, String title, String description, List<Actor> actors, int releaseYear, String language, int quality) {
        super(contentId, title, description, actors, releaseYear, language, quality);
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }
}
