package com.mkr.serviceTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(1)
public class UserServiceTest {

    @BeforeAll
    static void setup() {
        System.out.println("Tests methods related to User Service");
    }

    @Test
    void testCreateUser_whenUserNameIsNull_throwsUserServiceException() {

    }
}
