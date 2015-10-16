package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffTest {

    @Test
    public void testCompareTwoStaffWithEqualRegistrationDate() {

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        Staff staff2 =  new Staff("Prosper Otemuyiwa",'M',"19821015","prosper.otemuyiwa@andela.com","0803 814 5671", "C10-L2-06",230000.00);

        DateTime dateTime = staff1.getDateOfRegistration();
        staff2.setDateOfRegistration(dateTime);

        assertEquals(0, staff1.compareTo(staff2));
        assertEquals(0,staff2.compareTo(staff1));
    }

    @Test
    public void testCompareTwoStaffWithDifferentRegistrationDate() {

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);

        Staff staff2 =  new Staff("Prosper Otemuyiwa",'M',"19821015","prosper.otemuyiwa@andela.com","0803 814 5671", "C10-L2-06",230000.00);
        staff2.setDateOfRegistration(staff1.getDateOfRegistration().plusSeconds(1));

        assertEquals(-1, staff1.compareTo(staff2));
        assertEquals(1, staff2.compareTo(staff1));
    }

    @Test
    public void testCompareStaffAndStudentWithDifferentRegistrationDate() {

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");

        student1.setDateOfRegistration(staff1.getDateOfRegistration().plusSeconds(1));
        assertEquals(-1, staff1.compareTo(student1));
    }

    @Test
    public void testCompareStaffAndStudentWithSameRegistratonDate() {
        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);

        staff1.setDateOfRegistration(student1.getDateOfRegistration());

        assertEquals(-1, staff1.compareTo(student1));
    }

}
