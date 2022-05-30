package com.alkemy.disney.services;

import org.springframework.stereotype.Service;


public interface EmailService {

    public void sendWelcomeEmailTo(String username);
}
