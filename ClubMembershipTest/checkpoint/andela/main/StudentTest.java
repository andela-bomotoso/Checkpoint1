package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.joda.time.DateTime;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.junit.Assert.*;

public class StudentTest {



    @Test
    public void testCompareTwoStudentsWithEqualRegistrationDate() {

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        Student student2 = new Student("Daniel James",'M',"19870430","daniel.james@andela.com","0706 574 5963", "C10-L1-0112","Class 10");

        DateTime dateTime = student1.getDateOfRegistration();
        student2.setDateOfRegistration(dateTime);

        assertEquals(0,student1.compareTo(student2));

    }

    @Test
    public void testCompareTwoStudentsWithDifferentRegistrationDate() {

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");

        Student student2 = new Student("Daniel James",'M',"19870430","daniel.james@andela.com","0706 574 5963", "C10-L1-0112","Class 10");
        student2.setDateOfRegistration(student1.getDateOfRegistration().plusHours(1));

        assertEquals(-1, student1.compareTo(student2));
        assertEquals(1, student2.compareTo(student1));
    }

    @Test
    public void testCompareStaffAndStudentWithSameRegistratonDate() {
        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);

        staff1.setDateOfRegistration(student1.getDateOfRegistration());

        assertEquals(1, student1.compareTo(staff1));

    }

    @Test
    public void testCompareStaffAndStudentWithDifferentRegistrationDate() {

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        staff1.setDateOfRegistration(student1.getDateOfRegistration().plusSeconds(1));
        assertEquals(1, student1.compareTo(staff1));
    }



}
