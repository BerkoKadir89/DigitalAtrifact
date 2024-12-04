package com.mmu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mmu.UserInfo.User;
import com.mmu.UserInfo.UsersDataStorage;

public class UsersDataStorageTests {

    // tests if the users info gets updated when changed
    @Test
    public void updateUserTest() {
        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("test", "TestUser", "password", 175, 70, 20, "male");
        userData.addUser(user, "TestUser");
        User Updateduser = new User("Berko", "BerkoKadir", "Diako8989", 175, 70, 20, "male");
        userData.updateUser("TestUser", Updateduser);
        User retrievedUser = userData.getUsers().get("TestUser");
        assertEquals("Berko", retrievedUser.getName());
        assertEquals("BerkoKadir", retrievedUser.getUsername());
        assertEquals("Diako8989", retrievedUser.getPassword());
        assertEquals(175, retrievedUser.getHeight(), 0.001);
        assertEquals(70, retrievedUser.getWeight(), 0.001);
        assertEquals(20, retrievedUser.getAge(), 0.001);
        assertEquals("male", retrievedUser.getGender());
    }

    // attempts to update a user without that does not exist and should return null
    @Test
    public void updateNonUserTest() {

        UsersDataStorage userData = new UsersDataStorage();
        User user = new User("Berko", "BerkoKadir", "Diako8989", 175, 70, 20, "male");
        userData.updateUser("Non-User", user);
        assertNull(userData.getUsers().get("Non-User"));
    }

    // Tests if the user is saved by loading the user after
    @Test
    public void savingAndLoadingUserTest() {
        User user = new User("berko", "Diako", "diako", 175, 87, 20, "male");

        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, user.getUsername());
        data.saveUser("text.bin");

        UsersDataStorage loadeData = new UsersDataStorage();
        loadeData.loadUser("text.bin");

        assertEquals(1, loadeData.getUsers().size());
        assertEquals("berko", data.getUsers().get(user.getUsername()).getName());
        assertEquals("Diako", data.getUsers().get(user.getUsername()).getUsername());
        assertEquals("diako", data.getUsers().get(user.getUsername()).getPassword());
        assertEquals(175, data.getUsers().get(user.getUsername()).getHeight(), 0.001);
        assertEquals(87, data.getUsers().get(user.getUsername()).getWeight(), 0.001);
        assertEquals("male", data.getUsers().get(user.getUsername()).getGender());

    }

    @Test
    public void deleteAllUsers() {
        User user1 = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        User user2 = new User("berko", "Diako", "diako", 175, 87, 20, "male");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user2, user2.getUsername());
        data.addUser(user1, user1.getUsername());
        data.deleteAll();
        assertEquals(0, data.getUsers().size());

    }

    @Test
    public void deleteNoUsers() {

        UsersDataStorage data = new UsersDataStorage();
        data.deleteAll();
        assertTrue(data.getUsers().isEmpty());

    }

    @Test
    public void testLoginWithInvalidUsername() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Berko");
        assertNull(data.login("WrongUsername", "Diako"));
    }

    @Test
    public void testLoginWithInvalidPassword() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "berko");
        assertNull(data.login("Berko", "WrongPassword"));
    }

    @Test
    public void testLoginWithNullUsername() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Berko");
        assertNull(data.login(null, "Diako"));
    }

    @Test
    public void testLoginWithNullPassword() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Berko");
        assertNull(data.login("Berko", null));
    }

    @Test
    public void testLoginWithEmptyUsername() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Berko");
        assertNull(data.login("", "Diako"));
    }

    @Test
    public void testLoginWithEmptyPassword() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Berko");
        assertNull(data.login("Berko", ""));
    }

    @Test
    public void testAddUser() {
        User user = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Berko");
        assertNotNull(data.getUsers().get("Berko"));
        assertEquals("berko", data.getUsers().get("Berko").getName());
    }

    @Test
    public void testAddMultipleUsers() {
        User user1 = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        User user2 = new User("berko", "Berko", "Diako", 190, 46, 20, "male");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user1, "user1");
        data.addUser(user2, "user2");

        assertEquals(2, data.getUsers().size());
        assertEquals("diako", data.getUsers().get("user1").getName());
        assertEquals("berko", data.getUsers().get("user2").getName());
    }

    @Test
    public void testRemoveUser() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        data.removeUser("Diako");
        assertNull(data.removeUser("Diako"));
    }

    @Test
    public void testRemoveNonExistentUser() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        assertNull(data.removeUser("nonExistentUser"));
    }

    @Test
    public void testRemoveUserFromEmptyStorage() {
        UsersDataStorage data = new UsersDataStorage();
        assertNull(data.removeUser("NoUsersAvailable"));
    }

    @Test
    public void testShowUser() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        String userInfo = data.showUser("Diako");
        assertNotNull(userInfo);
        assertTrue(userInfo.contains("diako"));
        assertTrue(userInfo.contains("21"));
        assertTrue(userInfo.contains("180.0"));
        assertTrue(userInfo.contains("70.0"));
        assertTrue(userInfo.contains("female"));
    }

    @Test
    public void testEditUsersName() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        data.editUsersName("NewName", "Diako");
        assertNotNull(data.getUsers().get("Diako"));
        assertEquals("NewName", data.getUsers().get("Diako").getName());
    }

    @Test
    public void testNonExistentUser() {
        UsersDataStorage data = new UsersDataStorage();
        data.editUsersName("Diako", "nonExistentUser");
        assertNull(data.getUsers().get("nonExistentUser"));
    }

    @Test
    public void testEditUsersNameWithEmptyUsername() {
        UsersDataStorage data = new UsersDataStorage();
        data.editUsersName("NewName", "");
        assertNull(data.getUsers().get(""));
    }

    @Test
    public void testEditUsersNameWithNullNewName() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        data.editUsersName(null, "Diako");
        assertNotNull(data.getUsers().get("Diako"));
        assertNull(data.getUsers().get("Diako").getName());
    }

    @Test
    public void testEditUsersNameWithEmptyNewName() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        data.editUsersName("", "Diako");
        assertNotNull(data.getUsers().get("Diako"));
        assertEquals("", data.getUsers().get("Diako").getName());
    }

    @Test
    public void testUserCheckerWithExistingUser() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        assertTrue(data.userChecker("Diako"));
    }

    @Test
    public void testUserCheckerWithNonExistentUser() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        assertFalse(data.userChecker("nonExistentUser"));
    }

    @Test
    public void testUserCheckerWithEmptyUsername() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        assertFalse(data.userChecker(""));
    }

    @Test
    public void testUserCheckerAfterDeletingUser() {
        User user = new User("diako", "Diako", "Berko", 180, 70, 21, "female");
        UsersDataStorage data = new UsersDataStorage();
        data.addUser(user, "Diako");
        data.removeUser("Diako");
        assertFalse(data.userChecker("Diako"));
    }
}
