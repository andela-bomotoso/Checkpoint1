package checkpoint.andela.main;

/**
 * Created by GRACE on 9/26/2015.
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
     * Default Constructor
     */
    public Book(){
    }

    /**
     * Constructor to set up Values
     */
    public Book(String bookName, String author, int noOfCopies, String isbnNumber){
        this.bookName = bookName;
        this.author= author;
        this.noOfCopies = noOfCopies;
        this.isbnNumber = isbnNumber;
    }

    // Get Book's Name

    public String getBookName() {
        return bookName;
    }

    // Set Book's Name
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    // Get Book's Author
    public String getAuthor() {
        return author;
    }

    // Set Book's Author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Get Book's No of Copies
    public int getNoOfCopies() {
        return noOfCopies;
    }

    // Set Book's No of Copies
    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    // Get Book's ISBN Number
    public String getIsbnNumber() {
        return isbnNumber;
    }

    // Set Book's ISBN Number
    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }
}
