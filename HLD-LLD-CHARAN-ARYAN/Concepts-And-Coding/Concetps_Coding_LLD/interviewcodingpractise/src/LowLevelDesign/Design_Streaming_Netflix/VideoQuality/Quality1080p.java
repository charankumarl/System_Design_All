package LowLevelDesign.Design_Streaming_Netflix.VideoQuality;

public class Quality1080p implements VideoQuality {

    @Override
    public void apply() {
        System.out.println("Applying 1080p quality");
    }
}
