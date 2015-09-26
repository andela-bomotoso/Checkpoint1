package checkpoint.andela.members;
import checkpoint.andela.main.*;

/**
 * Created by GRACE on 9/27/2015.
 */
public class Staff extends Member{

    /**
     * Book Class Properties
     */
    private String staffNumber;
    private double netPay;

    Students student = new Students();

    // Get Staff Number
    public String getStaffNumber() {
        return staffNumber;
    }

    // Set Staff Number
    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    // Get Net Pay
    public double getNetPay() {
        return netPay;
    }

    // Set Net Pay
    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public void assignToStudent(String student){

    }
}
