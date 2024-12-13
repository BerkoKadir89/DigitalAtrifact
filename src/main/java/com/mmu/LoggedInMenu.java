package com.mmu;

import com.mmu.UserInfo.User;

public class LoggedInMenu {

    private User user;

    public LoggedInMenu(User user) {
        this.user = user;
    }

    // calculates the daily calories
    public double dailyCalorieCal(int activityLevel) {

        if (user.getGender().toLowerCase().trim().equals("male")) {
            double mBMR = (((10 * user.getWeight()) + (6.25 * user.getHeight())) - (5 * user.getAge())) + 5;
            switch (activityLevel) {
                case 1 -> {
                    return mBMR * 1.25;
                }
                case 2 -> {
                    return mBMR * 1.375;
                }
                case 3 -> {
                    return mBMR * 1.55;
                }
                case 4 -> {
                    return mBMR * 1.725;
                }
                default -> {
                    return -1;
                }
            }

        } else if (user.getGender().toLowerCase().trim().equals("female")) {
            double fBMR = (((10 * user.getWeight()) + (6.25 * user.getHeight())) - (5 * user.getAge())) - 161;
            switch (activityLevel) {
                case 1 -> {
                    return fBMR * 1.25;
                }
                case 2 -> {
                    return fBMR * 1.375;
                }
                case 3 -> {
                    return fBMR * 1.55;
                }
                case 4 -> {
                    return fBMR * 1.725;
                }
                default -> {
                    return -1;
                }
            }

        }
        return -1;

    }

    public final static String[][] workout = {
            { "", "", "", "", "" },
            { "Bench Press", "Incline Dumbell Press", "Cable Flies", "Pec Fly Machine", "Dips" }, // Day 0,
            { "Pull Ups", "Rows", "Lat Pullovers", "Lat Pulldowns", "Seated Rows" }, // Day 1
            { "Squats", "Bulgarian Squats", "Leg Press", "Leg Curls", "Hamstring Curls" }, // Day 2
            { "Shoulder Press", "Lateral Raises", "Shrugs", "Shoulder Raises", " Crunches" }, // Day 3
            { "Bicep Curls", "Hammer Curls", "Tricep Extention", "Tricep Pulldowns", "Neck Curls" }, // Day 4
    };

    // shows the workout
    public void workoutPlanString() {
        for (int i = 1; i < workout.length; i++) {

            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            System.out.println("Day " + i);
            System.out.println(" ");
            for (int j = 0; j < workout[i].length; j++) {
                System.out.println(workout[i][j]);
            }
            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");

        }
    }

    // caluclates the BMI
    public double bmiCal() {
        return user.getWeight() / Math.pow(user.getHeight() / 100, 2);

    }

    // shows weight change from when first started
    public double weightAnalysis() {

        double weightChange = user.getWeightlog().get(user.getWeightlog().size() - 1) - user.getWeightlog().get(0);
        return weightChange;

    }

}
