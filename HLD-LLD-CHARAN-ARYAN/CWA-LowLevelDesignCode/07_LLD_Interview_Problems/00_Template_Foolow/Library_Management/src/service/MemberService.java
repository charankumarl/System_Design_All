package service;

import model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private List<Member> members;

    public MemberService() {
        this.members = new ArrayList<>();
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Member findMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}
