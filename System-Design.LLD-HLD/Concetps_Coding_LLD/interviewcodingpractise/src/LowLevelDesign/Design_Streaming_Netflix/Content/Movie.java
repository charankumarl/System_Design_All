package LowLevelDesign.Design_Streaming_Netflix.Content;

import java.util.List;

public class Movie extends Content{

    int duration;

    public Movie(String contentId, String title, String description, List<Actor> actors, int releaseYear, String language, int quality) {
        super(contentId, title, description, actors, releaseYear, language, quality);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
