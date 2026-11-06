package model;

import java.time.LocalDateTime;

public class Comment {
    private String id;
    private String content;
    private User author;
    private LocalDateTime time;

    public Comment(String id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.time = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
