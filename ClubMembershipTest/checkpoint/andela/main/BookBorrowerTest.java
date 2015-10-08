package checkpoint.andela.main;

import checkpoint.andela.members.Staff;

import checkpoint.andela.members.Student;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookBorrowerTest {

    List<Book>clubBooks = new ArrayList<Book>();

    public void getBooks(){

        Book book1 = new Book("Gifted Hands","Ben Carson",10,"ISSN 1596-6984");
        clubBooks.add(book1);

        Book book2 = new Book("How to win friends and Influence People","Dale Carnegie",12,"ISBN 1345-7890");
        clubBooks.add(book2);

        Book book3 = new Book("Spirit Controlled Temperament","Tim Lahaye",20,"SBN-4567-9876");
        clubBooks.add(book3);
    }

    @Test
    public void testGetBorrower() throws IllegalArgumentException {

        BookBorrower bookBorrower = new BookBorrower();

        List<Member> clubMembers =  new ArrayList<Member>();

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        clubMembers.add(staff1);

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        clubMembers.add(student1);

        Student student2 = new Student("Daniel James",'M',"19870430","daniel.james@andela.com","0706 574 5963", "C10-L1-0112","Class 10");
        clubMembers.add(student2);

        assertEquals(staff1,bookBorrower.getBorrower(clubMembers));
    }


}
