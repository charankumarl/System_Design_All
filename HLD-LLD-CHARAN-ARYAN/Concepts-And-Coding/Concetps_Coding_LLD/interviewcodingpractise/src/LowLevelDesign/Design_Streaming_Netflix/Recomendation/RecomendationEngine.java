package LowLevelDesign.Design_Streaming_Netflix.Recomendation;

import LowLevelDesign.Design_Streaming_Netflix.Streaming.Stream;

import java.util.*;
import java.util.Map;

public class RecomendationEngine {

    private static volatile RecomendationEngine instance = null;   // volatile = lazy initialization    final = eager initialization

    Map<Integer, List<Stream>> userIdToStreamMap = new HashMap<>();

    private RecomendationEngine(){

    }

    public static RecomendationEngine getInstance() {

        if (instance == null) {   // we check for null twice before creating the instance.     Multiple threads will enter here

            synchronized (RecomendationEngine.class){   // but only 1 thread will enter and create the object

                if (instance == null) {  // remaining threads will create a new object.
                    instance = new RecomendationEngine();
                }
            }
        }
        return instance;
    }

    public void addStream(int userId, Stream stream) {

        List<Stream> streams = userIdToStreamMap.getOrDefault(userId, new ArrayList<>());
        streams.add(stream);
        userIdToStreamMap.put(userId, streams);
    }

    public List<Stream> getStreams(int userId) {

        return userIdToStreamMap.getOrDefault(userId, new ArrayList<>());
    }
}
