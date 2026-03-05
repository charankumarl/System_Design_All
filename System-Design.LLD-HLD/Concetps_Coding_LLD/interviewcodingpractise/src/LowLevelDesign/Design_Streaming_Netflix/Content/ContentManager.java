package LowLevelDesign.Design_Streaming_Netflix.Content;

import java.util.ArrayList;
import java.util.List;

public class ContentManager {

    static List<Content> contentList = new ArrayList<>();

    public ContentManager() {
    }

    public void addContent(Content content) {
        contentList.add(content);
    }

    public void removeContent(Content content) {
        contentList.remove(content);
    }

    public List<Content> getContentList() {
        return contentList;
    }
}
