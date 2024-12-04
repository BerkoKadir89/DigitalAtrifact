package com.mmu.UserInfo;


import java.util.HashMap;

public class User extends BaseUser  {
    private double height;
    private double weight; // current weight
    private int age;
    private String gender;
    private HashMap<Integer, Double> weightlog; // for the new weight added
    private int counter;

    public User(String name, String username, String password, double height, double weight, int age, String gender) {
        super(name, username, password);

        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.weightlog = new HashMap<>();
        this.counter = 0;

    }

    //putting the new weight in a hashmap with a counter for each new weight
    public void addlog(Double weights) {

        weightlog.put(counter, weights);
        this.weight = weights;
        counter++;

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public HashMap<Integer, Double> getWeightlog() {
        return weightlog;
    }

    public void setWeightlog(HashMap<Integer, Double> weightlog) {
        this.weightlog = weightlog;
    }

    // This is how the users details will be shown
    @Override
    public String toString() {
        return "User [name=" + name + ", height=" + height + ", weight=" + weight + ", age=" + age + ", gender ="
                + gender + "]";
    }

}