package LowLevelDesign.Design_Streaming_Netflix.Content;

import java.util.List;

public class Content {

    String contentId;
    String title;
    String description;
    List<Actor> actors;
    int releaseYear;
    String language;
    int quality;

    public Content(String contentId, String title, String description, List<Actor> actors, int releaseYear, String language, int quality) {
        this.contentId = contentId;
        this.title = title;
        this.description = description;
        this.actors = actors;
        this.releaseYear = releaseYear;
        this.language = language;
        this.quality = quality;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
