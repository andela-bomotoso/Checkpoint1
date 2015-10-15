package checkpoint.andela.members;

import checkpoint.andela.main.Member;

/**
 * Represents student information.
 */

public class Student extends Member {

    /**
     * Student Class Properties
     */

    public String studentNumber;

    private String studentClass;

    /**
     * Create a student with default properties
     */
    public Student(){
    }

    /**
     *  Create a student with specific properties
     */

    public Student(String fullName, char gender, String dateOfBirth, String emailAddress, String phoneNumber,
                   String studentNumber, String studentClass){
        super(fullName, gender, dateOfBirth, emailAddress, phoneNumber);

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

    @Override
    public int compareTo(Member member) {
        if(member instanceof Staff) {
            return -1;
        }
        return super.compareTo(member);
    }

}
