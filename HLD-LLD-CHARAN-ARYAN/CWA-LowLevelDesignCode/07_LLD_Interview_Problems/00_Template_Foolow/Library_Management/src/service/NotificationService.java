package service;

import model.Book;
import model.Member;
import notification.LibraryObserver;

public class NotificationService {
    public void send(Member member, String message) {
        for (LibraryObserver channel : member.getChannels()) {
            channel.update(message);
        }
    }

    public void send(Book book, String message) {
        for (Member member : book.getWaitlist()) {
            send(member, message);
        }
        book.clearWaitlist();
    }
}
