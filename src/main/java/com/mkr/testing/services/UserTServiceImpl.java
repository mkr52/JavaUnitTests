package com.mkr.testing.services;

import com.mkr.io.UsersDatabase;
import com.mkr.testing.data.UserRepository;
import com.mkr.testing.models.User;

import java.util.UUID;

public class UserTServiceImpl implements UserTService {

    private final UserRepository userRepository;

    public UserTServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

        User user = new User(firstName, lastName, email, UUID.randomUUID().toString());

        boolean isUserCreated;

        try {
            isUserCreated = userRepository.save(user);
        } catch (RuntimeException e) {
            throw new UserServiceException((e.getMessage()));
        }

        if(!isUserCreated) throw new UserServiceException("Could not create user")
;
        return user;

    }
}
