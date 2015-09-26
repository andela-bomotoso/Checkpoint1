package checkpoint.andela.main;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by GRACE on 9/26/2015.
 */
public class Member {

    /**
     * Member Class Properties
     */
    private String fullName;
    private char gender;
    private String dateOfBirth;
    private String  emailAddress;
    private String phoneNumber;
    private Date dateOfRegistration;

    /**
     * Default Constructor
     */
    public Member(){
    }

    /**
     *  Constructor to set up Values
     */
    public Member(String fullName,char gender,String dateOfBirth, String emailAddress, String phoneNumber){
        this.fullName =  fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber =  phoneNumber;
        //this.dateOfRegistration = Syste
    }

    // Get Member's Fullname

    public String getFullName() {
        return fullName;
    }

    // Set Member's Fullname

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Get Member's Gender

    public char getGender() {
        return gender;
    }

    // Set Member's Gender

    public void setGender(char gender) {
        this.gender = gender;
    }

    // Get Member's Date Of Birth

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // Set Member's Date Of Birth
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Get Member's Email Address
    public String getEmailAddress() {
        return emailAddress;
    }

    // Set Member's Email Address
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // Get Member's Phone Number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Set Members's Phone Number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Get Member's Date Of Registration
    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    // Set Member's Date Of Registration
    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

   // Return Current Date
   /* public Date getCurrentDate() {
        java.util.Date date = Calendar.getInstance().getTime();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.hhmmss");
        return  date;
    }*/

    // Borrow a Book
    public void borrowBook(){

    }

    // Return Borrowed Book
    public void returnBook(){

    }



}
