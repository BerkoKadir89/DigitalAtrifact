package com.mmu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mmu.UserInfo.User;


public class UserTests {


    @Test
    public void AddLogTest() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        user.addlog(72.0);
        assertEquals(72.0, user.getWeight(),0.01);
        assertEquals(1, user.getWeightlog().size());
    }

    @Test
    public void testAddLogMultipleEntries() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        user.addlog(72.0);
        user.addlog(73.0);
        assertEquals(73.0, user.getWeight(),0.01);
        assertEquals(72.0, (double) user.getWeightlog().get(0),0.01);
        assertEquals(2, user.getWeightlog().size());
    }

    @Test
    public void testAddLogWithZeroWeight() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        user.addlog(0.0);
        assertEquals(0.0, user.getWeight(),0.01);
        assertEquals(1, user.getWeightlog().size());
    }

    @Test
    public void testIsMatchCorrectCredentials() {
        assertTrue(User.isMatch("root", "admin"));
    }

    @Test
    public void testIsMatchIncorrectPassword() {
        assertFalse(User.isMatch("wrongpassword", "admin"));
    }

    @Test
    public void testIsMatchIncorrectUsername() {
        assertFalse(User.isMatch("root", "user"));
    }

    @Test
    public void testIsMatchBothIncorrect() {
        assertFalse(User.isMatch("wrongpassword", "user"));
    }

    @Test
    public void testIsMatchEmptyPassword() {
        assertFalse(User.isMatch("", "admin"));
    }

    @Test
    public void testIsMatchEmptyUsername() {
        assertFalse(User.isMatch("root", ""));
    }

  


}
