package checkpoint.andela.members;

import checkpoint.andela.main.*;


/**
 * Represents staff information.
 */

public class Staff extends Member{

    /**
     * Staff Class Properties
     */

    private String staffNumber;

    private double netPay;

    /**
     * Create a new staff with default properties
     */

    public Staff(){
    }

    /**
     *  Create a new staff with specific properties
     */

    public Staff (String fullName,char gender,String dateOfBirth, String emailAddress, String phoneNumber,
                  String staffNumber,double netPay){

        super(fullName, gender, dateOfBirth, emailAddress, phoneNumber);

        this.staffNumber = staffNumber;

        this.netPay = netPay;
    }

    public String getStaffNumber() {

        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {

        this.staffNumber = staffNumber;
    }

    public double getNetPay() {

        return netPay;
    }

    public void setNetPay(double netPay) {

        this.netPay = netPay;
    }

    public void assignToStudent(String studentNo){
    }

}
