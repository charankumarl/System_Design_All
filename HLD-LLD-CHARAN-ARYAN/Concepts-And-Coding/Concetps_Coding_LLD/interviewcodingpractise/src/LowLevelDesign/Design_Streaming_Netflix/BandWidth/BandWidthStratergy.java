package LowLevelDesign.Design_Streaming_Netflix.BandWidth;

import LowLevelDesign.Design_Streaming_Netflix.VideoQuality.VideoQuality;

public interface BandWidthStratergy {

    public VideoQuality getVideoQuality(int bandWidth);
}
