package checkpoint.andela.main;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Represents readers club information.
 */

public class ReadersClub {

    /**
     * Readers Club Properties
     */

    private List<Book> clubBooks;
    private List<Member> clubMembers;
    private ClubQueue clubQueue;

    /**
     * Create a new readersClub with default properties
     */

    public ReadersClub() {
        this.clubBooks = new ArrayList<Book>();
        this.clubMembers = new ArrayList<Member>();
        this.clubQueue = new ClubQueue();
    }

    public void registerAMember(Member member) {
        clubMembers.add(member);
    }

    public void registerMembers(List<Member>members) {
        for(Member member:members) {
            registerAMember(member);
        }
    }

    public List<Member> getRegisteredMembers() {
        return clubMembers;
    }

    public boolean isBookAvailable(Book book) {

        return clubBooks.contains(book);
    }


    public void registerABook(Book book) {
        clubBooks.add(book);
    }

    public void registerBooks(List<Book>books) {
        for(Book book:books) {
            registerABook(book);
        }
    }

    public List<Book> getClubBooks() {
        return clubBooks;
    }

    public void setClubBooks(List<Book>clubBooks) {
        this.clubBooks = clubBooks;
    }

    public void requestForABook(Book book, Member member) {
        if (isBookAvailable(book) && isMemberRegistered(member)) {
            clubQueue.addMember(member);
        }
    }

    public boolean isMemberRegistered(Member member) {
         return clubMembers.contains(member);
    }

    public boolean isMemberInClubQueue(Member member) {
        return clubQueue.containsMember(member);
    }


    public PriorityQueue<Member>getBorrowersQueue() {
        return clubQueue.getMemberQueue();
    }

    public boolean isBorrowerQueueEmpty() {
        return clubQueue.isEmpty();
    }

    public Member getBookBorrower() {
            return clubQueue.getPriorityMember();
    }

}
