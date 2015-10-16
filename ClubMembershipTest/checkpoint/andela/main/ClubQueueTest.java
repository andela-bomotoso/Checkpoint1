package checkpoint.andela.main;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

public class ClubQueueTest {

    @Test
    public void testContainsMemberWhenAMemberIsInTheClub() {
        ClubQueue clubQueue = new ClubQueue();
        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        clubQueue.addMember(member1);
        assertTrue(clubQueue.containsMember(member1));
    }

    @Test
    public void testContainsMemberWhenAMemberIsNotInTheClub() {
        ClubQueue clubQueue = new ClubQueue();
        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        assertFalse(clubQueue.containsMember(member1));
    }

    @Test
    public void testAddMemberWhenAMemberExistsInTheQueue() {
        ClubQueue clubQueue = new ClubQueue();
        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");
        clubQueue.addMember(member1);
        assertTrue(clubQueue.containsMember(member1));
    }

    @Test
    public void testAddMemberWhenAMemberDoesNotExistInTheQueue() {
        ClubQueue clubQueue = new ClubQueue();

        Member member1 = new Member("Grace Omotoso",'F',"19860113","gracomot@yahoo.com","0807 904 4102");

        assertFalse(clubQueue.containsMember(member1));
    }

    @Test
    public void testGetPriorityMemberWhenStaffAndStudentAreInTheQueue() {
        ClubQueue clubQueue = new ClubQueue();

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        clubQueue.addMember(student1);

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        clubQueue.addMember(staff1);

        assertEquals(staff1, clubQueue.getPriorityMember());
    }

    @Test
    public void testGetPriorityMemberWhenTwoStudentsAreInTheQueue() {
        ClubQueue clubQueue = new ClubQueue();

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119", "Class 10");
        clubQueue.addMember(student1);

        Student student2 = new Student("Daniel James",'M',"19870430","daniel.james@andela.com","0706 574 5963", "C10-L1-0112","Class 10");
        student2.setDateOfRegistration(student1.getDateOfRegistration().plusHours(1));
        clubQueue.addMember(student2);

        assertEquals(student1,clubQueue.getPriorityMember());
    }

    @Test
    public void testGetPriorityMemberWhenTwoStaffMembersAreInTheQueue() {
        ClubQueue clubQueue = new ClubQueue();

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771", "C10-L2-0116",230000.00);
        clubQueue.addMember(staff1);
        Staff staff2 =  new Staff("Prosper Otemuyiwa",'M',"19821015","prosper.otemuyiwa@andela.com","0803 814 5671", "C10-L2-06",230000.00);
        staff2.setDateOfRegistration(staff1.getDateOfRegistration().plusSeconds(1));

        clubQueue.addMember(staff2);

        assertEquals(staff1,clubQueue.getPriorityMember());
    }

    @Test
    public void testGetPriorityMemberWhenQueueIsEmpty() {
        ClubQueue clubQueue = new ClubQueue();
        assertNull(clubQueue.getPriorityMember());
    }
}
