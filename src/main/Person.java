/*creates main class Person, all other classes inherit from Person.
  person class declares 4 fields all of which are String - name, gender, email, address.
  all fields are private.*/

public class Person {
    private String email; //declares private String email.
    private String name; //declares private String name.
    private String address; //declares private String address.
    private String gender; //declares private String gender.

    /**
     * setter for String email - takes in the value inputted and sets it as email without changes.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter for String name.
     * Declares if name length is less than or equal to 30 characters then name entered is taken as the value of name.
     * If the name entered is longer than 30 characters then the value of name is declared to be a substring of the first 30 characters entered.
     * @param name
     */
    public void setName(String name) {
       int maxChar = 30; //declares value of 30 for int field maxChar
       if ((name.length() <= maxChar) && (name.length() >= 0)){
            this.name = name;
        }
       else {
           this.name = name.substring(0, 30);
       }
    }

    /**
     * setter for String address - takes in the value inputted and sets it as address without changes.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * setter for String field gender.
     * If value taken in is "F" gender is assigned value of "F".
     * If value taken in is "M" gender is assigned value of "M".
     * If any other value is inputted gender is assigned value "Unspecified".
     * @param gender
     */
    public void setGender(String gender) {
        if ((gender.equals("F")) || (gender.equals("M"))) {
            this.gender = gender;
        }
        else {
            this.gender = "Unspecified";
        }
    }

    /**
     * getter for String variable name - returns name with no changes.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for String variable email - returns email with no changes.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * getter for String variable address - returns address with no changes.
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * getter for String variable gender - returns gender with no changes
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Public Constructor for Person - takes in 4 String variables - email, name, address, gender.
     * Setters for each of the variables are declared as setting their value in the constructor.
     * @param email
     * @param name
     * @param address
     * @param gender
     */
    public Person(String email, String name, String address, String gender) {
        setEmail(email);
        setName(name);
        setAddress(address);
        setGender(gender);
    }

    /**
     * Public toString method which converts the values of each of the Person Class variables into printable output.
     * @return String converts of the Person fields.
     */
    public String toString() {
        return "Email: " + email
                + "\n Name: " + name
                + "\n Address: " + address
                + "\n Gender: " + gender
                + "\n ";
    }
}
