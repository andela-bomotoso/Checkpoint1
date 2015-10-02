package checkpoint.andela.members;

import checkpoint.andela.main.Member;

import java.util.*;

/**
 * Created by GRACE on 9/29/2015.
 */
public class ReadersClub {

    public static List<Member> clubMembers = new ArrayList<Member>();

    public void registerMembers() {
        //Staff staff2 = new Staff("Prosper", 'M', "19880413", "prosper.otemuyiwa@andela.com", "07089740924", "L1-0110", 230000.456);
        Students student3 = new Students("Obioma", 'F', "19870723", "obioma.ofoomalu@andela.com", "09098765545", "C08-L1-0106", "Class 8");
        Students student2 = new Students("Daniel", 'M', "19880413", "daniel.james@andela.com", "08067241691", "C09L1-0110", "Class 9");
        //Staff staff3 = new Staff("Nad", 'M', "19870723", "nadayar@andela.com", "09098765545", "L1-0106", 98000.676);
        Students student1 = new Students("Grace", 'F', "19860113", "bukola.omotoso@andela.com", "08067241691", "C10-L1-0119", "Class 10");
        //Staff staff1 = new Staff("Tosin", 'M', "19860113", "tosin.adesanya@andela.com", "08068999877", "L1-0119", 230000.456);
        //clubMembers.add(staff1);
        clubMembers.add(student2);
        //clubMembers.add(staff2);
        clubMembers.add(student3);
        clubMembers.add(student1);
        //clubMembers.add(staff3);
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
