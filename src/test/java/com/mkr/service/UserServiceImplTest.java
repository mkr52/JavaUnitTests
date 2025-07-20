package com.mkr.service;

import com.mkr.io.UsersDatabase;
import com.mkr.io.UsersDatabaseMapImpl;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {

    UsersDatabase usersDatabase;
    UserService userService;
    String createdUserId="";

    /**
     * No need to use static keyword for setup and cleanup in PER_CLASS Test Instance lifecycle
     */
    @BeforeAll
    void setup() {
        // Create & initialize database
        usersDatabase = new UsersDatabaseMapImpl();
        usersDatabase.init();
        userService = new UserServiceImpl(usersDatabase);
    }

    @AfterAll
    void cleanup() {
        // Close connection
        // Delete database
        usersDatabase.close();
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {

        // Arrange
        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Howard");
        user.put("lastName", "Marks");

        // Act
        createdUserId = userService.createUser(user);

        // Assert
        assertNotNull(createdUserId, "User id should not be null");

    }


    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {

        // Arrange
        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Howzie");
        user.put("lastName", "Marks");

        // Act
        Map updatedUserDetails = userService.updateUser(createdUserId, user);

        // Assert
        assertEquals(user.get("firstName"), updatedUserDetails.get("firstName"),
                "Updated first name is incorrect");

    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails() {

        // Act
        Map userDetails = userService.getUserDetails(createdUserId);

        // Assert
        assertNotNull(createdUserId, "User details should not be null");
        assertEquals(createdUserId, userDetails.get("userId"),
                "Incorrect user id returned");

    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails() {
        // Act
        userService.deleteUser(createdUserId);

        // Assert
        Map userDetails = userService.getUserDetails(createdUserId);
        assertNull(userDetails, "User should be deleted and details should be null");
    }

}
