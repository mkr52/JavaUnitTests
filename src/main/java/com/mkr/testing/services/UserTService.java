package com.mkr.testing.services;

import com.mkr.testing.models.User;

public interface UserTService {

    User createUser(String firstName, String lastName, String email, String password, String repeatedPassword);

}
