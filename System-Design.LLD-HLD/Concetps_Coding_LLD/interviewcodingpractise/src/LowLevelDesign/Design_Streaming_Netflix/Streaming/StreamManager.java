package LowLevelDesign.Design_Streaming_Netflix.Streaming;

import LowLevelDesign.Design_Streaming_Netflix.BandWidth.BandWidthFactory;
import LowLevelDesign.Design_Streaming_Netflix.BandWidth.BandWidthStratergy;
import LowLevelDesign.Design_Streaming_Netflix.Recomendation.RecomendationEngine;
import LowLevelDesign.Design_Streaming_Netflix.VideoQuality.VideoQuality;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StreamManager {

    ScheduledExecutorService scheduler;

    Map<Integer, Stream> activeStreams;
    List<Stream> allStreams;

    public BandWidthStratergy bandWidthStratergy;
    public RecomendationEngine recomendationEngine = RecomendationEngine.getInstance();

    public StreamManager() {
        this.activeStreams = new HashMap<>();
        this.allStreams = new ArrayList<>();
    }

    public void addStream(Stream stream) {
        allStreams.add(stream);
    }

    public void removeStream(int streamId) {
        activeStreams.remove(streamId);
    }

    public List<Stream> getStream(int streamId) {
        return allStreams;
    }

    public void startStream(int userId, Stream stream) {

        scheduler = Executors.newSingleThreadScheduledExecutor();

        activeStreams.put(userId, stream);
        recomendationEngine.addStream(userId, stream);
        // add stream to user stream history, Forgotted
        startAutoAdjust();
        System.out.println("Stream started for user: " + userId);
    }

    public void pauseStream(int userId) {
        scheduler.shutdown();
        System.out.println("Stream paused for user: " + userId);
    }

    public void endStream(int userId) {
        activeStreams.remove(userId);
        scheduler.shutdown();
        System.out.println("Stream Ended for user: " + userId);
    }

    public void adjustQuality(int bandwidth) {

        bandWidthStratergy = BandWidthFactory.getStratergy(bandwidth);
        VideoQuality videoQuality = bandWidthStratergy.getVideoQuality(bandwidth);
        videoQuality.apply();
    }

    public void startAutoAdjust() {

        scheduler.scheduleAtFixedRate(() -> {
            adjustQuality(new Random().nextInt(0, 1200));
        }, 0, 5, TimeUnit.SECONDS);
    }
}
