package checkpoint.andela.main;

/**
 * Created by GRACE on 10/7/2015.
 */
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {

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
    public void testBookIsAvailable(){
        getBooks();
        Book book4 = new Book();
        Book book5 = new Book();
        book4.setBookName("How to win friends and Influence People");
        book5.setBookName("Think and Grow Rich");
        assertTrue(book4.bookIsAvailable(clubBooks));
        assertFalse(book5.bookIsAvailable(clubBooks));
    }

    @Test
    public void testBorrowBook(){

        getBooks();
        Book book4 = new Book();
        Book book5 = new Book();
        book4.setBookName("Gifted Hands");
        book4.borrowBook(clubBooks, 2);
        assertEquals(8, clubBooks.get(0).getNoOfCopies());
    }

    @Test
    public void testReturnBook(){

        getBooks();
        Book book4 = new Book();
        Book book5 = new Book();
        book4.setBookName("Gifted Hands");
        book4.returnBook(clubBooks, 2);
        assertEquals(12,clubBooks.get(0).getNoOfCopies());
    }



}