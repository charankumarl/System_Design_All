package LowLevelDesign.Design_Streaming_Netflix.BandWidth;

import LowLevelDesign.Design_Streaming_Netflix.VideoQuality.Quality1080p;
import LowLevelDesign.Design_Streaming_Netflix.VideoQuality.Quality360p;
import LowLevelDesign.Design_Streaming_Netflix.VideoQuality.VideoQuality;

public class HighBandwidth implements BandWidthStratergy{


    @Override
    public VideoQuality getVideoQuality(int bandWidth) {
        return new Quality1080p();
    }
}
