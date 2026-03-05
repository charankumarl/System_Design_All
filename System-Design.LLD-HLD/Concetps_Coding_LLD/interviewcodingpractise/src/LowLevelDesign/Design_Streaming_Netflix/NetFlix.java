package LowLevelDesign.Design_Streaming_Netflix;

import LowLevelDesign.Design_Streaming_Netflix.Content.Content;
import LowLevelDesign.Design_Streaming_Netflix.Content.ContentManager;
import LowLevelDesign.Design_Streaming_Netflix.Recomendation.RecomendationEngine;
import LowLevelDesign.Design_Streaming_Netflix.Streaming.Stream;
import LowLevelDesign.Design_Streaming_Netflix.Streaming.StreamManager;
import LowLevelDesign.Design_Streaming_Netflix.Subscription.SubScriptionType;
import LowLevelDesign.Design_Streaming_Netflix.Subscription.Subscription;
import LowLevelDesign.Design_Streaming_Netflix.Subscription.SubscriptionFactory;
import LowLevelDesign.Design_Streaming_Netflix.User.ProfileType;
import LowLevelDesign.Design_Streaming_Netflix.User.User;
import LowLevelDesign.Design_Streaming_Netflix.User.UserManager;

import java.util.List;

public class NetFlix {

    StreamManager streamManager = new StreamManager();
    UserManager userManager = new UserManager();
    ContentManager contentManager = new ContentManager();
    RecomendationEngine recomendationEngine = RecomendationEngine.getInstance();
    Subscription subscription;

    public void buySubscription(User user, SubScriptionType subscriptionType) {

        subscription = SubscriptionFactory.getSubscription(subscriptionType);
        subscription.buySubscription();
        user.setSubscription(subscription);
    }

    public void play(int userId, Stream stream){
        streamManager.startStream(userId, stream);
    }

    public void pause(int userId){
        streamManager.pauseStream(userId);
    }

    public void endStream(int userId){
        streamManager.endStream(userId);
    }

    public void addUser(User user){
        userManager.addUser(user);
    }

    public void addContent(Content content){
        contentManager.addContent(content);
    }

    public void addStream(Stream stream){
        streamManager.addStream(stream);
    }

    public void getRecommendation(int userId){
        System.out.println("Getting recommendation for user: " + userId);
        List<Stream> recommendations = recomendationEngine.getStreams(userId);

        for(Stream stream : recommendations){
            System.out.println("Recommended Stream: " + stream.getContent().getTitle());
        }
    }

}
