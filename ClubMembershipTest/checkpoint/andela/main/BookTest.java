package checkpoint.andela.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testIncrementCopyWhenBookCopyIsMoreThanZero() {

        Book book1 = new Book("Gifted Hands","Ben Carson",10,"ISBN 1596-6984");
        book1.incrementCopy();
        assertEquals(11, book1.getNoOfCopies());
    }

    @Test
    public void testIncrementCopyWhenBookCopyIsZero() {

        Book book1 = new Book("Gifted Hands","Ben Carson",0,"ISBN 1596-6984");
        book1.incrementCopy();
        assertEquals(1, book1.getNoOfCopies());
    }

    @Test
    public void testDecrementCopyWhenBookCopyIsMoreThanZero() {

        Book book1 = new Book("Gifted Hands","Ben Carson",10,"ISBN 1596-6984");
        book1.decrementCopy();
        assertEquals(9, book1.getNoOfCopies());
    }

    @Test
    public void testDecrementCopyWhenBookCopyIsZero() {

        Book book1 = new Book("Gifted Hands","Ben Carson",0,"ISBN 1596-6984");
        book1.decrementCopy();
        assertEquals(0, book1.getNoOfCopies());
    }

    @Test
    public void testEqualsWhenBooksAreDifferent() {
        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        Book book2 = new Book("Why you act the way you do","Tim Lahaye",7,"ISBN 1596-6874");

        assertFalse(book1.equals(book2));
    }

    @Test
    public void testEqualsWhenBooksAreTheSame() {
        Book book1 = new Book("Gifted Hands","Ben Carson",5,"ISBN 1596-6984");
        Book book2 = new Book();
        book2.setBookName(book1.getBookName());

        assertTrue(book1.equals(book2));
    }


}