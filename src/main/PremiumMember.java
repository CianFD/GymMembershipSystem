/*creates public class PremiumMember,
which extends the Member class,
which in turn extends the Person Class.*/
public class PremiumMember extends Member  {
    /*public constructor for PremiumMember.
    - constructor takes in a number of string variables - email, name, address, gender, chosenPackage, studentId and collegeName.
    - constructor takes in 2 float variables - height and startWeight.*/
    public PremiumMember (String email, String name, String address,
                          String gender, float height, float startWeight,
                          String chosenPackage) {
        super(email, name, address, gender, height, startWeight, chosenPackage);
        /*takes fields of email, name, address and gender along with their associated getters & setters from the Person superclass,
        and incorporates them into the PremiumMember Constructor.
        takes fields of height and startWeight along with their associated getters & setters from the Member superclass,
        and incorporates them into the PremiumMember Constructor.
        PremiumMember class does not declare any further variables so it just copies the fields taken from the Person & Member superclasses.
        */
    }

    public void chosenPackage(String packageChoice) {
        packageChoice = packageChoice;
    }

    /*public toString method which converts the String variables of the PremiumMember constructor to printable output.
    As the PremiumMember class doesn't declare any new variables it prints the same content as the Member class.*/
    public String toString() {
        return super.toString();
    }

}
