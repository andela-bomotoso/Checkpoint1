package checkpoint.andela.main;

import checkpoint.andela.members.*;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void testIsAStaff(){

        List<Member>clubMembers =  new ArrayList<Member>();

        Staff staff1 =  new Staff("Tosin Adesanya",'M',"19800915","tosin.adesanya@andela.com","0803 814 2771","C10-L2-0116",230000.00);
        clubMembers.add(staff1);

        Student student1 = new Student("Grace Omotoso",'F',"19860113","bukola.omotoso@andela.com","0807 904 4102","C10-L1-0119","Class 10");
        clubMembers.add(student1);

        assertTrue(clubMembers.get(0).isAStaff());
        assertFalse(clubMembers.get(1).isAStaff());
    }

}
