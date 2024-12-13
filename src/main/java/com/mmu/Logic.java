package com.mmu;

import java.util.Scanner;

import com.mmu.UserInfo.User;
import com.mmu.UserInfo.UsersDataStorage;

public class Logic {

    private static final String binFile = "test.bin";
    private Scanner scan = new Scanner(System.in);
    private UsersDataStorage userSystem;

    public Logic(UsersDataStorage userSystem) {
        this.userSystem = userSystem;

    }

    // prints banner for log in screen
    public void getBanner() {
        System.out.println(
                "                  ___       _                                 ___               _      _        \r\n" + //
                        "/'\\_/`\\          (  _`\\  _ ( )_                              (  _`\\            ( )    ( )       \r\n"
                        + //
                        "|     | _   _    | (_(_)(_)| ,_)  ___     __    ___   ___    | (_) ) _   _    _| |   _| | _   _ \r\n"
                        + //
                        "| (_) |( ) ( )   |  _)  | || |  /' _ `\\ /'__`\\/',__)/',__)   |  _ <'( ) ( ) /'_` | /'_` |( ) ( )\r\n"
                        + //
                        "| | | || (_) |   | |    | || |_ | ( ) |(  ___/\\__, \\\\__, \\   | (_) )| (_) |( (_| |( (_| || (_) |\r\n"
                        + //
                        "(_) (_)`\\__, |   (_)    (_)`\\__)(_) (_)`\\____)(____/(____/   (____/'`\\___/'`\\__,_)`\\__,_)`\\__, |\r\n"
                        + //
                        "       ( )_| |                                                                           ( )_| |\r\n"
                        + //
                        "       `\\___/'                                                                           `\\___/'");
    }

    // makes sure user actually exist to delete
    public void choosingWhatUserToDelete() {

        System.out.println("Enter username of user you wish to delete: ");
        String userToDelete = scan.nextLine();
        while (true) {

            if (userSystem.userChecker(userToDelete) == true) {
                break;
            } else {
                System.out.print("this users doesnt exist, try again:");
                userToDelete = scan.nextLine();

            }
        }
        userSystem.removeUser(userToDelete);
        System.out.println(userToDelete + " has been deleted"); // deletes a user
        userSystem.saveUser(binFile);
    }

    // makes sure user actually exist to edit
    public void editingUsersInfo() {
        System.out.println("Enter username of user you wish to edit: ");
        String userToEdit = scan.nextLine();
        while (true) {
            if (userSystem.userChecker(userToEdit) == true) {
                break;
            } else {
                System.out.print("this users doesnt exist, try again:");
                userToEdit = scan.nextLine();
            }
        }
        System.out.println("What would you like to change: ");
        System.out.println("Please do it in the format: Change (What to change) to (newValue)");
        String[] edit = scan.nextLine().toLowerCase().trim().split(" "); // Splits the sentence
                                                                         // giving each word an
                                                                         // index

        // this if/else statement checks the second and last word, and will make the
        // appropiate change
        if (edit[1].equals("name")) {
            userSystem.editUsersName(edit[3], userToEdit);
            System.out.println("Edits have been saved...");
            userSystem.saveUser(binFile);
        } else if (edit[1].equals("age")) {
            userSystem.editUsersAge(Integer.parseInt(edit[3]), userToEdit);
            System.out.println("Edits have been saved...");
            userSystem.saveUser(binFile);
        } else if (edit[1].equals("height")) {
            userSystem.editUsersHeight((double) Integer.parseInt(edit[3]), userToEdit);
            System.out.println("Edits have been saved...");
            userSystem.saveUser(binFile);
        } else if (edit[1].equals("weight")) {
            userSystem.editUsersHeight((double) Integer.parseInt(edit[3]), userToEdit);
            System.out.println("Edits have been saved...");
            userSystem.saveUser(binFile);
        } else if (edit[1].equals("gender")) {
            userSystem.editUsersGender(edit[3], userToEdit);
            System.out.println("Edits have been saved...");
            userSystem.saveUser(binFile);
        }
    }

    // useer checker
    public void checkingIfUserExist(String username, String password, User user) {
        while (user == null) {
            System.out.println("Your Username or password is incorrect");
            System.out.print("please enter your username: ");
            username = scan.nextLine();
            System.out.print("please enter your password: ");
            password = scan.nextLine();
            user = userSystem.login(username, password);
        }
    }

    // logic behind bulkingorcutting
    public void bulkingOrCutting(User user) {
        LoggedInMenu obj = new LoggedInMenu(user);
        System.out.println("Are you Bulking or Cutting?");
        String bulkOrCut = scan.nextLine();
        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        System.out.println("whats your activty level: ");
        System.out.println("[1] little or no exercise ");
        System.out.println("[2] light exercise/sports 1-3 days-week ");
        System.out.println("[3] moderate exercise/sports 3-5 days/week");
        System.out.println("[4] hard exercise/sports 6-7 days a week");
        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        System.out.print("Please enter an option: ");
        int activityLevel = scan.nextInt();
        String bulkOrCutString = bulkOrCut.toLowerCase().trim();
        if (bulkOrCutString.equals("bulking")) {
            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            System.out.println(
                    "Your Daily calorie intake is: " + (obj.dailyCalorieCal(activityLevel) + 200)); // adds
                                                                                                    // 200
                                                                                                    // to
                                                                                                    // maintence
                                                                                                    // calories
            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        } else if (bulkOrCutString.equals("cutting")) {
            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            System.out.println(
                    "Your Daily calorie intake is: " + (obj.dailyCalorieCal(activityLevel) - 200));// minus
                                                                                                   // 200
                                                                                                   // to
                                                                                                   // maintence
                                                                                                   // calories
            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        }

        // users sign up page
    }

    public void usersSignUp() {
        System.out.println("Please enter your Name: ");
        String name = scan.nextLine();
        System.out.println("Please enter your Age: ");
        int age = scan.nextInt();
        System.out.println("Please enter your Height(cm): ");
        Double height = scan.nextDouble();
        System.out.println("Please enter your Weight(kg): ");
        Double weight = scan.nextDouble();
        System.out.println("Please enter your Gender assigned at birth: ");
        scan.nextLine();
        String gender = scan.nextLine();
        System.out.print("Enter your Username:");
        String username = scan.nextLine();
        System.out.print("Enter your password:");
        String password = scan.nextLine();
        User user = new User(name, username, password, height, weight, age, gender);
        userSystem.addUser(user, username);
        userSystem.saveUser(binFile); // saves informatiob is the file "binFile"
    }

    // users weigh analyse page
    public void weightTrackerMenu(User user, String username) {
        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        System.out.println("[1] would you like to log your weight ");
        System.out.println("[2] Show all weights recorded ");
        System.out.println("[3] Check Analyse ");
        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        System.out.print("Please enter an option: ");
        int weightMenuOption = scan.nextInt();
        switch (weightMenuOption) {
            case 1 -> {
                System.out.println("Please enter your weight in kg: ");
                double newWeight = scan.nextDouble();
                user.addlog(newWeight); // adds the new weight to a hashmap
                userSystem.updateUser(username, user);
                userSystem.saveUser(binFile);
                System.out.println("weight logged");

            }
            case 2 -> {
                System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                System.out.println(user.getWeightlog().entrySet()); // gets all the previous weights
                System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");

            }

            case 3 -> {

                LoggedInMenu loggedin = new LoggedInMenu(user);
                System.out.println("since you started, your weight change is "
                        + loggedin.weightAnalysis() + " kg");

            }

            default -> {
                System.out.println("enter a valid value: ");
            }

        }
    }

}
