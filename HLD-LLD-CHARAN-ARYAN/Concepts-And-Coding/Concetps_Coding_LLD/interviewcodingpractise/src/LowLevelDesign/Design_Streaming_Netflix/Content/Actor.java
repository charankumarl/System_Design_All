package LowLevelDesign.Design_Streaming_Netflix.Content;

import java.util.*;
public class Actor {

    String name;
    List<Content> contentList;

    public Actor(String name, List<Content> contentList) {
        this.name = name;
        this.contentList = contentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }
}
