package checkpoint.andela.members;

import checkpoint.andela.main.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GRACE on 9/29/2015.
 */
public class ReadersClub {

    public void execute(){
        List<Students> studentReaders = new ArrayList<Students>();

        List<Staff> staffReaders = new ArrayList<Staff>();

        List <Member> clubMembers = new ArrayList<Member>();



        Staff staff1 = new Staff("Tosin",'M',"19860113","tosin.adesanya@andela.com","08068999877","L1-0119",230000.456);
        clubMembers.add(staff1);
        Staff staff2 = new Staff("Prosper",'M',"19880413","prosper.otemuyiwa@andela.com","07089740924","L1-0110",230000.456);
        clubMembers.add(staff2);

        Staff staff3 = new Staff("Nad",'M',"19870723","nadayar@andela.com","09098765545","L1-0106",98000.676);
        clubMembers.add(staff3);
        Students student1 = new Students("Grace",'F',"19860113","bukola.omotoso@andela.com","08067241691","C10-L1-0119","Class 10");
        clubMembers.add(student1);
        Students student2 = new Students("Daniel",'M',"19880413","daniel.james@andela.com","08067241691","C09L1-0110","Class 9");
        clubMembers.add(student2);
        Students student3 = new Students("Obioma",'F',"19870723","obioma.ofoomalu@andela.com","09098765545","C08-L1-0106","Class 8");
        clubMembers.add(student3);
       /* for(Member m: clubMembers)
        {
            System.out.println(m.getFullName()+":\t"+m.getClass().getSimpleName()+"\t "+m.getDateOfRegistration());
        }*/




    }
}
