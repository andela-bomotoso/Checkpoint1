package checkpoint.andela.main;




/**
 * Created by GRACE on 10/4/2015.
 */

import checkpoint.andela.members.ReadersClub;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Students;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClubMembershipTest {
    ReadersClub readersClub = new ReadersClub();

    public   List<Staff> staffReaders = new ArrayList<Staff>();

    public   List<Students> studentReaders = new ArrayList<Students>();

    Staff staff1 = new Staff();
    Staff staff2 = new Staff();

    @Test
    public void testIsStaff(){

    }

    @Test
    public void testRegisterMembers(){

        List<Member> clubMembers = new ArrayList<Member>();

        staff1.setFullName("Tosin Adesanya");
        staff1.setGender('M');
        staff1.setDateOfBirth("19820113");
        staff1.setEmailAddress("tosin.adesanya@andela.com");
        staff1.setPhoneNumber("08068999877");
        staff1.setStaffNumber("L1-0119");
        staff1.setNetPay(230000.456);
        staff1.setDateOfRegistration();
        staffReaders.add(staff1);

        staff2.setFullName("Prosper");
        staff2.setGender('M');
        staff2.setDateOfBirth("19880413");
        staff2.setEmailAddress("prosper.otemuyiwa@andela.com");
        staff2.setPhoneNumber("07089740924");
        staff2.setStaffNumber("L1-0110");
        staff2.setNetPay(230000.456);
        staff2.setDateOfRegistration();
        staffReaders.add(staff2);
       clubMembers.add(staff1);
       clubMembers.add(staff2);


        assertEquals(clubMembers,readersClub.registerMembers(staffReaders,studentReaders));




    }





}
