package checkpoint.andela.main;


import java.util.ArrayList;
import java.util.List;

public class ReadersClub {

    private List<Book> clubBooks = new ArrayList<Book>();
    private List<Member> clubMembers = new ArrayList<Member>();
    private ClubQueue clubQueue = new ClubQueue();

    public ReadersClub() {
    }

    public void registerMember(Member member) {
        clubMembers.add(member);
    }

    public void registerMembers(List<Member>members) {
        for(Member member:members) {
            clubMembers.add(member);
        }
    }

    public void registerBook(Book book) {
        clubBooks.add(book);
    }

    public void registerBooks(List<Book>books) {
        for(Book book:books) {
            clubBooks.add(book);
        }
    }

    public boolean bookIsAvailable(Book book) {

        boolean bookIsAvailable = false;
        if(clubBooks.contains(book)) {
            bookIsAvailable = true;
        }
        return bookIsAvailable;
    }

    public void requestForBook(Book book, Member member) {
        if (bookIsAvailable(book)) {
            clubQueue.addMember(member);
        }
    }

    public Member getBookBorrower() {
            return clubQueue.poll();
    }

}
