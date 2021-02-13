public class Trainer extends Person  { //creates public class labelled Trainer which extends the Person Class
    private String specialty; //declares a private field of type String labelled specialty which will be declared in the Trainer constructor.

    /*declares public Constructor Trainer which takes in a number of String fields - email, name, address, gender, specialty.
    The email, name, address and gender fields are taken from the Person superclass.
    Also takes in the setSpecialty setter which sets specialty field as the value of specialty.*/
    public Trainer(String email, String name, String address,
                  String gender, String specialty) {
        super(email, name, address, gender);
        /*takes fields of email, name, address and gender along with their associated getters & setters from the Person superclass
        and incorporates them into the Trainer Constructor.*/
        setSpecialty(specialty); //takes setSpecialty setter and set field specialty as the value of specialty
    }

    //getter for String specialty. Returns specialty with no changes.
    public String getSpecialty(String specialty) {
        return specialty;
    }

    //setter for String specialty - sets the value of string specialty as specialty with no changes.
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /*String toString method - method which converts into all fields into a printable String.
    returns the toString method from the Person superclass which takes in the name, email, address & gender fields.
    Method also converts the specialty field to String and adds it to the end of the super.toString.*/
    public String toString() {
        return super.toString() + "Specialty: " + specialty;
    }
}
