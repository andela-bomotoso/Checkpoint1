package checkpoint.andela.main;

/**
 * Created by GRACE on 10/4/2015.
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ClubMembershipTestRunner {

    public static void main(String[] args){
        Result result = JUnitCore.runClasses(ClubMembershipTest.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
