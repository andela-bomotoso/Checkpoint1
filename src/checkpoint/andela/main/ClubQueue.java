package checkpoint.andela.main;


import java.util.List;
import java.util.PriorityQueue;

public class ClubQueue{

    private PriorityQueue<Member> memberQueue;

    public ClubQueue() {
        memberQueue = new PriorityQueue<Member>();
    }

    public void addMember(Member member) {
        memberQueue.add(member);
    }

    public PriorityQueue<Member> getMemberQueue() {
        return memberQueue;
    }

    public Member poll() {
       return memberQueue.poll();
    }








}
