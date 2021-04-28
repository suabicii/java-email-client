package com.potato.controller.services;

import com.potato.EmailManager;
import com.potato.controller.EmailLoginResult;
import com.potato.model.EmailAccount;

public class LoginService {

    EmailAccount emailAccount;
    EmailManager emailManager;

    public LoginService(EmailAccount emailAccount, EmailManager emailManager) {
        this.emailAccount = emailAccount;
        this.emailManager = emailManager;
    }

    public EmailLoginResult login() {
        return null;
    }
}
