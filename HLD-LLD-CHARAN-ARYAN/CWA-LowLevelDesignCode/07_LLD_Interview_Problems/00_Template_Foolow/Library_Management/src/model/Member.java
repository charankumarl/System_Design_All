package model;

import notification.LibraryObserver;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String memberId;
    private String name;
    private List<LibraryObserver> channels;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.channels = new ArrayList<>();
    }

    public void addChannel(LibraryObserver channel) {
        channels.add(channel);
    }

    public List<LibraryObserver> getChannels() {
        return channels;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }
}
