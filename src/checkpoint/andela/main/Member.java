package checkpoint.andela.main;

import checkpoint.andela.members.ReadersClub;

import checkpoint.andela.members.Staff;

import checkpoint.andela.members.Students;

import org.joda.time.DateTime;

import java.util.Comparator;

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

       ReadersClub readersClub = new ReadersClub();

        readersClub.registerMembers();

        readersClub.getAllReaders();

        if(ReadersClub.clubMembers.size()>=1) {
            PriorityQueue<Member> registeredReaders = new PriorityQueue(ReadersClub.clubMembers.size(), memberPreference);

            for (Member m : ReadersClub.clubMembers)
                registeredReaders.offer(m);

            Member prioritizedMember = registeredReaders.poll();
            System.out.println(getBorrowerDetails(prioritizedMember));
        }

        else
            System.out.println("There exists no member");

    }

    public void returnBook(Book book){
    }

    public  String getBorrowerDetails(Member m){

        DateTime registrationDate = m.getDateOfRegistration();

        boolean isStaff = false;

        String borrowerDetails = "";

        for(Staff staff:ReadersClub.staffReaders) {

            if( registrationDate.equals(staff.getDateOfRegistration())) {

                isStaff = true;
                borrowerDetails = "Borrower's Name: " + staff.getFullName() + "\nStaff Id: " + staff.getStaffNumber();
                break;

            }
        }

        if (isStaff == false)
        {
            for(Students student:ReadersClub.studentReaders) {

                if( registrationDate.equals(student.getDateOfRegistration())) {

                    borrowerDetails = "Borrower's Name: " + student.getFullName() + "\nStudent Id: " + student.getStudentNumber();
                    break;

                }
            }
        }
        return  borrowerDetails;

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
