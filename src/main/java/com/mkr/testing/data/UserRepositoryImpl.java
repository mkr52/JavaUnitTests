package com.mkr.testing.data;

import com.mkr.testing.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    Map<String, User> users = new HashMap<>();

    @Override
    public boolean save(User user) {

        boolean returnVal = false;

        // Check if the user already exists in the repository
        if(!users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            returnVal = true;
        }
        return returnVal;
    }
}
