package checkpoint.andela.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    /*List<Book>clubBooks = new ArrayList<Book>();

    public void getBooks(){

        Book book1 = new Book("Gifted Hands","Ben Carson",10,"ISBN 1596-6984");
        clubBooks.add(book1);

        Book book2 = new Book("How to win friends and Influence People","Dale Carnegie",12,"ISBN 1345-7890");
        clubBooks.add(book2);

        Book book3 = new Book("Spirit Controlled Temperament","Tim Lahaye",20,"SBN-4567-9876");
        clubBooks.add(book3);
    }*/

    @Test
    public void testIncrementCopy() {

        Book book1 = new Book("Gifted Hands","Ben Carson",10,"ISBN 1596-6984");
        book1.incrementCopy();
        assertEquals(11, book1.getNoOfCopies());
    }

    @Test
    public void testDecrementCopy() {

        Book book1 = new Book("Gifted Hands","Ben Carson",10,"ISBN 1596-6984");
        book1.decrementCopy();
        assertEquals(9, book1.getNoOfCopies());
    }

}