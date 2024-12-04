package com.mmu;

import java.util.Scanner;
import com.mmu.UserInfo.BaseUser;
import com.mmu.UserInfo.User;
import com.mmu.UserInfo.UsersDataStorage;

public class Main {
    private static final String binFile = "test.bin";

    public static void main(String[] args) {

        UsersDataStorage userSystem = new UsersDataStorage();
        Logic logic = new Logic(userSystem);
        // This is just for the banner of Starting screen
        logic.getBanner(); //loads banners loading page
        userSystem.loadUser(binFile); // This loads the users informatiom on text.bin
        System.out.println("");
        System.out.println("      Welcome to MyFitnessBuddy!");
        while (true) {
            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            System.out.println("[1] Login");
            System.out.println("[2] Sign Up");
            System.out.println("[3] Exit App");
            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();

            // This is the logged in page
            if (option == 1) {
                scan.nextLine();
                System.out.print("please enter your username: ");
                String username = scan.nextLine();
                System.out.print("please enter your password: ");
                String password = scan.nextLine();
                // this is the admins log in page if they want to make any changes
                if (BaseUser.isMatch(password, username)) {
                    while (true) {
                        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                        System.out.println("[1] Show all users: ");
                        System.out.println("[2] Delete users: ");
                        System.out.println("[3] edit user");
                        System.out.println("[4] Exit App");
                        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                        System.out.print("Please enter an option: ");
                        int adminOption = scan.nextInt();
                        switch (adminOption) {
                            case 1 -> {
                                userSystem.showAllUsers(); // Shows all users that have made an account
                            }

                            case 2 -> {
                                logic.choosingWhatUserToDelete(); // asks user want to delete then deletes 
                            }

                            case 3 -> {
                                logic.editingUsersInfo(); // method to edits the users info

                            }
                            case 4 -> {
                                return; //Ends the code
                            }

                            default -> {
                                System.out.println("invalid option please pick from [1-4]");
                            }

                        }
                    }

                } else {
                    // This is a checker to make sure the user enters the correct username
                    User user = userSystem.login(username, password);
                    logic.checkingIfUserExist(username, password, user);
                    // logged in users welcome page
                    System.out.println("");
                    System.out.println("          Welcome back " + user.getName());
                    while (true) {
                        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                        System.out.println("[1] Calculate Daily Calorie Intake: ");
                        System.out.println("[2] See Your WorkOut Routine: ");
                        System.out.println("[3] Calculate BMI");
                        System.out.println("[4] Weight tracker");
                        System.out.println("[5] Exit App");
                        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
                        System.out.print("Please enter an option: ");
                        int loggedinOption = scan.nextInt();
                        LoggedInMenu obj = new LoggedInMenu(user);
                        // option 1
                        if (loggedinOption == 1) {
                            logic.bulkingOrCutting(user); //gives daily calorie a user should have to bulk or cut
                        }

                        else if (loggedinOption == 2) {
                            obj.workoutPlanString(); // lists out a plan that the user can follow
                        }

                        else if (loggedinOption == 3) {
                            System.out.println("Your BMI is " + obj.bmiCal()); // gives user there bmi
                        }

                        else if (loggedinOption == 4) {
                            logic.weightTrackerMenu(user, username); //used to log,show and get analysis of weight
                        }

                        else if (loggedinOption == 5) {
                            // Ends the program
                            break;
                        }

                    }
                }
                // This is the sign up page for someone to create an account
            } else if (option == 2) {
                logic.usersSignUp(); // gathers detail and creates a new user
                continue;

            }

            // Ends the whole program
            else if (option == 3) {
                break;
            }

            else {
                System.out.println("Please enter valid value");
            }
            scan.close();
        }

    }
}
