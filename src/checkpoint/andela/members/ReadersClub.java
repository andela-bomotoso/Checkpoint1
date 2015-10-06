package checkpoint.andela.members;
import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by GRACE on 9/29/2015.
 */

public class ReadersClub {

    public  List<Member> clubMembers = new ArrayList<Member>();

    public  List<Staff>  staffReaders = new ArrayList<Staff>();

    public  List<Students> studentReaders = new ArrayList<Students>();

    public  List<Book> clubBooks = new ArrayList<Book>();

    public void getMembers(){

        Staff staff1 = new Staff("Tosin", 'M', "19860113", "tosin.adesanya@andela.com", "08068999877", "L1-0119", 230000.456);

        Staff staff2 = new Staff("Prosper", 'M', "19880413", "prosper.otemuyiwa@andela.com", "07089740924", "L1-0110", 230000.456);

        Staff staff3 = new Staff("Nad", 'M', "19870723", "nadayar@andela.com", "09098765545", "L1-0106", 98000.676);

        Students student1 = new Students("Grace", 'F', "19860113", "bukola.omotoso@andela.com", "08067241691", "C10-L1-0119", "Class 10");

        Students student2 = new Students("Daniel", 'M', "19880413", "daniel.james@andela.com", "08067241691", "C09L1-0110", "Class 9");

        Students student3 = new Students("Obioma", 'F', "19870723", "obioma.ofoomalu@andela.com", "09098765545", "C08-L1-0106", "Class 8");

        staffReaders.add(staff1);
        staffReaders.add(staff2);
        staffReaders.add(staff3);

        studentReaders.add(student1);
        studentReaders.add(student2);
        studentReaders.add(student3);
    }

    public List<Member> registerMembers(List<Staff > staffReaders, List<Students> studentReaders) {

        for(Staff staff: staffReaders)
        clubMembers.add(staff);

        for(Students student: studentReaders)
            clubMembers.add(student);

        return clubMembers;
    }

    public Member getBorrower(List<Staff>staffReaders, List<Students>studentReaders) {
        List<Member> clubMembers =  registerMembers(staffReaders,studentReaders);

        if (clubMembers.size() >= 1) {
            PriorityQueue<Member> registeredReaders = new PriorityQueue(clubMembers.size(), memberPreference);

            for (Member m : clubMembers)
                registeredReaders.offer(m);
            Member prioritizedMember = registeredReaders.poll();
            return  prioritizedMember;
        }
        else
            return null;
    }

    public String getBorrowerDetails(Member m,List<Staff>staffReaders, List<Students>studentReaders){

        if(m!=null) {

            DateTime registrationDate = m.getDateOfRegistration();

            boolean isStaff = false;

            String borrowerDetails = "";
            for (Staff staff : staffReaders) {

                if (registrationDate.equals(staff.getDateOfRegistration())) {

                    isStaff = true;
                    borrowerDetails = "Borrower's Name: " + staff.getFullName() + "\nStaff Id: " + staff.getStaffNumber();
                    break;
                }
            }

            if (isStaff == false) {
                for (Students student : studentReaders) {

                    if (registrationDate.equals(student.getDateOfRegistration())) {

                        borrowerDetails = "Borrower's Name: " + student.getFullName() + "\nStudent Id: " + student.getStudentNumber();
                        break;

                    }
                }
            }
            return borrowerDetails;
        }
        else
            return "No registered member in the club";

    }


    public void getBooks(){

        Book book1 = new Book("Gifted Hands","Ben Carson",10,"ISSN 1596-6984");
        clubBooks.add(book1);

        Book book2 = new Book("How to win friends and Influence People","Dale Carnegie",12,"ISBN 1345-7890");
        clubBooks.add(book2);

        Book book3 = new Book("Spirit Controlled Temperament","Tim Lahaye",20,"ISBN-4567-9876");
        clubBooks.add(book3);
    }

    public void addtoBooks(Book book){
        for(Book curentBook : clubBooks) {
            if (curentBook.getBookName().equals(book.getBookName())) {
                curentBook.setNoOfCopies(curentBook.getNoOfCopies() + 1);
                break;
            }
        }
    }

    public void removeFromBooks(Book book){
        for(Book curentBook : clubBooks) {
            if (curentBook.getBookName().equals(book.getBookName())) {
                curentBook.setNoOfCopies(curentBook.getNoOfCopies() - 1);
                break;
            }
        }
    }


    public boolean bookIsAvailable(Book book){
        getBooks();
        boolean bookAvailable = false;
        for(Book curentBook : clubBooks)
        if(curentBook.getBookName().equals(book.getBookName())){
                curentBook.setNoOfCopies(curentBook.getNoOfCopies()-1);
                bookAvailable = true;
                break;
            }
        return bookAvailable;
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

