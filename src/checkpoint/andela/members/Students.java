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

    public Students(){
    }

    public Students (String studentNumber, String studentClass){
        this.studentNumber  =  studentNumber;
        this.studentClass = studentClass;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }


}
