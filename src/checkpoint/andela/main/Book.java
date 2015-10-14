package checkpoint.andela.main;

import java.util.List;

/**
 * Represents book information.
 */

public class Book {

    /**
     * Book Class Properties
     */

    private String bookName;

    private String author;

    private int noOfCopies;

    private String isbnNumber;

    /**
     * Create a new book with default properties
     */

    public Book() {
    }

    /**
     * Create a new book with specific properties
     */

    public Book(String bookName, String author, int noOfCopies, String isbnNumber) {

        this.bookName = bookName;

        this.author = author;

        this.noOfCopies = noOfCopies;

        this.isbnNumber = isbnNumber;
    }

    public String getBookName() {

        return bookName;
    }

    public void setBookName(String bookName) {

        this.bookName = bookName;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public int getNoOfCopies() {

        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {

        this.noOfCopies = noOfCopies;
    }

    public String getIsbnNumber() {

        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {

        this.isbnNumber = isbnNumber;
    }

    public void borrowBook(List<Book> clubBooks, int noOfCopies) {

        if (bookIsAvailable(clubBooks)) {
                Book currentBook = getCurrentBook(clubBooks);
                currentBook.setNoOfCopies(currentBook.getNoOfCopies() - noOfCopies);
            }
    }

    public void returnBook(List<Book> clubBooks, int noOfCopies) {
        Book currentBook = getCurrentBook(clubBooks);
        currentBook.setNoOfCopies(currentBook.getNoOfCopies() + noOfCopies);
    }

    public boolean bookIsAvailable(List<Book> clubBooks) {

        boolean bookAvailable = false;

        for (Book currentBook : clubBooks) {

            if (currentBook.getBookName().equals(this.getBookName())) {

                bookAvailable = true;
                break;
            }
        }

        return bookAvailable;
    }

    public Book getCurrentBook(List<Book> clubBooks) {
        Book currentBook = new Book();
        for (Book searchBook : clubBooks) {
            if (searchBook.getBookName().equals(this.getBookName())) {
                currentBook = searchBook;
                break;
            }
        }
        return currentBook;
    }
}





