package checkpoint.andela.main;


import java.util.PriorityQueue;

public class ClubQueue{

    private PriorityQueue<Member> memberQueue;

    public ClubQueue() {
        memberQueue = new PriorityQueue<Member>();
    }

    public void addMember(Member member) {
        memberQueue.add(member);
    }

    public Member poll() {
       return memberQueue.poll();
    }








}
