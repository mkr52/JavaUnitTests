package com.mkr.testing.services;

import com.mkr.testing.models.User;

public class UserTServiceImpl implements UserTService {
    @Override
    public User createUser(
            String firstName,
            String lastName,
            String email,
            String password,
            String repeatedPassword) {

        return new User();

    }
}
