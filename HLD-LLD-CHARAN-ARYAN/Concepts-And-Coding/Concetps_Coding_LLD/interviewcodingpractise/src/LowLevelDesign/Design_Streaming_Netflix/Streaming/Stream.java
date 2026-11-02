package LowLevelDesign.Design_Streaming_Netflix.Streaming;

import LowLevelDesign.Design_Streaming_Netflix.Content.Content;
import LowLevelDesign.Design_Streaming_Netflix.User.User;

public class Stream {

    int streamId;
    Content content;
    User user;
    String startTime;
    String endTime;
    String streamingUrl;

    public Stream(int streamId, Content content, User user, String startTime, String endTime, String streamingUrl) {
        this.streamId = streamId;
        this.content = content;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.streamingUrl = streamingUrl;
    }

    public int getStreamId() {
        return streamId;
    }

    public void setStreamId(int streamId) {
        this.streamId = streamId;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStreamingUrl() {
        return streamingUrl;
    }

    public void setStreamingUrl(String streamingUrl) {
        this.streamingUrl = streamingUrl;
    }
}
