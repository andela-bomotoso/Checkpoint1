package checkpoint.andela.main;




/**
 * Created by GRACE on 10/4/2015.
 */

import checkpoint.andela.members.ReadersClub;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Students;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClubMembershipTest {

    public List<Staff> staffReaders = new ArrayList<Staff>();

    public List<Students> studentReaders = new ArrayList<Students>();

    public List<Member> clubMembers = new ArrayList<Member>();

    public List<Book> clubBooks = new ArrayList<Book>();

    ReadersClub readersClub = new ReadersClub();

    Staff staff1 = new Staff();
    Staff staff2 = new Staff();
    Students student1 = new Students();
    Book book1 = new Book();
    Book book2 = new Book();
    Book book3 = new Book();

    public void getMembers(){

        staff1.setFullName("Tosin Adesanya");
        staff1.setGender('M');
        staff1.setDateOfBirth("19820113");
        staff1.setEmailAddress("tosin.adesanya@andela.com");
        staff1.setPhoneNumber("08068999877");
        staff1.setStaffNumber("L1-0119");
        staff1.setNetPay(230000.456);
        staff1.setDateOfRegistration();
        staffReaders.add(staff1);

        staff2.setFullName("Prosper Otemuyiwa");
        staff2.setGender('M');
        staff2.setDateOfBirth("19880413");
        staff2.setEmailAddress("prosper.otemuyiwa@andela.com");
        staff2.setPhoneNumber("07089740924");
        staff2.setStaffNumber("L1-0110");
        staff2.setNetPay(230000.456);
        staff2.setDateOfRegistration();
        staffReaders.add(staff2);


        student1.setFullName("Daniel James");
        student1.setGender('M');
        student1.setDateOfBirth("19880413");
        student1.setPhoneNumber("08037241691");
        student1.setStudentNumber("C09L1-0110");
        student1.setStudentClass("Class 9");
        student1.setDateOfRegistration();
        studentReaders.add(student1);
    }


    public void getBooks() {

        //Book book1 = new Book("Gifted Hands","Ben Carson",10,"ISSN 1596-6984");
        book1.setBookName("Gifted Hands");
        book1.setAuthor("Ben Carson");
        book1.setNoOfCopies(10);
        book1.setIsbnNumber("ISSN 1596-6984");
        clubBooks.add(book1);

        book2.setBookName("How to win friends and Influence People");
        book2.setAuthor("Dale Carnegie");
        book2.setNoOfCopies(12);
        book2.setIsbnNumber("ISBN 1345-7890");
        clubBooks.add(book2);

        book3.setBookName("Spirit Controlled Temperament");
        book3.setAuthor("Tim Lahaye");
        book3.setNoOfCopies(20);
        book3.setIsbnNumber("ISBN-4567-9876");
        clubBooks.add(book3);
    }

    @Test
    public void testGetBorrower(){
        getMembers();
        assertEquals(staff1, readersClub.getBorrower(staffReaders, studentReaders));

    }

    @Test
    public void testGetBorrowerDetails(){

        getMembers();
        String message =  "Borrower's Name: " + "Tosin Adesanya" + "\nStaff Id: " + "L1-0119";
        String message2 = "Borrower's Name: " + "Prosper Otemuyiwa" + "\nStaff Id: " + "L1-0110";
        String message3 = "Borrower's Name: " + "Daniel James" + "\nStudent Id: " + "C09L1-0110";

        assertEquals(message3, readersClub.getBorrowerDetails(student1, staffReaders, studentReaders));
        assertEquals(message2, readersClub.getBorrowerDetails(staff2, staffReaders, studentReaders));
        assertEquals(message, readersClub.getBorrowerDetails(staff1, staffReaders, studentReaders));


    }

    @Test
    public void testRegisterMembers(){
        getMembers();

        for(Staff staff: staffReaders)
            clubMembers.add(staff);

        for (Students students : studentReaders)
        clubMembers.add(students);
        assertEquals(clubMembers, readersClub.registerMembers(staffReaders, studentReaders));
    }

    @Test
    public  void testBookIsAvailable(){
        getBooks();
        Book book4 = new Book();
        Book book5 = new Book();
        book4.setBookName("How to win friends and Influence People");
        book5.setBookName("Think and Grow Rich");
        assertTrue(readersClub.bookIsAvailable(book4));
        assertFalse(readersClub.bookIsAvailable(book5));
    }

    @Test
    public void testIsStudent(){
        getMembers();
        assertFalse(readersClub.isStudent("00124"));
        assertTrue(readersClub.isStudent("C10-L1-0119"));
    }













}
