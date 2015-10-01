package checkpoint.andela.main;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
    public Member(){
    }

    /**
     *  Create a new member with specific properties
     */
    public Member(String fullName,char gender,String dateOfBirth, String emailAddress, String phoneNumber){

        this.fullName =  fullName;

        this.gender = gender;

        this.dateOfBirth = dateOfBirth;

        this.emailAddress = emailAddress;

        this.phoneNumber =  phoneNumber;
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
        return  dateOfRegistration;
    }

    public void setDateOfRegistration(DateTime dateOfRegistration)  {

        this.dateOfRegistration = dateOfRegistration;
    }

    public DateTime getCurrentDate(){

        /**
         * Delay this execution for 2ms incase Members are created consecutively
         * This will make registration date unique
         */

        try{
            Thread.currentThread().sleep(1);
        }
        catch (Exception e){

        }

        DateTime dateOfRegistration = DateTime.now();
        this.dateOfRegistration = dateOfRegistration;
        return  dateOfRegistration;
    }
    public void borrowBook(Book book){

        List<Member> clubMembers = new ArrayList<Member>();

        PriorityQueue<Member> registeredReaders = new PriorityQueue(clubMembers.size(), memberPreference);

        for (Member m : clubMembers)
            registeredReaders.offer(m);

        System.out.println("Book Borrower: " + registeredReaders.poll().getFullName());
    }

    public void returnBook(Book book){

    }

    /**
     * A Comparator anonymous class to specify how the registered readers queue will be prioritized
     */
    public static Comparator<Member> memberPreference = new Comparator<Member>() {
        @Override
        public int compare(Member m1, Member m2) {
            /**
             * if two members have the same readers category of either staff or students, registration date should take precedence
             * otherwise, the staff reader should take precedence
             */
            return (isStaff(m1) == isStaff(m2)) ? m1.getDateOfRegistration().compareTo(m2.getDateOfRegistration())
                    : (isStaff(m1) ? -1 : 1);
        }

        /**
         * determine if a member is a staff or student
         */
        public boolean isStaff(Member m)   {
            if (m.getClass().getSimpleName().equalsIgnoreCase( "Staff"))
                return  true;
            else
                return false;
        }
    };

}
