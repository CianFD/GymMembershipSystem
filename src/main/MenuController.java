import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {

    private GymAPI gymAPI;
    private int memberId;

    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        MenuController a = new MenuController();
    }

    public MenuController() {
        gymAPI = new GymAPI();
        runMenu();
    }

    private char mainMenu() {
        System.out.println("  Welcome to VirtuGym");
        System.out.println("  -------------");
        System.out.println("  Main Menu");
        System.out.println("  -------------");
        System.out.println("  Please choose one of the following options:");
        System.out.println("  -------------");
        System.out.println("  r) Register");
        System.out.println("  l) Login");
        System.out.println("  -------------");
        System.out.println("  e) Exit");
        System.out.print("==>> ");
        char option = input.next().charAt(0);
        return option;
    }

    private char registerMenuA() {
        System.out.println("  Register Menu");
        System.out.println("  -------------");
        System.out.println("  Please advise if you're a Member (m) or Trainer (t)");
        System.out.println("  -------------");
        System.out.println("  m) Member");
        System.out.println("  t) Trainer");
        System.out.println("  -------------");
        System.out.println("  e) Exit");
        System.out.print("==>> ");
        char optionA = input.next().charAt(0);
        return optionA;
    }

    private char loginMenuA() {
        System.out.println("  Login Menu");
        System.out.println("  -------------");
        System.out.println("  Please advise if you're a Member (m) or Trainer (t)");
        System.out.println("  -------------");
        System.out.println("  m) Member");
        System.out.println("  t) Trainer");
        System.out.println("  -------------");
        System.out.println("  e) Exit");
        System.out.print("==>> ");
        char optionB = input.next().charAt(0);
        return optionB;
    }

    private char memberSubMenu() {
        System.out.println("  Member Menu");
        System.out.println("  -------------");
        System.out.println("  What would you like to do?:");
        System.out.println("  -------------");
        System.out.println("  v) View Your Profile");
        System.out.println("  u) Update Your Profile");
        System.out.println("  -------------");
        System.out.println("  e) Exit");
        System.out.print("==>> ");
        char optionC = input.next().charAt(0);
        return optionC;
    }

    private char trainerSubMenu() {
        System.out.println("  Trainer Menu");
        System.out.println("  -------------");
        System.out.println("  What would you like to do?:");
        System.out.println("  -------------");
        System.out.println("  a) Add a New Member");
        System.out.println("  l) List Current Members");
        System.out.println("  s) Search Current Members");
        System.out.println("  -------------");
        System.out.println("  e) Exit");
        System.out.print("==>> ");
        char optionD = input.next().charAt(0);
        return optionD;
    }

    private char searchMembersMenu() {
        System.out.println("  Search Members Menu");
        System.out.println("  -------------");
        System.out.println("  How would you like to Search?");
        System.out.println("  -------------");
        System.out.println("  a) Search Current Members By Email Address");
        System.out.println("  n) Search Current Members By Name");
        System.out.println("  -------------");
        System.out.println("  e) Exit");
        System.out.print("==>> ");
        char optionE = input.next().charAt(0);
        return optionE;


    }

    public void addMember() {
        input.nextLine();
        System.out.print("Enter Your Email Address:  ");
        String email = input.nextLine();
        System.out.print("Enter Your Name:  ");
        String name = input.nextLine();
        System.out.print("Enter Your Address:  ");
        String address = input.nextLine();
        System.out.print("Enter Your Gender (M for Male, F for Female, Any Key for Unspecified): ");
        String gender = input.nextLine();
        System.out.print("Enter Your Height: ");
        float height = input.nextFloat();
        System.out.print("Enter Your Starting Weight: ");
        float startWeight = input.nextFloat();
        input.nextLine();
        System.out.print("Enter Your Chosen Package:  ");
        String chosenPackage = input.nextLine();

        gymAPI.addMember(new Member(email, name, address, gender, height, startWeight, chosenPackage));
    }

    public void searchMembersByEmail() {
        input.nextLine();
        System.out.print("Enter The Member's Email Address:  ");
        String emailEntered = input.nextLine();
        System.out.print(gymAPI.searchMembersByEmail(emailEntered));
    }

    public void searchMembersByName() {
        input.nextLine();
        System.out.print("Enter the Name (or part of the Name) of the Member to Search for:  ");
        String nameEntered = input.nextLine();
        System.out.print(gymAPI.searchMembersByName(nameEntered));
    }

    private void memberLogin(){
        input.nextLine();
        System.out.println("Please enter member email: ");
        String login= input.nextLine();
        if(gymAPI.searchMembersByEmail(login)!=null){
            memberId=gymAPI.memberId(login);
            System.out.println("\n" + "Welcome to VirtuGym" + "\n");
            runMemberSubMenu();
        } else {
            System.out.print("ACCESS DENIED!!!");
            System.exit(0);
        }
    }

    public void loginMember() {
        input.nextLine();
        System.out.print("Enter Your Email Address:  ");
        String emailEntered = input.nextLine();
        for (Member member : gymAPI.getMembers()) {
            if (emailEntered.equals(member.getEmail())) {
                member = gymAPI.searchMembersByEmail(emailEntered);
                System.out.println("\n Welcome to VirtuGym " + member.getName() + "\n");
                runMemberSubMenu();
            }
        }
        System.out.print("ACCESS DENIED!!!");
        System.exit(0);
    }

    public void addTrainer() {
        input.nextLine();
        System.out.print("Enter Your Email Address:  ");
        String email = input.nextLine();
        System.out.print("Enter Your Name:  ");
        String name = input.nextLine();
        System.out.print("Enter Your Address:  ");
        String address = input.nextLine();
        System.out.print("Enter Your Gender (M for Male, F for Female, Any Key for Unspecified): ");
        String gender = input.nextLine();
        System.out.print("Enter your Specialty:  ");
        String specialty = input.nextLine();

        gymAPI.addTrainer(new Trainer(email, name, address, gender, specialty));
    }

    public void loginTrainer() {
        input.nextLine();
        System.out.print("Enter Your Email Address:  ");
        String loginTrainerEmail = input.nextLine();
        for (Trainer trainer : gymAPI.getTrainers()) {
            if (loginTrainerEmail.equals(trainer.getEmail())) {
                runTrainerSubMenu();
            }
        }
        System.out.print("ACCESS DENIED!!!");
        System.exit(0);
    }

    private void runMenu() {
        try {
            gymAPI.loadMembers();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        try {
            gymAPI.loadTrainers();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        char option = mainMenu();
        while (option != 'e') {

            switch (option) {
                case 'r': runRegisterMenuA();
                    break;
                case 'l': runLoginMenuA();
                    break;
                default: System.out.println("Invalid option entered: " + option);
            }

            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }

        try {
            gymAPI.saveMember();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        try {
            gymAPI.saveTrainer();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        System.out.println("Thanks for visiting Virtugym");
        System.out.println("Have a great day");
        System.exit(0);
    }

    private void runRegisterMenuA() {
        char optionA = registerMenuA();
        while (optionA != 'e') {
            switch (optionA) {
                case 'm': addMember();
                    try {
                        gymAPI.saveMember();
                    } catch (Exception e) {
                        System.err.println("Error loading from file" + e);
                    }
                    runMenu();
                    break;
                case 't': addTrainer();
                    try {
                        gymAPI.saveTrainer();
                    } catch (Exception e) {
                        System.err.println("Error loading from file" + e);
                    }
                    runMenu();
                    break;
                default: System.out.println("Invalid option entered: " + optionA);
            }

            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            optionA = registerMenuA();
            mainMenu();
        }

        try {
            gymAPI.saveMember();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        try {
            gymAPI.saveTrainer();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        System.out.println("Thanks for visiting Virtugym");
        System.out.println("Have a great day");
        System.exit(0);
    }

    private void runLoginMenuA() {
        char optionB = loginMenuA();
        while (optionB != 'e') {
            switch (optionB) {
                case 'm': loginMember();
                    break;
                case 't': loginTrainer();
                    break;
                default: System.out.println("Invalid option entered: " + optionB);
            }

            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            optionB = loginMenuA();
        }

        try {
            gymAPI.saveMember();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        try {
            gymAPI.saveTrainer();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        System.out.println("Thanks for visiting Virtugym");
        System.out.println("Have a great day");
        System.exit(0);
    }

    private void runMemberSubMenu() {
        char optionC = memberSubMenu();
        while (optionC != 'e') {
            switch (optionC) {
                case 'v':
                    try{
                        System.out.println(gymAPI.displayMember(memberId));
                    }
                    catch (Exception e) {
                        System.err.println("Unable to get member details, please restart the program and try again");
                    }
                    break;
                case 'u': editMember(memberId);
                    break;
                default: System.out.println("Invalid option entered: " + optionC);
            }

            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            optionC = memberSubMenu();;
        }

        try {
            gymAPI.saveMember();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        try {
            gymAPI.saveTrainer();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        System.out.println("Thanks for visiting Virtugym");
        System.out.println("Have a great day");
        System.exit(0);
    }


    private void runTrainerSubMenu() {
        char optionD = trainerSubMenu();
        while (optionD != 'e') {
            switch (optionD) {
                case 'a': addMember();
                    break;
                case 'l': System.out.print(gymAPI.listMembers());
                    break;
                case 's': runSearchMembersMenu();
                    break;
                default: System.out.println("Invalid option entered: " + optionD);
            }

            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            optionD = trainerSubMenu();;
        }

        try {
            gymAPI.saveMember();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        try {
            gymAPI.saveTrainer();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        System.out.println("Thanks for visiting Virtugym");
        System.out.println("Have a great day");
        System.exit(0);
    }

    private void runSearchMembersMenu() {
        char optionE = searchMembersMenu();
        while (optionE != 'e') {
            switch (optionE) {
                case 'a': searchMembersByEmail();
                    break;
                case 'n': searchMembersByName();
                    break;
                default: System.out.println("Invalid option entered: " + optionE);
            }

            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();
            optionE = searchMembersMenu();
        }

        try {
            gymAPI.saveMember();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        try {
            gymAPI.saveTrainer();
        } catch (Exception e) {
            System.err.println("Error loading from file" + e);
        }
        System.out.println("Thanks for visiting Virtugym");
        System.out.println("Have a great day");
        System.exit(0);
    }

    private void editMember (int memberId) {
        input.nextLine();
        System.out.print("Enter Your Email Address:  ");
        String email = input.nextLine();
        System.out.print("Enter Your Name:  ");
        String name = input.nextLine();
        System.out.print("Enter Your Address:  ");
        String address = input.nextLine();
        System.out.print("Enter Your Gender (M for Male, F for Female, Any Key for Unspecified): ");
        String gender = input.nextLine();
        System.out.print("Enter Your Height: ");
        float height = input.nextFloat();
        System.out.print("Enter Your Starting Weight: ");
        float startWeight = input.nextFloat();
        input.nextLine();
        System.out.print("Enter Your Chosen Package:  ");
        String chosenPackage = input.nextLine();

        Member member = gymAPI.getMembers().get(memberId);
        member.setEmail(email);
        member.setName(name);
        member.setAddress(address);
        member.setGender(gender);
        member.setHeight(height);
        member.setStartWeight(startWeight);
        member.setChosenPackage(chosenPackage);
    }
}
