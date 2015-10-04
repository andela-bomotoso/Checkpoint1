package checkpoint.andela.members;
import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by GRACE on 9/29/2015.
 */

public class ReadersClub {

    public  static List<Member> clubMembers = new ArrayList<Member>();

    public  static List<Staff>  staffReaders = new ArrayList<Staff>();

    public  static List<Students> studentReaders = new ArrayList<Students>();

    public static List<Book> clubBooks = new ArrayList<Book>();

    public List<Member> registerMembers(List<Staff > staffReaders, List<Students> studentReaders) {

        for(Staff staff: staffReaders)
        clubMembers.add(staff);

        for(Students student: studentReaders)
            clubMembers.add(student);

        return clubMembers;
    }

    /**
     * Add staff readers and student readers to club members
     */

    public void getAllReaders(){


    }

    public void registerBooks(){

        Book book1 = new Book("Gifted Hands","Ben Carson",10,"ISSN 1596-6984");
        clubBooks.add(book1);

        Book book2 = new Book("How to win friends and Influence People","Dale Carnegie",12,"ISBN 1345-7890");
        clubBooks.add(book2);

        Book book3 = new Book("Spirit Controlled Temperament","Tim Lahaye",20,"ISBN-4567-9876");
        clubBooks.add(book3);
    }
    /**
     * A Comparator anonymous class to specify how the registered readers queue will be prioritized
     */
    public static Comparator<Member> memberPreference = new Comparator<Member>() {

        /**
         * If two members have the same readers category of either staff or students, registration date should take precedence
         * otherwise, the staff reader should take precedence
         */

        @Override
        public int compare(Member m1, Member m2) {
                    return (isStaff(m1) == isStaff(m2)) ? m1.getDateOfRegistration().compareTo(m2.getDateOfRegistration())
                            : (isStaff(m1) ? -1 : 1);
                }
        /**
         * Determine if a member is a staff or student
         */
         public boolean isStaff(Member m)   {
             if (m.getClass().getSimpleName().equalsIgnoreCase( "Staff"))
                return  true;
             else
                return false;
         }
    };
}
