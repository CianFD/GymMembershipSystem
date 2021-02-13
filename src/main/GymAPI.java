import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/*declares class GymAPI with 2 private Arraylists.
- Arraylist of class Member taking in the member values.
- Arraylist of class Trainer taking in the trainer values.
 */
public class GymAPI {
    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;
    private ArrayList<Assessment> assessments;

    /*Public GymAPI Constructor which takes in the Member and Trainer Arraylists
    Both Arraylist setters are in-built into this Constructor.
    Arraylist Member is declared with members values.
    Arraylist Trainer is declared with trainers values.*/
    public GymAPI() {
        this.members = new ArrayList<Member>();
        this.trainers = new ArrayList<Trainer>();
    }

    //getter for arraylist Member - returns members
    public ArrayList<Member> getMembers() {
        return members;
    }

    //getter for arraylist Trainer - returns trainers
    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    /*addMember method of return type void. adds a member to the Members Arraylist.
    This method is overridden in the MenuController
    to input the various fields into the Member Constructor
    and save them to the Member Arraylist.*/
    public void addMember(Member member) {
        members.add(member);
    }

    /*addTrainer method of return type void. adds a trainer to the Trainers Arraylist.
    This method is overridden in the MenuController
    to input the various fields into the Trainer Constructor
    and save them to the Trainer Arraylist.*/
    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    /*numberofMembers method - declares if there are members in the Member Arraylist,
    it returns the number of Members currently in the Arraylist.
    If the Arraylist is empty it returns 0.*/
    public int numberOfMembers() {
        if (members.size() != 0) {
            return members.size();
        }
        else {
            return 0;
        }
    }

    /*numberofTrainers method - declares if there are trainers in the Trainer Arraylist,
    it returns the number of Trainers currently in the Arraylist.
    If the Arraylist is empty it returns 0.*/
    public int numberOfTrainers() {
        if (trainers.size() != 0) {
            return trainers.size();
        }
        else {
            return 0;
        }
    }

    /*isValid MemberIndex Method which takes in the Index Number of each Member,
    and has a boolean return type.
    If the index number of the Member is equal to or greater than 0 and less than the number of members currently stored in the Member Arraylist,
    it is declared as a valid Index Number, and the method returns true.
    If the Index is less than 0 or greater than the number of members stored in the Arraylist,
    it is declared as an invalid Index and the method returns false.*/
    public boolean isValidMemberIndex(int index) {
        if ((index >= 0) && (index < members.size())) {
            return true;
        }
        else if (index < 0) {
            return false;
        }
        else if (index > members.size()){
            return false;
        }
        else {
            return false;
        }
    }

    /*isValid TrainerIndex Method which takes in the Index Number of each Trainer,
    and has a boolean return type.
    If the index number of the Trainer is equal to or greater than 0 and less than the number of trainers currently stored in the Trainer Arraylist,
    it is declared as a valid Index Number, and the method returns true.
    If the Index is less than 0 or greater than the number of members stored in the Arraylist,
    it is declared as an invalid Index and the method returns false.*/
    public boolean isValidTrainerIndex(int index) {
        if ((index >= 0) && (index < trainers.size())) {
            return true;
        }
        else if (index < 0) {
            return false;
        }
        else if (index > trainers.size()){
            return false;
        }
        else {
            return false;
        }
    }

    /*public listMembers ArrayList Method of Type Member.
    declares listOfMembers as a new Arraylist of type Member.
    If there are members currently in the Member Arraylist
    for each of the members in the Arraylist Member the members details are taken and added to the listOfMembers ArrayList.
    The method then returns the listOfMembers ArrayList.*/
    public ArrayList<Member> listMembers () {
        ArrayList<Member> listOfMembers = new ArrayList<>();
        if (members.size() != 0) {
            for (int i = 0; i < members.size(); i++) {
                listOfMembers.add(members.get(i));
            }
            return listOfMembers;
        }
        return listOfMembers;
    }

    @SuppressWarnings("unchecked")
    public void loadMembers() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        // ------------------ PREVENT SECURITY WARNINGS----------------------------

        Class<?>[] classes = new Class[] { Person.class, Member.class, StudentMember.class, PremiumMember.class, Assessment.class };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        // -------------------------------------------------------------------------

        ObjectInputStream is1 = xstream.createObjectInputStream(new FileReader("members.xml"));
        members = (ArrayList<Member>) is1.readObject();
        is1.close();
    }

    public void loadTrainers() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        // ------------------ PREVENT SECURITY WARNINGS----------------------------

        Class<?>[] classes = new Class[] { Person.class, Trainer.class };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        // -------------------------------------------------------------------------

        ObjectInputStream is2 = xstream.createObjectInputStream(new FileReader("trainers.xml"));
        trainers = (ArrayList<Trainer>) is2.readObject();
        is2.close();
    }

    public void saveMember() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        // ------------------ PREVENT SECURITY WARNINGS-----------------------------

        Class<?>[] classes = new Class[] { Person.class, Member.class, StudentMember.class, PremiumMember.class, Assessment.class };
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        // -------------------------------------------------------------------------

        ObjectOutputStream out1 = xstream.createObjectOutputStream(new FileWriter("members.xml"));
        out1.writeObject(members);
        out1.close();
    }

    public void saveTrainer() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        // ------------------ PREVENT SECURITY WARNINGS-----------------------------

        Class<?>[] classes = new Class[]{Person.class, Trainer.class};
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        // -------------------------------------------------------------------------

        ObjectOutputStream out2 = xstream.createObjectOutputStream(new FileWriter("trainers.xml"));
        out2.writeObject(trainers);
        out2.close();
    }

    /*public method SearchMembersByEmail of type Member which takes in value of String emailEntered.
    if there are members in the Member ArrayList
    for each Member in the Members ArrayList (reads each member in the ArrayList),
    if the email address of the member being read matches the email address entered as the value of emailEntered.
    the corresponding member is returned.
    else if the value of emailEntered doesn't equal any e-mail addresses of the members in the Member ArrayList, it returns null.*/
    public Member searchMembersByEmail (String emailEntered) {
        if (members.size() != 0) {
            for (Member member : members) {
                if (member.getEmail().equals(emailEntered)) {
                    return member;
                }
            }
        }
        return null;
    }

    public int memberId(String emailEntered){
        int index=members.indexOf(searchMembersByEmail(emailEntered));
        return index;
    }

    public String displayMember(int index){
        String memberDisplayed="";
        memberDisplayed=memberDisplayed+index+": "+members.get(index)+"\n";
        return memberDisplayed;
    }

    /*public ArrayList method SearchMembersByName of type String which takes in value of String nameEntered.
    Declares new Arraylist of type String called memberNames.
    if there are members in the Member ArrayList
    for each Member in the Members ArrayList (reads each member in the ArrayList),
    if the name of the member being read matches the name entered as the value of nameEntered,
    or contains the value of nameEntered, the name of that member is added to the memberNames ArrayList.
    Once all Members have been read through the for loop it returns the value of the ArrayList memberNames.
    memberNames is returned whether there is members in the Member ArrayList or not,
    if there are no members currently in the Member Arraylist - memberNames returns an empty ArrayList.*/

    public ArrayList<String> searchMembersByName (String nameEntered) {
        ArrayList<String> memberNames = new ArrayList<>();
        if (members.size() != 0) {
            for (Member member : members) {
                if ((member.getName().contains(nameEntered)) || (member.getName().equals(nameEntered))) {
                    memberNames.add(member.getName());
                }
            }
            return memberNames;
        }
        return memberNames;
    }

    /*public method SearchTrainersByEmail of type Trainer which takes in value of String emailEntered.
    if there are trainers in the Trainer ArrayList
    for each Trainer in the Trainers ArrayList (reads each trainer in the ArrayList),
    if the email address of the trainer being read matches the email address entered as the value of emailEntered.
    the corresponding trainer is returned.
    else if the value of emailEntered doesn't equal any e-mail addresses of the trainers in the Trainer ArrayList, it returns null.*/
    public Trainer searchTrainersByEmail (String emailEntered) {
        if (trainers.size() != 0) {
            for (Trainer trainer : trainers) {
                if (trainer.getEmail().contains(emailEntered)) {
                    return trainer;
                }
            }
        }
        return null;
    }

    /*public ArrayList method SearchTrainersByName of type String which takes in value of String nameEntered.
    Declares new Arraylist of type String called trainerNames.
    if there are trainers in the Trainer ArrayList
    for each Trainer in the Trainer ArrayList (reads each trainer in the ArrayList),
    if the name of the trainer being read matches the name entered as the value of nameEntered,
    or contains the value of nameEntered, the name of that trainer is added to the trainerNames ArrayList.
    Once all Trainers have been read through the for loop it returns the value of the ArrayList trainerNames.
    trainerNames is returned whether there is trainers in the Trainer ArrayList or not,
    if there are no trainers currently in the Trainer Arraylist - trainerNames returns an empty ArrayList.*/
    public ArrayList<String> searchTrainersByName (String nameEntered) {
        ArrayList<String> trainerNames = new ArrayList<>();
        if (trainers.size() != 0) {
            for (Trainer trainer : trainers) {
                if ((trainer.getName().contains(nameEntered)) || (trainer.getName().equals(nameEntered))) {
                    trainerNames.add(trainer.getName());
                }
            }
            return trainerNames;
        }
        return trainerNames;
    }
}