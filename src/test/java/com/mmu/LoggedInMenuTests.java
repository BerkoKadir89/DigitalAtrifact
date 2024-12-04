package com.mmu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mmu.UserInfo.User;
import com.mmu.UserInfo.UsersDataStorage;

public class LoggedInMenuTests {

    @Test
    public void testDailyCalorieCalMaleActivityLevel1() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "male");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedCalories = (((10 * 70) + (6.25 * 175) - (5 * 20)) + 5) * 1.25;
        assertEquals(expectedCalories, logged.dailyCalorieCal(1), 0.01);
    }

    @Test
    public void testDailyCalorieCalMaleActivityLevel2() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "male");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedCalories = (((10 * 70) + (6.25 * 175) - (5 * 20)) + 5) * 1.375;
        assertEquals(expectedCalories, logged.dailyCalorieCal(2), 0.01);
    }

    @Test
    public void testDailyCalorieCalMaleActivityLevel3() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "male");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedCalories = (((10 * 70) + (6.25 * 175) - (5 * 20)) + 5) * 1.55;
        assertEquals(expectedCalories, logged.dailyCalorieCal(3), 0.01);
    }

    @Test
    public void testDailyCalorieCalMaleActivityLevel4() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "male");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedCalories = (((10 * 70) + (6.25 * 175) - (5 * 20)) + 5) * 1.725;
        assertEquals(expectedCalories, logged.dailyCalorieCal(4), 0.01);
    }

    @Test
    public void testDailyCalorieCalFemaleActivityLevel1() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "female");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedCalories = (((10 * 70) + (6.25 * 175) - (5 * 20)) - 161) * 1.25;
        assertEquals(expectedCalories, logged.dailyCalorieCal(1), 0.01);
    }

    @Test
    public void testDailyCalorieCalFemaleActivityLevel2() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "female");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedCalories = (((10 * 70) + (6.25 * 175) - (5 * 20)) - 161) * 1.375;
        assertEquals(expectedCalories, logged.dailyCalorieCal(2), 0.01);
    }

    @Test
    public void testDailyCalorieCalFemaleActivityLevel3() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "female");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedCalories = (((10 * 70) + (6.25 * 175) - (5 * 20)) - 161) * 1.55;
        assertEquals(expectedCalories, logged.dailyCalorieCal(3), 0.01);
    }

    @Test
    public void testDailyCalorieCalFemaleActivityLevel4() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "female");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedCalories = (((10 * 70) + (6.25 * 175) - (5 * 20)) - 161) * 1.725;
        assertEquals(expectedCalories, logged.dailyCalorieCal(4), 0.01);
    }

    @Test
    public void testDailyCalorieCalInvalidActivityLevel() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "female");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        assertEquals(-1, logged.dailyCalorieCal(0), 0.01);
        assertEquals(-1, logged.dailyCalorieCal(5), 0.01);
    }

    @Test
    public void bmiCalTest() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "female");
        userData.addUser(user, "BerkoKadir");
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedBmi = 70 / Math.pow(175 / 100.0, 2);
        assertEquals(expectedBmi, logged.bmiCal(), 0.01);
    }

    @Test
    public void weightAnalysisTest() {
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "male");
        user.addlog(70.0);
        user.addlog(72.0);
        user.addlog(71.0);
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedChange = 71.0 - 70.0;
        assertEquals(expectedChange, logged.weightAnalysis(), 0.01);

    }

    @Test
    public void weightAnalysisNegatveTest() {
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "male");
        user.addlog(70.0);
        user.addlog(72.0);
        user.addlog(69.0);
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedChange = 69.0 - 70.0;
        assertEquals(expectedChange, logged.weightAnalysis(), 0.01);

    }

    @Test
    public void weightAnalysisNoChangeTest() {
        User user = new User("Berko", "BerkoKadir", "password", 175, 70, 20, "male");
        user.addlog(70.0);
        user.addlog(70.0);
        LoggedInMenu logged = new LoggedInMenu(user);
        double expectedChange = 70.0 - 70.0;
        assertEquals(expectedChange, logged.weightAnalysis(), 0.01);

    }

}
