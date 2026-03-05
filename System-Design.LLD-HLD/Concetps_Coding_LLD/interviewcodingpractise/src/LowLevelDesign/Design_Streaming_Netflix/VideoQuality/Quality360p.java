package LowLevelDesign.Design_Streaming_Netflix.VideoQuality;

public class Quality360p implements VideoQuality {


    @Override
    public void apply() {
        System.out.println("Applying 360p video quality");
    }
}
