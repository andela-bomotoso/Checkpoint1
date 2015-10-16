package checkpoint.andela.main;


import sun.security.pkcs11.P11Util;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ReadersClub {

    private List<Book> clubBooks = new ArrayList<Book>();
    private List<Member> clubMembers = new ArrayList<Member>();
    private ClubQueue clubQueue = new ClubQueue();

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
            clubMembers.add(member);
        }
    }

    public List<Member> getRegisteredMembers() {
        return clubMembers;
    }

    public boolean isBookAvailable(Book book) {

        boolean bookIsAvailable = false;
        if(clubBooks.contains(book)) {
            bookIsAvailable = true;
        }
        return bookIsAvailable;
    }


    public void registerABook(Book book) {
        clubBooks.add(book);
    }

    public void registerBooks(List<Book>books) {
        for(Book book:books) {
            clubBooks.add(book);
        }
    }

    public List<Book> getClubBooks() {
        return clubBooks;
    }
    public void setClubBooks(List<Book>clubBooks) {
        this.clubBooks =clubBooks;
    }

    public void requestForABook(Book book, Member member) {
        if (isBookAvailable(book) && isMemberRegistered(member)) {
            clubQueue.addMember(member);
        }
    }

    public boolean isMemberRegistered(Member member) {

        boolean memberIsRegistered = false;
        if(clubMembers.contains(member)) {
            memberIsRegistered = true;
        }
        return memberIsRegistered;
    }


    public PriorityQueue<Member>getBorrowersQueue() {
        return clubQueue.getMemberQueue();
    }

    public Member getBookBorrower() {
            return clubQueue.getPriorityMember();
    }

}
