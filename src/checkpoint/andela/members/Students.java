package checkpoint.andela.members;

/**
 * Represents student information.
 */
public class Students {

    /**
     * Student Class Properties
     */
    public String studentNumber;

    private String studentClass;

    /**
     * Create a student with default properties
     */
    public Students(){
    }

    /**
     *  Create a student with specific properties
     */
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
