package com.mkr.testing.services;

import com.mkr.testing.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject() {
        // Arrange
        UserTService userService = new UserTServiceImpl();
        // This is a placeholder for the actual user details that would be provided
        // in a real test scenario, such as a User object or user details map.
        String firstName = "John";
        String lastName = "Dow";
        String email = "JDow@gemail.com";
        String password = "password123";
        String repeatedPassword = "password123";

        //Act
        User createdUser = userService.createUser(firstName, lastName, email, password, repeatedPassword);

        // Assert
        assertNotNull(createdUser, "Created user should not be null");

    }
}
