package checkpoint.andela.main;

import checkpoint.andela.members.Staff;

import checkpoint.andela.members.Student;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookBorrowerTest {

    //Test with Staff members and Students

    @Test
    public void testGetBorrower1() {

        BookBorrower bookBorrower = new BookBorrower();

        List<Member> clubMembers =  new ArrayList<Member>();
        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        clubMembers.add(student1);

        Student student2 = new Student("Daniel James",'M',"19870430","daniel.james@andela.com","0706 574 5963", "C10-L1-0112","Class 10");
        clubMembers.add(student2);

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        clubMembers.add(staff1);

        Staff staff2 =  new Staff("Prosper Otemuyiwa",'M',"19821015","prosper.otemuyiwa@andela.com","0803 814 5671", "C10-L2-06",230000.00);
        clubMembers.add(staff2);

        assertEquals(staff1, bookBorrower.getBorrower(clubMembers));
    }

    //Test with Students
    @Test
    public void testGetBorrower2() {

        BookBorrower bookBorrower = new BookBorrower();

        List<Member> clubMembers =  new ArrayList<Member>();

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        clubMembers.add(student1);

        Student student2 = new Student("Daniel James",'M',"19870430","daniel.james@andela.com","0706 574 5963", "C10-L1-0112","Class 10");
        clubMembers.add(student2);

        Student student3 = new Student("Obioma Ofoamalu",'F',"19870413","obioma.ofoamalu@andela.com","0807 344 4102","C10-L1-0109", "Class 10");
        clubMembers.add(student1);

        Student student4 = new Student("Faical Tchirou",'M',"19870630","faical.tchirou@andela.com","0706 574 8763", "C10-L1-0102","Class 10");
        clubMembers.add(student2);

        assertEquals(student1,bookBorrower.getBorrower(clubMembers));
    }

    //Test with Staff members
    @Test
    public void testGetBorrower3() {

        BookBorrower bookBorrower = new BookBorrower();

        List<Member> clubMembers =  new ArrayList<Member>();


        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        clubMembers.add(staff1);

        Staff staff2 =  new Staff("Prosper Otemuyiwa",'M',"19821015","prosper.otemuyiwa@andela.com","0803 814 5671", "C10-L2-06",230000.00);
        clubMembers.add(staff2);


        Staff staff3 =  new Staff("Uche Albert",'M',"19811015","uche.albert@andela.com","0803 984 5671", "C10-L2-06",230000.00);
        clubMembers.add(staff3);

        assertEquals(staff1, bookBorrower.getBorrower(clubMembers));
    }

}
