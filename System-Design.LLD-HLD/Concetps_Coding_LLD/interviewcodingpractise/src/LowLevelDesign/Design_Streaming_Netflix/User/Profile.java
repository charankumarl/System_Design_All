package LowLevelDesign.Design_Streaming_Netflix.User;

public class Profile {

    String profileId;
    String profileName;
    ProfileType profileType;

    public Profile(String profileId, String profileName, ProfileType profileType) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.profileType = profileType;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }
}
