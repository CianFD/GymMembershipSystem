/*creates public class Member, which extends the Person class.
 Member declares 3 variables - private float variables height and startWeight
 and private String method chosenPackage.*/

import java.util.HashMap;
import java.util.SortedSet;

public class Member extends Person {
    private float height;
    private float startWeight;
    private String chosenPackage;

    /* Member constructor which takes in a number of variables
       /*takes fields of email, name, address and gender along with their associated getters & setters from the Person superclass,
        and incorporates them into the Member Constructor.,
       String chosenPackage and float variables height and startWeight are taken in from current Member class.
       The setters for each of the Member variables height, startWeight and chosenPackage are declared here.*/

    public Member(String email, String name, String address,
                  String gender, float height, float startWeight, String chosenPackage) {
        super(email, name, address, gender);
        /*takes fields of email, name, address and gender along with their associated getters & setters from the Person superclass,
        and incorporates them into the PremiumMember Constructor.*/
        setHeight(height); //takes in setHeight method with value of height.
        setStartWeight(startWeight); //takes in setStartWeight with value of startWeight.
        setChosenPackage(chosenPackage); //takes in chosenPackage with value of chosenPackage
    }

    public float getHeight() {
        return height;
    } //getter for float variable height - returns height with no changes.

    /*setter for float variable height.
    Declares if value entered for height is greater than or equal to 1 and less than or equal to 3
    sets this height as the value of height.
    else if value entered for height is outside this range it sets value of height as 2.*/
    public void setHeight(float height) {
        if ((height >= 1) && (height <= 3)) {
            this.height = height;
        }
        else {
            this.height = 2;
        }
    }

    public float getStartWeight() {
        return startWeight;
    } //getter for float variable startWeight - returns startWeight with no changes.

    /*setter for float variable startWeight.
    Declares if value entered is greater than or equal 35.0 and less than or equal to 250.0,
    sets this value as the value of height.
    If value entered is outside this range, the value of weight is set at 100.
     */
    public void setStartWeight(float startWeight) {
        if ((startWeight >= 35.0) && (startWeight <= 250.0)) {
            this.startWeight = startWeight;
        }
        else {
            this.startWeight = 100;
        }
    }

    public String getChosenPackage() {
        return chosenPackage;
    } //getter for chosenPackage, returns chosenPackage as chosenPackage with no changes.

    public void setChosenPackage(String chosenPackage) {
        this.chosenPackage = chosenPackage;
    } //setter for chosenPackage, sets value of chosenPackage as chosenPackage with no changes.

    public Assessment latestAssessment() {
        return null;
    }

    public SortedSet<String> sortedAssessmentDates() {
        return sortedAssessmentDates();
    }

    /*String toString method - method which converts into all fields into a printable String.
    returns the toString method from the Person superclass which takes in the name, email, address & gender fields.
    Method also converts the height, startWeight and chosenPackage fields to String and adds it to the end of the super.toString.*/
    public String toString() {
        return super.toString() + "Height: " + height
                                + "\n Starting Weight: " + startWeight
                                + "\n Chosen Package: " + chosenPackage
                                + "\n ";
    }

    private HashMap<String, String>Assessments;
}

