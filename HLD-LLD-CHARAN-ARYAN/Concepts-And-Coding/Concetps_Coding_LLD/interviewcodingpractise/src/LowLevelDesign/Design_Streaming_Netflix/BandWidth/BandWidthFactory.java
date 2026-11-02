package LowLevelDesign.Design_Streaming_Netflix.BandWidth;

public class BandWidthFactory {

    public static BandWidthStratergy getStratergy(int bandWidth) {

        if(bandWidth < 500) {
            return new LowBandwidth();
        }
        else {
            return new HighBandwidth();
        }
    }
}
