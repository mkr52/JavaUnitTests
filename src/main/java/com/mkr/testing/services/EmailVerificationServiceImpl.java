package com.mkr.testing.services;

import com.mkr.testing.models.User;

public class EmailVerificationServiceImpl implements EmailVerificationService {
    @Override
    public void scheduleEmailVerification(User user) {
        // Put user details into the email queue for verification
    }
}
