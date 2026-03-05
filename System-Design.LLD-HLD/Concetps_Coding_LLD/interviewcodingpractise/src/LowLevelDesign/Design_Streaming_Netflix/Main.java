package LowLevelDesign.Design_Streaming_Netflix;

import LowLevelDesign.Design_Streaming_Netflix.Content.Actor;
import LowLevelDesign.Design_Streaming_Netflix.Content.Movie;
import LowLevelDesign.Design_Streaming_Netflix.Streaming.Stream;
import LowLevelDesign.Design_Streaming_Netflix.Subscription.SubScriptionType;
import LowLevelDesign.Design_Streaming_Netflix.User.Profile;
import LowLevelDesign.Design_Streaming_Netflix.User.ProfileType;
import LowLevelDesign.Design_Streaming_Netflix.User.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        NetFlix netFlix = new NetFlix();

        // create profile and user

        Profile profile1 = new Profile("1", "charan", ProfileType.ADULT);

        User user1 = new User(1, "charan", "c@123", "1234");
        user1.setProfiles(List.of(profile1));

        netFlix.addUser(user1);
        netFlix.buySubscription(user1, SubScriptionType.SIX);
        //-------------------------------------------------------------------------------------------------------------//

        // CREATE ACTOR and CONTENT / MOVIES
        Actor actor1 = new Actor("c1", new ArrayList<>());

        Movie content1 = new Movie("1", "HULK", "Avengers",
                List.of(actor1), 2023, "ENGLISH", 1080);

        content1.setDuration(120);
        actor1.setContentList(List.of(content1));

        netFlix.addContent(content1);
        //--------------------------------------------------------------------------//

        // CREATE STREAM and Play it

        Stream stream1 = new Stream(1, content1, user1, "10:00", "11:00", "www.stream1.com");
        netFlix.addStream(stream1);

        netFlix.play(user1.getUserId(), stream1);
        netFlix.pause(user1.getUserId());

        netFlix.endStream(user1.getUserId());
        netFlix.getRecommendation(user1.getUserId());


        Profile profile2 = new Profile("2", "charan2", ProfileType.ADULT);

        User user2 = new User(2, "charan2", "c@123", "1234");
        user2.setProfiles(List.of(profile2));

        netFlix.addUser(user2);
        netFlix.buySubscription(user2, SubScriptionType.SIX);
        //-------------------------------------------------------------------------------------------------------------//

        Movie content2 = new Movie("2", "HUL2", "Avengers",
                List.of(actor1), 2023, "ENGLISH", 1080);

        content2.setDuration(120);
        actor1.setContentList(List.of(content2));

        netFlix.addContent(content2);
        //--------------------------------------------------------------------------//

        // CREATE STREAM and Play it

        Stream stream2 = new Stream(1, content2, user2, "10:00", "11:00", "www.stream1.com");
        netFlix.addStream(stream2);

        netFlix.play(user2.getUserId(), stream2);
        netFlix.pause(user2.getUserId());

        netFlix.endStream(user2.getUserId());
        netFlix.getRecommendation(user2.getUserId());
    }
}
