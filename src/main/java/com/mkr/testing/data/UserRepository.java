package com.mkr.testing.data;

import com.mkr.testing.models.User;

public interface UserRepository {

    boolean save(User user);
}
