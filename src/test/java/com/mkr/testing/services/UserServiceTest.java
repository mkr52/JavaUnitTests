package com.mkr.testing.services;

import com.mkr.testing.data.UserRepository;
import com.mkr.testing.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserTServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    EmailVerificationServiceImpl emailVerificationService;

    String firstName;
    String lastName;
    String email;
    String password;
    String repeatedPassword;

    @BeforeEach
    void init() {
        firstName = "John";
        lastName = "Dow";
        email = "JDow@gemail.com";
        password = "password123";
        repeatedPassword = "password123";
    }

    @DisplayName("User created")
    @Test
    void testCreateUser_whenUserDetailsProvided_returnUserObject() {
        // Arrange
        Mockito.when(userRepository.save(any(User.class))).thenReturn(true);

        //Act
        User createdUser = userService.createUser(firstName, lastName, email, password, repeatedPassword);

        // Assert
        assertNotNull(createdUser, "Created user should not be null");
        assertEquals(firstName, createdUser.getFirstName(),
                "User first name should match the provided first name");
        assertEquals(lastName, createdUser.getLastName(),
                "User last name should match the provided last name");
        assertEquals(email, createdUser.getEmail(),
                "User email should match the provided email");
        assertNotNull(createdUser.getId(), "User ID should not be null");

        Mockito.verify(userRepository, times(1))
                .save(any(User.class));
    }

    @DisplayName("Empty first name throws exception")
    @Test
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange
        firstName = "";
        email = "abv.com";
        String expectedExceptionMessage = "First name cannot blank";

        //Act & Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatedPassword);
        }, "Empty first name should throw an Illegal Argument exception");

        // Assert
        assertEquals(expectedExceptionMessage, thrown.getMessage(), "Exception message should match");
    }

    @DisplayName("Invalid email throws exception")
    @Test
    void testCreateUser_whenEmailIsInvalid_throwsIllegalArgumentException() {
        // Arrange
        email = "abv.com";
        String expectedExceptionMessage = "Invalid email address";

        //Act & Assert
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatedPassword);
        }, "Invalid email should throw an Illegal Argument exception");

        // Assert
        assertEquals(expectedExceptionMessage, thrown.getMessage(), "Exception message should match");
    }

    @DisplayName("If save() method throws RuntimeException, UserServiceException is thrown")
    @Test
    void testCreateUser_whenSaveMethodThrowsException_thenThrowUserServiceException() {
        // Arrange
        when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);

        // Act & Assert
        assertThrows(UserServiceException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatedPassword);
        }, "Should have thrown UserServiceException instead");

        //Assert
    }

    @DisplayName("EmailNotificationException is handled")
    @Test
    void testCreateUser_whenEmailNotificationExceptionThrown_throwsUserServiceException() {
        // Arrange
        when(userRepository.save(any(User.class))).thenReturn(true);

        // for void return methods, we can use doThrow
        doThrow(EmailNotificationServiceException.class)
                .when(emailVerificationService)
                .scheduleEmailVerification(any(User.class));

        // Act & Assert
        assertThrows(UserServiceException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatedPassword);
        }, "Should have thrown UserServiceException instead");

        //Assert
        verify(emailVerificationService, times(1))
                .scheduleEmailVerification(any(User.class));
    }
}
