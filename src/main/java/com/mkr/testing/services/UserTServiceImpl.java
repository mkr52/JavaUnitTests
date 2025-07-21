package com.mkr.testing.services;

import com.mkr.testing.models.User;

import java.util.UUID;

public class UserTServiceImpl implements UserTService {
    @Override
    public User createUser(
            String firstName,
            String lastName,
            String email,
            String password,
            String repeatedPassword) {

        if(firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot blank");
        }

        if(email.length() < 8 || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        return new User(firstName, lastName, email, UUID.randomUUID().toString());

    }
}
