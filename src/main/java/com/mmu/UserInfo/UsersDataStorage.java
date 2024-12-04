package com.mmu.UserInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class UsersDataStorage {

    private int count; // this count is used to act as a key for the weights
    private Map<String, User> users;

    public UsersDataStorage() {

        this.count = 0;
        this.users = new HashMap<>();

    }

    public void updateUser(String username, User updatedUser) {
        users.replace(username, updatedUser);
    }

    // Saving the user infomation
    public void saveUser(String file) {
        try {
            FileOutputStream files = new FileOutputStream(new File(file));
            ObjectOutputStream out = new ObjectOutputStream(files);
            out.writeObject(users);
            files.close();
            out.close();

            // this is an Excpetion that if the file is not found and the IoExcpetion is it
            // failed to write or load the file
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error initializing stream");
        }

    }

    // Clears the hashmap of all Users
    public void deleteAll() {
        this.users.clear();
    }

    // Loads the users infomation
    // Supress the warning from loadind the user info
    @SuppressWarnings("unchecked")
    public void loadUser(String file) {

        try {
            FileInputStream inputFile = new FileInputStream(new File(file));
            ObjectInputStream out2 = new ObjectInputStream(inputFile);
            users = (Map<String, User>) out2.readObject();
            out2.close();

            // When reading from a stream if an object doesnt have or match a class it will
            // create an exception
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {

            System.out.println("Class was not found");
        }
    }

    // this is login authenticar
    public User login(String username, String password) {

        User loged = users.get(username);
        if (loged != null && loged.getPassword().equals(password)) {
            return loged;
        } else {
            return null;
        }

    }

    public void addUser(User user, String username) {

        this.users.put(username, user);

    }

    public User removeUser(String username) {

        return users.remove(username);

    }

    public String showUser(String username) {

        return users.get(username).toString();

    }

    public void showAllUsers() {
        for (Map.Entry<String, User> item : users.entrySet()) {
            System.out.println(item.toString()); // prints out list of all users
        }
    }

    // These are the proccess of editing the values by setting the new value
    public void editUsersName(String newName, String username) {
        User userobj = users.get(username);
        if (userobj != null) {
            userobj.setName(newName);
        } else {
            System.out.println("User not found");
        }
    }

    public void editUsersAge(int newAge, String username) {
        User userobj = users.get(username);
        if (userobj != null) {
            userobj.setAge(newAge);
        } else {
            System.out.println("User not found");
        }
    }

    public void editUsersHeight(double height, String username) {
        User userobj = users.get(username);
        if (userobj != null) {
            userobj.setHeight(height);
        } else {
            System.out.println("User not found");
        }
    }

    public void editUsersWeight(double newWeight, String username) {
        User userobj = users.get(username);
        if (userobj != null) {
            userobj.setWeight(newWeight);
        } else {
            System.out.println("User not found");
        }
    }

    public void editUsersGender(String newGender, String username) {
        User userobj = users.get(username);
        if (userobj != null) {
            userobj.setGender(newGender.toLowerCase().trim());
        } else {
            System.out.println("User not found");
        }
    }

    // this will check if the user exists for the admin to make changes
    public boolean userChecker(String username) {

        if (users.containsKey(username)) {
            return true;
        } else {
            return false;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUser(Map<String, User> users) {
        this.users = users;
    }

}
