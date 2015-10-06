package checkpoint.andela.main;

import checkpoint.andela.members.ReadersClub;

import org.joda.time.DateTime;

/**
 * Represents member information.
 */

public class Member {
    /**
     * Member Class Properties
     */
    private String fullName;

    private char gender;

    private String dateOfBirth;

    private String emailAddress;

    private String phoneNumber;

    private DateTime dateOfRegistration;

    /**
     * Create a new member with default properties
     */
    public Member() {
    }

    /**
     * Create a new member with specific properties
     */
    public Member(String fullName, char gender, String dateOfBirth, String emailAddress, String phoneNumber) {

        this.fullName = fullName;

        this.gender = gender;

        this.dateOfBirth = dateOfBirth;

        this.emailAddress = emailAddress;

        this.phoneNumber = phoneNumber;

        getCurrentDate();

        this.dateOfRegistration = getDateOfRegistration();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration() {
        this.dateOfRegistration = getCurrentDate();
    }

    public DateTime getCurrentDate() {
        DateTime dateOfRegistration = DateTime.now();
        this.dateOfRegistration = dateOfRegistration;
        return dateOfRegistration;
    }

    public void borrowBook(Book book) {

        ReadersClub readersClub = new ReadersClub();
        if(readersClub.bookIsAvailable(book)) {
            readersClub.getMembers();
            readersClub.registerMembers(readersClub.staffReaders, readersClub.studentReaders);
            Member bookBorrower = readersClub.getBorrower(readersClub.staffReaders, readersClub.studentReaders);
            System.out.println(readersClub.getBorrowerDetails(bookBorrower, readersClub.staffReaders, readersClub.studentReaders));
            if(readersClub.clubMembers.size()>=1)
            System.out.println("Book borrowed: "+book.getBookName());
            readersClub.removeFromBooks(book);
        }
        else
            System.out.println("The book  does not exist");
    }

    public void returnBook(Book book) {
        ReadersClub readersClub = new ReadersClub();
        readersClub.addtoBooks(book);
    }
}





