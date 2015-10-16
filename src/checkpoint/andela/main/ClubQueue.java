package checkpoint.andela.main;

import java.util.PriorityQueue;

/**
 * Represents a Club Queue Information.
 */

public class ClubQueue{

    /**
     * Club Queue Property
     */

    private PriorityQueue<Member> memberQueue;

    /**
     * Create a new club queue with default properties
     */

    public ClubQueue() {
       memberQueue = new PriorityQueue<Member>();
    }

    public void addMember(Member member) {
        memberQueue.add(member);
    }

    public PriorityQueue<Member> getMemberQueue() {
        return memberQueue;
    }

    public Member getPriorityMember() {
       return memberQueue.poll();
    }

    public boolean containsMember(Member member) {
        return memberQueue.contains(member);
    }

    public boolean isEmpty() {
        return memberQueue.isEmpty();
    }

}
