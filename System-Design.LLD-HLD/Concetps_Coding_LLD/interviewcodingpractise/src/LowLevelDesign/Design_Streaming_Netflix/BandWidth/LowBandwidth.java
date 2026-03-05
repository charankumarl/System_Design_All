package LowLevelDesign.Design_Streaming_Netflix.BandWidth;

import LowLevelDesign.Design_Streaming_Netflix.VideoQuality.Quality360p;
import LowLevelDesign.Design_Streaming_Netflix.VideoQuality.VideoQuality;

public class LowBandwidth implements BandWidthStratergy{


    @Override
    public VideoQuality getVideoQuality(int bandWidth) {
        return new Quality360p();
    }
}
