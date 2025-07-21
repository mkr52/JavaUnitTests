package com.mkr.testing.services;

import com.mkr.testing.models.User;

public interface EmailVerificationService {
    void scheduleEmailVerification(User user);
}
