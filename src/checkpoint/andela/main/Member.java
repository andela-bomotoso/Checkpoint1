package checkpoint.andela.main;

import org.joda.time.DateTime;

import java.util.ArrayList;

import java.util.List;


/**
 * Represents member information.
 */

public class Member implements Comparable<Member> {

    /**
     * Member Class Properties
     */

    private String fullName;

    private char gender;

    private String dateOfBirth;

    private String emailAddress;

    private String phoneNumber;

    private DateTime dateOfRegistration;

    private List<Book> booksWithMember;

    /**
     * Create a new member with default properties
     */

    public Member() {

        this.booksWithMember = new ArrayList<Book>();
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

        setDateOfRegistration(getCurrentDate());

        this.booksWithMember = new ArrayList<Book>();
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

    public void setDateOfRegistration(DateTime dateTime) {

        this.dateOfRegistration = dateTime;
    }

    public DateTime getCurrentDate() {

        DateTime dateOfRegistration = DateTime.now();

        this.dateOfRegistration = dateOfRegistration;

        return dateOfRegistration;
    }

    public List<Book> getBooksWithMember() {

        return booksWithMember;
    }
    public void setBooksWithMember(List<Book>booksWithMember) {

        this.booksWithMember = booksWithMember;
    }

    public void borrowBook(Book book) {

        booksWithMember.add(book);
    }

    public void returnBook(Book book) {
        if(getBooksWithMember().contains(book)) {
            booksWithMember.remove(book);
        }
    }

    @Override
    public int compareTo(Member member) {
     return  this.getDateOfRegistration().compareTo(member.getDateOfRegistration());
    }

}








