package checkpoint.andela.main;

/**
 * Created by GRACE on 10/8/2015.
 */

import checkpoint.andela.members.*;
public class BookBorrower {

    private Students student;
    private Staff staff;

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void borrowBook(Book book) {

        ReadersClub readersClub = new ReadersClub();
        if(readersClub.bookIsAvailable(book)) {
            readersClub.getMembers();
            readersClub.registerMembers(readersClub.staffReaders, readersClub.studentReaders);
            Member bookBorrower = readersClub.getBorrower(readersClub.staffReaders, readersClub.studentReaders);
            System.out.println(readersClub.getBorrowerDetails(bookBorrower, readersClub.staffReaders, readersClub.studentReaders));
            if(readersClub.clubMembers.size()>1)
                System.out.println("Book borrowed: "+book.getBookName());
            readersClub.removeFromBooks(book);
        }
        else
            System.out.println("The book  does not exist");
    }

    public void returnBook(Book book) {
        ReadersClub readersClub = new ReadersClub();
        readersClub.addToBooks(book);
    }
}
