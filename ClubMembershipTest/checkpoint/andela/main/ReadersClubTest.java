package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ReadersClubTest{

    @Test
    public void testRegisterAMember() {
        ReadersClub readersClub = new ReadersClub();

        Member member = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        readersClub.registerAMember(member);

        assertTrue(readersClub.getRegisteredMembers().contains(member));
    }

    @Test
    public void testRegisterMembers() {
        List<Member>membersofotherClub = new ArrayList<Member>();
        ReadersClub readersClub = new ReadersClub();

        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        membersofotherClub.add(member1);
        Member member2 = new Member("Tosin Adesanya",'M',"19820922","tosin.adesanya@andela.com","0805 897 3903");
        membersofotherClub.add(member2);

        readersClub.registerMembers(membersofotherClub);

        assertTrue(readersClub.getRegisteredMembers().contains(membersofotherClub.get(0)));
        assertTrue(readersClub.getRegisteredMembers().contains(membersofotherClub.get(1)));

    }

    @Test
    public void testRegisterBook() {
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        readersClub.registerABook(book1);

        assertTrue(readersClub.getClubBooks().contains(book1));
    }

    @Test
    public void testRegisterBooks() {
        ReadersClub readersClub = new ReadersClub();
        List<Book> newlyPurchasedBooks = new ArrayList<Book>();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        newlyPurchasedBooks.add(book1);
        Book book2 = new Book("Why you act the way you do","Tim Lahaye",7,"ISBN 1596-6874");
        newlyPurchasedBooks.add(book2);

        readersClub.registerBooks(newlyPurchasedBooks);

        assertTrue(readersClub.getClubBooks().contains(newlyPurchasedBooks.get(0)));
        assertTrue(readersClub.getClubBooks().contains(newlyPurchasedBooks.get(1)));

    }

    @Test
    public void testBookIsAvailableWhenBookExistsInClubBooks() {
        List<Book> clubBooks = new ArrayList<Book>();
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        clubBooks.add(book1);
        Book book2 = new Book("Why you act the way you do","Tim Lahaye",7,"ISBN 1596-6874");
        clubBooks.add(book2);

        System.out.println(book2);
        System.out.println(clubBooks);
        readersClub.setClubBooks(clubBooks);
        assertTrue(readersClub.isBookAvailable(book2));
    }

    @Test
    public void testBookIsAvailableWhenBookDoesNotExistsInClubBooks() {
        List<Book> clubBooks = new ArrayList<Book>();
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        clubBooks.add(book1);
        Book book2 = new Book("Why you act the way you do","Tim Lahaye",7,"ISBN 1596-6874");
        clubBooks.add(book2);

        readersClub.setClubBooks(clubBooks);
        Book searchBook = new Book("How to Win Friends and Influence People","Dale Carnegie",5,"ISBN-7865-7899");

        assertFalse(readersClub.isBookAvailable(searchBook));
    }

    @Test
    public void testIsMemberRegisteredWhenMemberIsRegistered() {
        ReadersClub readersClub = new ReadersClub();

        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        readersClub.registerAMember(member1);

        assertTrue(readersClub.isMemberRegistered(member1));
    }

    @Test
    public void testIsMemberRegisteredWhenMemberIsNotRegistered() {
        ReadersClub readersClub = new ReadersClub();
        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");

        assertFalse(readersClub.isMemberRegistered(member1));
    }

    @Test
    public void testRequestForBookWhenBookExistsAndMemberIsRegistered() {
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        readersClub.registerABook(book1);

        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        readersClub.registerAMember(member1);
        Member member2 = new Member("Tosin Adesanya",'M',"19820922","tosin.adesanya@andela.com","0805 897 3903");
        readersClub.registerAMember(member2);

        readersClub.requestForABook(book1, member1);
        readersClub.requestForABook(book1, member2);

        assertTrue(readersClub.getBorrowersQueue().contains(member1));
        assertTrue(readersClub.getBorrowersQueue().contains(member2));
        assertEquals(2, readersClub.getBorrowersQueue().size());
    }

    @Test
    public void testRequestForBookWhenBookDoesNotExistAndMemberIsRegistered() {
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");

        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        readersClub.registerAMember(member1);
        Member member2 = new Member("Tosin Adesanya",'M',"19820922","tosin.adesanya@andela.com","0805 897 3903");
        readersClub.registerAMember(member2);

        readersClub.requestForABook(book1, member1);
        readersClub.requestForABook(book1, member2);

        assertEquals(0, readersClub.getBorrowersQueue().size());

    }

    @Test
    public void testRequestForBookWhenBookExistsAndMemberIsNotRegistered() {
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        readersClub.registerABook(book1);
        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        Member member2 = new Member("Tosin Adesanya",'M',"19820922","tosin.adesanya@andela.com","0805 897 3903");

        readersClub.requestForABook(book1, member1);
        readersClub.requestForABook(book1, member2);

        assertEquals(0, readersClub.getBorrowersQueue().size());

    }

    @Test
    public void testRequestForBookWhenBookDoesNotExistAndMemberIsNotRegistered() {
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");

        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        Member member2 = new Member("Tosin Adesanya",'M',"19820922","tosin.adesanya@andela.com","0805 897 3903");

        readersClub.requestForABook(book1, member1);
        readersClub.requestForABook(book1, member2);

        assertEquals(0, readersClub.getBorrowersQueue().size());

    }

    @Test
    public void testGetBookBorrowerWhenStaffandStudentsRequestForBook() {
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        readersClub.registerABook(book1);

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        readersClub.registerAMember(student1);

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        readersClub.registerAMember(staff1);

        readersClub.requestForABook(book1, staff1);
        readersClub.requestForABook(book1, student1);

        assertEquals(staff1,readersClub.getBookBorrower());
    }

    @Test
    public void testGetBookBorrowerWhenTwoStaffMembersRequestForBook() {
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        readersClub.registerABook(book1);

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        readersClub.registerAMember(staff1);

        Staff staff2 =  new Staff("Prosper Otemuyiwa",'M',"19821015","prosper.otemuyiwa@andela.com","0803 814 5671", "C10-L2-06",230000.00);
        staff2.setDateOfRegistration(staff1.getDateOfRegistration().plusSeconds(1));
        readersClub.registerAMember(staff2);


        readersClub.requestForABook(book1, staff1);
        readersClub.requestForABook(book1,staff2);

        assertEquals(staff1, readersClub.getBookBorrower());
    }

    @Test
    public void testGetBookBorrowerWhenTwoStudentsRequestForBook() {
        ReadersClub readersClub = new ReadersClub();

        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        readersClub.registerABook(book1);

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        readersClub.registerAMember(student1);

        Student student2 = new Student("Daniel James",'M',"19870430","daniel.james@andela.com","0706 574 5963", "C10-L1-0112","Class 10");
        student2.setDateOfRegistration(student1.getDateOfRegistration().plusHours(1));
        readersClub.registerAMember(student2);

        readersClub.requestForABook(book1, student1);
        readersClub.requestForABook(book1,student2);

        assertEquals(student1, readersClub.getBookBorrower());
    }




}
