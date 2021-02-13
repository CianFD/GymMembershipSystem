
/*creates public class StudentMember,
which extends the Member class,
which in turn extends the Person Class.*/
public class StudentMember extends Member  {
    private String studentId; //declares private variable student Id as type String.
    private String collegeName; //declares private variable collegeName as type String.

    /*public constructor for StudentMember.
    - constructor takes in a number of string variables - email, name, address, gender, chosenPackage, studentId and collegeName.
    - constructor takes in 2 float variables - height and startWeight.*/
    public StudentMember (String email, String name, String address,
                          String gender, float height, float startWeight,
                          String chosenPackage, String studentId, String collegeName) {
        super(email, name, address, gender, height, startWeight, chosenPackage);
        /*takes fields of email, name, address and gender along with their associated getters & setters from the Person superclass,
        and incorporates them into the StudentMember Constructor.
        takes fields of height and startWeight along with their associated getters & setters from the Member superclass,
        and incorporates them into the StudentMember Constructor.*/
        setStudentId(studentId); //takes in setStudentId setter to set the value of the variable studentId as studentId.
        setCollegeName(collegeName); //takes in setCollegeName setter to set the value of the variable collegeName as collegeName.
    }

    public String getStudentId() { //getter for variable StudentId - returns studentId with no changes.
        return studentId;
    }

    public void setStudentId(String studentId) { //setter for variable studentId - sets value of studentId as studentId with no changes.
        this.studentId = studentId;
    }

    public String getCollegeName() { //getter for variable getCollegeName - returns collegeName with no changes.
        return collegeName;
    }
    public void setCollegeName(String collegeName) { //setter for variable setCollegeName - sets value of collegeName as collegeName with no changes.
        this.collegeName = collegeName;
    }

    public void chosenPackage(String packageChoice) {
        packageChoice = packageChoice;
    }

    /*String toString method - method which converts into all fields into a String.
    returns the toString method from the Person superclass which takes in the name, email, address & gender fields.
    Method also converts the studentId and collegeName fields to String and adds them to the end of the super.toString.*/
    public String toString() {
        return super.toString() + "Student ID: " + studentId
                                + "College Name: " + collegeName;
    }
}
