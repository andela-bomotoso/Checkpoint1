package checkpoint.andela.main;

import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class MemberTest {

    List<Book> booksWithMember = new ArrayList<Book>();

    public void getBooks() {

        Book book1 = new Book("Gifted Hands", "Ben Carson", 10, "ISBN 1596-6984");
        booksWithMember.add(book1);

        Book book2 = new Book("How to win friends and Influence People", "Dale Carnegie", 12, "ISBN 1345-7890");
        booksWithMember.add(book2);
    }

    @Test
    public void testIsBookWithMemberWhenMemberHasABook() {
        getBooks();
        Member member = new Member();
        member.setBooksWithMember(booksWithMember);
        Book book2 = new Book("How to win friends and Influence People", "Dale Carnegie", 12, "ISBN 1345-7890");
        assertTrue(member.isBookWithMember(book2));
    }

    @Test
    public void testIsBookWithMemberWhenMemberDoesNotHaveABook() {
        getBooks();
        Member member = new Member();
        member.setBooksWithMember(booksWithMember);
        Book book3 = new Book("Spirit Controlled Temperament","Tim Lahaye",20,"SBN-4567-9876");
        assertFalse(member.isBookWithMember(book3));
    }

    @Test
    public void testBorrowBook() {
        getBooks();
        Member member = new Member();
        member.setBooksWithMember(booksWithMember);
        Book book3 = new Book("Spirit Controlled Temperament","Tim Lahaye",20,"SBN-4567-9876");
        member.borrowBook(book3);
        assertTrue(member.isBookWithMember(book3));
        assertFalse(!member.isBookWithMember(book3));
    }

    @Test
    public void testReturnBookWhenAMemberHasBooks() {
        getBooks();
        Member member = new Member();
        Book book2 = new Book("How to win friends and Influence People","Dale Carnegie",12,"ISBN 1345-7890");
        member.setBooksWithMember(booksWithMember);
        member.returnBook(book2);
        assertTrue(!member.isBookWithMember(book2));
        assertFalse(member.isBookWithMember(book2));
    }

    @Test
    public void testReturnBookWhenAMemberHasNoBooks() {
        List<Book> booksWithMember = new ArrayList<Book>();
        Member member = new Member();
        Book book2 = new Book("How to win friends and Influence People","Dale Carnegie",12,"ISBN 1345-7890");
        member.setBooksWithMember(booksWithMember);
        member.returnBook(book2);
    }

    @Test
    public void testCompareToWhenMembersHaveDifferentRegistrationDate() {
        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        Member member2 = new Member("Tosin Adesanya",'M',"19820922","tosin.adesanya@andela.com","0805 897 3903");
        member2.setDateOfRegistration(member1.getDateOfRegistration().plusSeconds(1));

        assertEquals(-1, member1.compareTo(member2));
        assertEquals(1, member2.compareTo(member1));
    }

    @Test
    public void testCompareToWhenMembersHaveSameRegistrationDate() {
        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        Member member2 = new Member("Tosin Adesanya",'M',"19820922","tosin.adesanya@andela.com","0805 897 3903");

        DateTime dateTime = member1.getDateOfRegistration();
        member2.setDateOfRegistration(dateTime);

        assertEquals(0, member1.compareTo(member2));
        assertEquals(0,member1.compareTo(member2));
    }

}
