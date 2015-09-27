package checkpoint.andela.members;

/**
 * Created by GRACE on 9/27/2015.
 */
public class Students {

    /**
     * Book Class Properties
     */
    public String studentNumber;
    private String studentClass;

    /**
     * Default Constructor
     */

    public Students(){
    }

    /**
     *  Constructor to set up Values
     */
    public Students (String studentNumber, String studentClass){
        this.studentNumber  =  studentNumber;
        this.studentClass = studentClass;
    }

    // Get the Student Number
    public String getStudentNumber() {
        return studentNumber;
    }

    //Set the Student Number
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    // Get the Student Class
    public String getStudentClass() {
        return studentClass;
    }

    // Set the Student Class
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }


}
